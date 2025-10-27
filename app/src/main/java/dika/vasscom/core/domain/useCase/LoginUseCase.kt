package dika.vasscom.core.domain.useCase

import dika.vasscom.core.domain.ApiResult
import dika.vasscom.core.domain.model.User
import dika.vasscom.core.domain.repository.AuthRepository
import dika.vasscom.utils.toApiError

class LoginUseCase(
    private val authRepository: AuthRepository
) {
    suspend fun execute(
        email: String,
        password: String
    ): ApiResult<User> {
        try {
            val user = authRepository.login(email, password)
            if (user.token.isNotEmpty()) {
                return ApiResult.Success(user)
            }
            return ApiResult.Error("Invalid credentials")
        } catch (e: Exception) {
            return e.toApiError()
        }
    }
}