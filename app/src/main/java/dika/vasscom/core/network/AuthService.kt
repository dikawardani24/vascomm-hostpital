package dika.vasscom.core.network

import dika.vasscom.core.network.request.LoginRequest
import dika.vasscom.core.network.response.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("login")
    suspend fun login(
        @Body request: LoginRequest
    ): LoginResponse
}