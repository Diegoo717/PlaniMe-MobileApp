package com.example.planime_mobileapp.ui.screens.dashboard.userprofile

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.planime_mobileapp.data.repository.ApiRepositoryImpl
import com.example.planime_mobileapp.data.local.TokenPreferences
import com.example.planime_mobileapp.domain.usecase.user.profile.ProfileUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class UserProfileState(
    val isLoading: Boolean = false,
    val userName: String = "",
    val userEmail: String = "",
    val errorMessage: String? = null
)

class UserProfileScreenViewModel(
    private val tokenPreferences: TokenPreferences
) : ViewModel() {

    companion object {
        private const val TAG = "UserProfileViewModel"
    }

    private val repository = ApiRepositoryImpl()
    private val profileUseCase = ProfileUseCase(repository, tokenPreferences)

    private val _state = MutableStateFlow(UserProfileState())
    val state: StateFlow<UserProfileState> = _state.asStateFlow()

    init {
        loadUserProfile()
    }

    fun loadUserProfile() {
        val token = tokenPreferences.getToken()

        if (token.isNullOrEmpty()) {
            _state.value = _state.value.copy(
                isLoading = false,
                errorMessage = "No hay sesión activa"
            )
            return
        }

        _state.value = _state.value.copy(isLoading = true, errorMessage = null)

        viewModelScope.launch {
            try {
                val result = profileUseCase()

                result.onSuccess { profile ->
                    _state.value = _state.value.copy(
                        isLoading = false,
                        userName = "${profile.firstName ?: ""} ${profile.lastName ?: ""}".trim(),
                        userEmail = profile.email ?: "",
                        errorMessage = null
                    )
                }.onFailure { error ->
                    _state.value = _state.value.copy(
                        isLoading = false,
                        errorMessage = error.message ?: "Error al cargar el perfil"
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

    fun retryLoadProfile() {
        loadUserProfile()
    }

    fun clearError() {
        _state.value = _state.value.copy(errorMessage = null)
    }
}