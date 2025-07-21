package com.example.planime_mobileapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.planime_mobileapp.data.local.TokenPreferences
import com.example.planime_mobileapp.data.repository.ApiRepositoryImpl
import com.example.planime_mobileapp.domain.model.user.progress.WeightOption
import com.example.planime_mobileapp.domain.usecase.user.progress.GetWeightGoalUseCase
import com.example.planime_mobileapp.domain.usecase.user.progress.SetWeightGoalUseCase
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
                    successMessage = "Objetivo actualizado correctamente!"
                )
            }.onFailure { error ->
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    errorMessage = error.message
                )
            }
        }
    }

    fun clearMessages() {
        _uiState.value = _uiState.value.copy(
            errorMessage = null,
            successMessage = null,
            isSuccess = false
        )
    }
}

data class ProgressUiState(
    val selectedWeightOption: WeightOption? = null,
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val errorMessage: String? = null,
    val successMessage: String? = null
)


