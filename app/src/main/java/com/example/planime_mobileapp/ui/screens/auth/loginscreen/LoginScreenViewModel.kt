package com.example.planime_mobileapp.ui.screens.auth.loginscreen


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.planime_mobileapp.data.local.TokenPreferences
import com.example.planime_mobileapp.data.repository.ApiRepositoryImpl
import com.example.planime_mobileapp.domain.usecase.auth.LoginUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginScreenViewModel(
    private val tokenPreferences: TokenPreferences
) : ViewModel() {

    private val repository = ApiRepositoryImpl()
    private val loginUseCase = LoginUseCase(repository, tokenPreferences)

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    fun updateEmail(email: String) {
        _uiState.value = _uiState.value.copy(email = email)
    }

    fun updatePassword(password: String) {
        _uiState.value = _uiState.value.copy(password = password)
    }

    fun signin() {
        val currentState = _uiState.value

        _uiState.value = currentState.copy(
            isLoading = true,
            errorMessage = null
        )

        viewModelScope.launch {
            val result = loginUseCase(
                email = currentState.email,
                password = currentState.password
            )

            result.onSuccess { response ->
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    isSuccess = true,
                    successMessage = "Ingresando a tu cuenta!"
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
            successMessage = null
        )
    }
}

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val errorMessage: String? = null,
    val successMessage: String? = null
)