package dika.vasscom.ui.screens.register

sealed class RegisterState {
    data class InvalidInput(val message: String): RegisterState()
    data class Success(
        val firstName: String,
        val lastName: String
    ): RegisterState()
    object Idle: RegisterState()
}