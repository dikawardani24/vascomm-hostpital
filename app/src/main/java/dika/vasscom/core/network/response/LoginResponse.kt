package dika.vasscom.core.network.response

import com.squareup.moshi.Json

data class LoginResponse(
    @param:Json(name = "token")
    val token: String? = null
)
