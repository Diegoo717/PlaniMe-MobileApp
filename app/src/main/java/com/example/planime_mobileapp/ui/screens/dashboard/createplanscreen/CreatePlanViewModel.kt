package com.example.planime_mobileapp.ui.screens.dashboard.createplanscreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.planime_mobileapp.data.local.TokenPreferences
import com.example.planime_mobileapp.data.repository.ApiRepositoryImpl
import com.example.planime_mobileapp.domain.usecase.user.plans.CreatePlanUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CreatePlanViewModel(
    private val tokenPreferences: TokenPreferences
) : ViewModel() {

    private val repository = ApiRepositoryImpl()
    private val createPlanUseCase = CreatePlanUseCase(repository, tokenPreferences)

    private val _uiState = MutableStateFlow(CreatePlanUiState())
    val uiState: StateFlow<CreatePlanUiState> = _uiState.asStateFlow()

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    fun updateAge(age: String) {
        _uiState.value = _uiState.value.copy(
            age = age,
            ageError = null
        )
    }

    fun updateWeight(weight: String) {
        _uiState.value = _uiState.value.copy(
            weight = weight,
            weightError = null
        )
    }

    fun updateHeight(height: String) {
        _uiState.value = _uiState.value.copy(
            height = height,
            heightError = null
        )
    }

    fun updateGender(gender: String) {
        _uiState.value = _uiState.value.copy(
            gender = gender,
            genderError = null
        )
    }

    fun updateActivityLevel(activityLevel: String) {
        _uiState.value = _uiState.value.copy(
            activityLevel = activityLevel,
            activityLevelError = null
        )
    }

    fun updateGoal(goal: String) {
        _uiState.value = _uiState.value.copy(
            goal = goal,
            goalError = null
        )
    }

    fun createPlan() {
        val currentState = _uiState.value

        _isLoading.value = true
        _uiState.value = currentState.copy(generalError = null)

        viewModelScope.launch {
            val result = createPlanUseCase(
                age = currentState.age,
                gender = currentState.gender,
                weight = currentState.weight,
                height = currentState.height,
                activityLevel = currentState.activityLevel,
                goal = currentState.goal
            )

            result.onSuccess { response ->
                _uiState.value = _uiState.value.copy(
                    isSuccess = true,
                    successMessage = "¡Plan generado exitosamente!"
                )
            }.onFailure { exception ->
                handleError(exception.message ?: "Error desconocido")
            }

            _isLoading.value = false
        }
    }

    private fun handleError(errorMessage: String) {
        when {
            errorMessage.contains("edad", ignoreCase = true) -> {
                _uiState.value = _uiState.value.copy(ageError = errorMessage)
            }
            errorMessage.contains("peso", ignoreCase = true) -> {
                _uiState.value = _uiState.value.copy(weightError = errorMessage)
            }
            errorMessage.contains("altura", ignoreCase = true) -> {
                _uiState.value = _uiState.value.copy(heightError = errorMessage)
            }
            errorMessage.contains("sexo", ignoreCase = true) || errorMessage.contains("genero", ignoreCase = true) -> {
                _uiState.value = _uiState.value.copy(genderError = errorMessage)
            }
            errorMessage.contains("actividad", ignoreCase = true) -> {
                _uiState.value = _uiState.value.copy(activityLevelError = errorMessage)
            }
            errorMessage.contains("objetivo", ignoreCase = true) -> {
                _uiState.value = _uiState.value.copy(goalError = errorMessage)
            }
            else -> {
                _uiState.value = _uiState.value.copy(generalError = errorMessage)
            }
        }
    }

    fun clearSuccessMessage() {
        _uiState.value = _uiState.value.copy(isSuccess = false, successMessage = null)
    }

    fun clearGeneralError() {
        _uiState.value = _uiState.value.copy(generalError = null)
    }
}

data class CreatePlanUiState(
    val age: String = "",
    val weight: String = "",
    val height: String = "",
    val gender: String = "",
    val activityLevel: String = "",
    val goal: String = "",
    val ageError: String? = null,
    val weightError: String? = null,
    val heightError: String? = null,
    val genderError: String? = null,
    val activityLevelError: String? = null,
    val goalError: String? = null,
    val generalError: String? = null,
    val isSuccess: Boolean = false,
    val successMessage: String? = null
)