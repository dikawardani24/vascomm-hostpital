package dika.vasscom.ui.screens.login

import dika.vasscom.ui.components.BannerService
import dika.vasscom.ui.components.Tips

sealed class LoginState {
    object Loading: LoginState()
    data class InvalidInput(val message: String): LoginState()
    object Success: LoginState()
    data class Error(val error: String): LoginState()
    object Idle: LoginState()
}
