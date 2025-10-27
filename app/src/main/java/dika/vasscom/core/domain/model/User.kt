package dika.vasscom.core.domain.model

import dika.vasscom.core.network.response.LoginResponse

data class User(
    val token: String = ""
) {
    companion object {
        fun LoginResponse.toUser(): User {
            return User(token.orEmpty())
        }
    }
}