package dika.vasscom.core.domain.repository.impl

import dika.vasscom.core.domain.model.User
import dika.vasscom.core.domain.model.User.Companion.toUser
import dika.vasscom.core.domain.repository.AuthRepository
import dika.vasscom.core.network.AuthService
import dika.vasscom.core.network.request.LoginRequest

class AuthRepositoryImpl(
    private val authService: AuthService
): AuthRepository {

    override suspend fun login(
        email: String,
        password: String
    ): User {
        val request = LoginRequest(email, password)
        val response = authService.login(request)
        return response.toUser()
    }

}