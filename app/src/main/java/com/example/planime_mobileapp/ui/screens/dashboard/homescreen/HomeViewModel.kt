package com.example.planime_mobileapp.ui.screens.dashboard.homescreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.planime_mobileapp.data.local.TokenPreferences
import com.example.planime_mobileapp.data.repository.ApiRepositoryImpl
import com.example.planime_mobileapp.domain.usecase.user.plans.GetPlansUseCase
import com.example.planime_mobileapp.domain.usecase.user.profile.ProfileUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val tokenPreferences: TokenPreferences
): ViewModel() {

    private val repository = ApiRepositoryImpl()
    private val getPlansUseCase = GetPlansUseCase(repository, tokenPreferences)
    private val profileUseCase = ProfileUseCase(repository, tokenPreferences)

    private val _state = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState> = _state.asStateFlow()

    init {
        loadTotalUserPlans()
        loadUserName()
    }

    fun loadTotalUserPlans(){
        _state.value = _state.value.copy(isLoading = true, errorMessage = null)

        viewModelScope.launch {
            try {
                val result = getPlansUseCase()

                result.onSuccess { plansResponse  ->
                    val plansList = plansResponse.plans
                    val processedPlans = plansList?.map { plan ->
                        val details = plan.details
                        val planName = plan.name.substringBefore(" ").replaceFirstChar { it.uppercase() }
                        val planDate = details.createdAt.substringBefore("T")
                        PlanItem(name = planName, date = planDate)
                    } ?: emptyList()

                    _state.value = _state.value.copy(
                        isLoading = false,
                        totalPlans = plansList?.size ?: 0,
                        plansList = processedPlans,
                        errorMessage = null
                    )

                }.onFailure { error ->
                    _state.value = _state.value.copy(
                        isLoading = false,
                        errorMessage = error.message ?: "Error al cargar los planes"
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

    fun loadUserName() {
        _state.value = _state.value.copy(isLoading = true, errorMessage = null)

        viewModelScope.launch {
            try {
                val result = profileUseCase()

                result.onSuccess { profile ->
                    _state.value = _state.value.copy(
                        isLoading = false,
                        userName = profile?.firstName ?: "User Name",
                        errorMessage = null
                    )
                }.onFailure { error ->
                    _state.value = _state.value.copy(
                        isLoading = false,
                        errorMessage = error.message ?: "Error al cargar el nombre de usuario"
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
}

data class PlanItem(
    val name: String,
    val date: String
)

data class HomeState(
    val userName: String = "",
    val isLoading: Boolean = false,
    val totalPlans: Int = 0,
    val plansList: List<PlanItem> = emptyList(),
    val errorMessage: String? = null
)
