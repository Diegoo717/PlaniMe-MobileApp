package com.example.planime_mobileapp.domain.usecase.common

import com.example.planime_mobileapp.domain.repository.ApiRepository

class GetApiStatusUseCase(
    private val repository: ApiRepository
) {
    suspend operator fun invoke() = repository.getApiStatus()
}