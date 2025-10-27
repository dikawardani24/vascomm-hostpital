package dika.vasscom.core.domain.repository

import dika.vasscom.core.domain.model.User

interface AuthRepository {
    suspend fun login(email: String, password: String): User
}