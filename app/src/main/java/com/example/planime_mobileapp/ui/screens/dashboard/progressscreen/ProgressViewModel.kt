package com.example.planime_mobileapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.planime_mobileapp.data.local.TokenPreferences
import com.example.planime_mobileapp.data.repository.ApiRepositoryImpl
import com.example.planime_mobileapp.domain.model.user.progress.WeightOption
import com.example.planime_mobileapp.domain.usecase.user.plans.GetPlansUseCase
import com.example.planime_mobileapp.domain.usecase.user.progress.GetWeightGoalUseCase
import com.example.planime_mobileapp.domain.usecase.user.progress.SetWeightGoalUseCase
import com.example.planime_mobileapp.domain.usecase.user.progress.SetWeightRecordUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.String

class ProgressScreenViewModel(
    private val tokenPreferences: TokenPreferences
) : ViewModel() {

    private val repository = ApiRepositoryImpl()
    private val setWeightGoalUseCase = SetWeightGoalUseCase(repository, tokenPreferences)
    private val getWeightGoalUseCase = GetWeightGoalUseCase(repository, tokenPreferences)
    private val setWeightRecordUseCase = SetWeightRecordUseCase(repository, tokenPreferences)

    private val _uiState = MutableStateFlow(ProgressUiState())
    val uiState: StateFlow<ProgressUiState> = _uiState.asStateFlow()

    init {
        updateWeightOptionSaved()
    }

    fun updateWeightOptionSaved(){
        _uiState.value = _uiState.value.copy(
            isLoading = true,
            selectedWeightOption = null
        )
        viewModelScope.launch {
            val result = getWeightGoalUseCase()

            result.onSuccess { response ->
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    selectedWeightOption = WeightOption(
                        value = response.data?.toInt() ?: 0,
                        displayText = "${response.data ?: "0"} kg"
                    )
                )
            }.onFailure { error ->
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    errorMessage = error.message
                )
            }
        }
    }

    fun onWeightOptionSelected(weightOption: WeightOption) {
        _uiState.value = _uiState.value.copy(
            selectedWeightOption = weightOption,
            isLoading = true
        )

        viewModelScope.launch {
            val result = setWeightGoalUseCase(weightOption.value.toString())

            result.onSuccess { response ->
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    isSuccess = true,
                    successGoalMessage = "Objetivo actualizado correctamente!"
                )
            }.onFailure { error ->
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    errorMessage = error.message
                )
            }
        }
    }

    fun setWeightRecord(weight: String, date: String) {
        _uiState.value = _uiState.value.copy(
            weightError = null,
            dateError = null,
            isLoading = true
        )

        viewModelScope.launch {
            val result = setWeightRecordUseCase(weight, date)

            result.onSuccess { response ->
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    isSuccess = true,
                    successRecordMessage = "Registro de peso añadido correctamente!"
                )
            }.onFailure { error ->
                handleWeightRecordError(error.message ?: "Error desconocido")
            }
        }
    }

    private fun handleWeightRecordError(errorMessage: String) {
        _uiState.value = when {
            errorMessage.contains("peso", ignoreCase = true) -> {
                _uiState.value.copy(
                    isLoading = false,
                    weightError = errorMessage
                )
            }
            errorMessage.contains("fecha", ignoreCase = true) ||
                    errorMessage.contains("día", ignoreCase = true) ||
                    errorMessage.contains("mes", ignoreCase = true) ||
                    errorMessage.contains("año", ignoreCase = true) ||
                    errorMessage.contains("formato", ignoreCase = true) -> {
                _uiState.value.copy(
                    isLoading = false,
                    dateError = errorMessage
                )
            }
            else -> {
                _uiState.value.copy(
                    isLoading = false,
                    errorMessage = errorMessage
                )
            }
        }
    }

    fun clearWeightError() {
        _uiState.value = _uiState.value.copy(weightError = null)
    }

    fun clearDateError() {
        _uiState.value = _uiState.value.copy(dateError = null)
    }

    fun clearSuccesMessage() {
        _uiState.value = _uiState.value.copy(successRecordMessage = null)
    }

    fun clearMessages() {
        _uiState.value = _uiState.value.copy(
            errorMessage = null,
            successGoalMessage = null,
            successRecordMessage = null,
            weightError = null,
            dateError = null,
            isSuccess = false
        )
    }
}

data class ProgressUiState(
    val selectedWeightOption: WeightOption? = null,
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val errorMessage: String? = null,
    val successGoalMessage: String? = null,
    val successRecordMessage: String? = null,
    val weightError: String? = null,
    val dateError: String? = null
)