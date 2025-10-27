package dika.vasscom.ui.screens.register

import dika.vasscom.core.validator.EmailValidator
import dika.vasscom.core.validator.KtpValidator
import dika.vasscom.core.validator.NameValidator
import dika.vasscom.core.validator.NewPasswordValidator
import dika.vasscom.core.validator.PasswordValidator
import dika.vasscom.core.validator.PhoneNumberValidator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

class RegisterFormValidator(
    private val firstName: MutableStateFlow<String>,
    private val lastName: MutableStateFlow<String>,
    private val email: MutableStateFlow<String>,
    private val password: MutableStateFlow<String>,
    private val confirmPassword: MutableStateFlow<String>,
    private val phoneNumber: MutableStateFlow<String>,
    private val noKtp: MutableStateFlow<String>,
    private val scope: CoroutineScope
) {
    private val isFirstNameValid: Boolean get() = NameValidator(firstName.value)
        .validate().cause == NameValidator.Cause.NONE
    private val isLastNameValid: Boolean get() = NameValidator(lastName.value)
        .validate().cause == NameValidator.Cause.NONE
    private val isNoKtpValid: Boolean get() = KtpValidator(noKtp.value)
        .validate().cause == KtpValidator.Cause.NONE
    private val isPhoneNumberValid: Boolean get() = PhoneNumberValidator(phoneNumber.value)
        .validate().cause == PhoneNumberValidator.Cause.NONE
    private val isEmailValid: Boolean get() = EmailValidator(email.value)
        .validate().cause == EmailValidator.Cause.NONE
    private val isPasswordValid: Boolean get() = PasswordValidator(password.value)
        .validate().cause == PasswordValidator.Cause.NONE
    private val isConfirmPasswordValid: Boolean get() = NewPasswordValidator(password.value, confirmPassword.value)
        .validate().cause == NewPasswordValidator.Cause.NONE

    private val isBasicValid = combine(
        firstName, lastName, email, password, confirmPassword
     ) { firstName, lastName, email, password, confirmPassword, ->
        isFirstNameValid && isLastNameValid && isEmailValid && isPasswordValid && isConfirmPasswordValid
    }.stateIn(
        scope = scope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = false
    )

    private val isIdValid = combine(
        phoneNumber, noKtp
    ) { phoneNumber, noKtp ->
        isPhoneNumberValid && isNoKtpValid
    }.stateIn(
        scope = scope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = false
    )

    val isFormValid = combine(
        isBasicValid, isIdValid
    ) { phoneNumber, noKtp ->
        isBasicValid.value && isIdValid.value
    }.stateIn(
        scope = scope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = false
    )

}