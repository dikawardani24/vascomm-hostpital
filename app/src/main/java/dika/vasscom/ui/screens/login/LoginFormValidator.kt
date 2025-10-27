package dika.vasscom.ui.screens.login

import dika.vasscom.core.validator.EmailValidator
import dika.vasscom.core.validator.PasswordValidator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

class LoginFormValidator(
    private val email: MutableStateFlow<String>,
    private val password: MutableStateFlow<String>,
    private val scope: CoroutineScope
) {
    private val isEmailValid: Boolean get() = EmailValidator(email.value)
        .validate().cause == EmailValidator.Cause.NONE
    private val isPasswordValid: Boolean get() = PasswordValidator(password.value)
        .validate().cause == PasswordValidator.Cause.NONE

    val isFormValid = combine(password, email) { email, password ->
        isPasswordValid && isEmailValid
    }.stateIn(
        scope = scope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = false
    )
}