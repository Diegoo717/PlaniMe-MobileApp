package com.example.planime_mobileapp.ui.screens.dashboard.detailsplan

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.planime_mobileapp.data.local.TokenPreferences
import com.example.planime_mobileapp.data.repository.ApiRepositoryImpl
import com.example.planime_mobileapp.domain.model.user.plans.Plan
import com.example.planime_mobileapp.domain.usecase.user.plans.GetPlansUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import android.app.DownloadManager
import android.content.Context
import android.os.Environment
import androidx.core.net.toUri
import com.example.planime_mobileapp.domain.usecase.user.plans.DeletePlanUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DetailsPlanViewModel(
    private val tokenPreferences: TokenPreferences,
    private val planId: Int,
    private val context: Context
): ViewModel() {

    private val repository = ApiRepositoryImpl()
    private val getPlansUseCase = GetPlansUseCase(repository, tokenPreferences)
    private val deletePlanUseCase = DeletePlanUseCase(repository, tokenPreferences)

    private val _state = MutableStateFlow(DetailsPlanState())
    val state: StateFlow<DetailsPlanState> = _state.asStateFlow()

    init {
        loadPlanDetails()
    }

    private fun loadPlanDetails() {
        _state.value = _state.value.copy(isLoading = true, errorMessage = null)

        viewModelScope.launch {
            try {
                val result = getPlansUseCase()

                result.onSuccess { plansResponse ->
                    val plansList = plansResponse.plans
                    val selectedPlan = plansList?.find { it.details.id == planId }

                    if (selectedPlan != null) {
                        _state.value = _state.value.copy(
                            isLoading = false,
                            plan = selectedPlan,
                            formattedPlanName = formatPlanName(selectedPlan.name),
                            formattedCreatedAt = formatApiDate(selectedPlan.details.createdAt),
                            formattedExpiredAt = selectedPlan.details.createdAt?.let {
                                formatApiDate(calculateExpirationDate(it))
                            } ?: "Fecha no disponible",
                            formattedAge = "${selectedPlan.details.age} años",
                            formattedGender = normalizeGender(selectedPlan.details.gender),
                            formattedWeight = "${selectedPlan.details.weight} kg",
                            formattedHeight = "${selectedPlan.details.height} cm",
                            formattedActivityLevel = normalizeActivityLevel(selectedPlan.details.activityLevel),
                            formattedGoal = normalizeGoal(selectedPlan.details.goal),
                            errorMessage = null
                        )
                    } else {
                        _state.value = _state.value.copy(
                            isLoading = false,
                            errorMessage = "Plan no encontrado"
                        )
                    }

                }.onFailure { error ->
                    _state.value = _state.value.copy(
                        isLoading = false,
                        errorMessage = error.message ?: "Error al cargar los detalles del plan"
                    )
                }

            } catch (e: Exception) {
                _state.value = _state.value.copy(
                    isLoading = false,
                    errorMessage = "Error inesperado: ${e.message}"
                )
            }
        }
    }

    private fun formatPlanName(name: String?): String {
        return name?.substringBefore(" ")?.replaceFirstChar { it.uppercase() } ?: ""
    }

    private fun calculateExpirationDate(createdAt: String): String {
        return try {
            val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
            inputFormat.timeZone = TimeZone.getTimeZone("UTC")
            val date = inputFormat.parse(createdAt)!!

            val calendar = Calendar.getInstance()
            calendar.time = date
            calendar.add(Calendar.DAY_OF_YEAR, 30)

            inputFormat.format(calendar.time)
        } catch (e: Exception) {
            createdAt
        }
    }

    private fun formatApiDate(apiDate: String?): String {
        if (apiDate.isNullOrEmpty()) return "Fecha no disponible"

        return try {
            val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
            inputFormat.timeZone = TimeZone.getTimeZone("UTC")

            val outputFormat = SimpleDateFormat("d 'de' MMMM 'de' yyyy", Locale("es", "ES"))

            val date = inputFormat.parse(apiDate)
            outputFormat.format(date!!)
        } catch (e: Exception) {
            "Fecha inválida"
        }
    }

    private fun normalizeActivityLevel(activityLevel: String?): String {
        return when (activityLevel?.lowercase()) {
            "sedentario" -> "Sedentario"
            "ligero" -> "Ligero (1-2 días/semana)"
            "moderado" -> "Moderado (3-4 días/semana)"
            "activo" -> "Activo (5-6 días/semana)"
            else -> activityLevel ?: ""
        }
    }

    private fun normalizeGoal(goal: String?): String {
        return when (goal?.lowercase()) {
            "perder" -> "Bajar de peso"
            "mantener" -> "Mantener un peso saludable"
            "aumentar" -> "Aumentar masa muscular"
            else -> goal ?: ""
        }
    }

    private fun normalizeGender(gender: String?): String {
        return when (gender?.lowercase()) {
            "m" -> "Masculino"
            "f" -> "Femenino"
            else -> gender ?: ""
        }
    }

    fun onDownloadClick() {
        val imageUrl = state.value.plan?.imageUrl ?: return
        viewModelScope.launch {
            downloadImage(imageUrl)
        }
    }

    private suspend fun downloadImage(imageUrl: String) = withContext(Dispatchers.IO) {
        try {
            val downloadManager = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            val request = DownloadManager.Request(imageUrl.toUri())
                .setTitle("Plan Image Download")
                .setDescription("Downloading plan image")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                .setDestinationInExternalPublicDir(
                    Environment.DIRECTORY_PICTURES,
                    "Planime/${System.currentTimeMillis()}.jpg"
                )
                .setAllowedOverMetered(true)
                .setAllowedOverRoaming(true)

            downloadManager.enqueue(request)
        } catch (e: Exception) {
            _state.value = _state.value.copy(
                errorMessage = "Error al descargar: ${e.message}"
            )
        }
    }

    fun onDeleteClick(planId: Int) {
        _state.value = _state.value.copy(isLoading = true, errorMessage = null)
        viewModelScope.launch {
            try{
                val result = deletePlanUseCase(planId)

                result.onSuccess { plansResponse  ->
                    _state.value = _state.value.copy(
                        isLoading = false,
                        errorMessage = null,
                        successMessage = "Plan eliminado!"
                    )
                }.onFailure { error ->
                    _state.value = _state.value.copy(
                        isLoading = false,
                        errorMessage = error.message ?: "Error al eliminar el plan"
                    )
                }

            }catch(e: Exception){
                _state.value = _state.value.copy(
                    isLoading = false,
                    errorMessage = "Error inesperado: ${e.message}"
                )
            }
        }
    }
}

data class DetailsPlanState(
    val successMessage: String = "",
    val isLoading: Boolean = false,
    val plan: Plan? = null,
    val formattedPlanName: String = "",
    val formattedCreatedAt: String = "",
    val formattedExpiredAt: String = "",
    val formattedAge: String = "",
    val formattedGender: String = "",
    val formattedWeight: String = "",
    val formattedHeight: String = "",
    val formattedActivityLevel: String = "",
    val formattedGoal: String = "",
    val errorMessage: String? = null
)