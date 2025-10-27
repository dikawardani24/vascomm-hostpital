package dika.vasscom.ui.screens.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class RegisterViewModel: ViewModel() {
    private val _firstName = MutableStateFlow("")
    val firstName: StateFlow<String> = _firstName
    private val _lastName = MutableStateFlow("")
    val lastName: StateFlow<String> = _lastName
    private val _noKtp = MutableStateFlow("")
    val noKtp: StateFlow<String> = _noKtp
    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email
    private val _phoneNumber = MutableStateFlow("")
    val phoneNumber: StateFlow<String> = _phoneNumber
    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password
    private val _confirmPassword = MutableStateFlow("")
    val confirmPassword: StateFlow<String> = _confirmPassword
    private val _state = MutableStateFlow<RegisterState>(RegisterState.Idle)
    val state: StateFlow<RegisterState> = _state.asStateFlow()
    val isFormValid = RegisterFormValidator(
        firstName = _firstName,
        lastName = _lastName,
        noKtp = _noKtp,
        email = _email,
        phoneNumber = _phoneNumber,
        password = _password,
        confirmPassword = _confirmPassword,
        scope = viewModelScope
    ).isFormValid

    fun updateFirstName(newFirstName: String) { _firstName.value = newFirstName }

    fun updateLastName(newLastName: String) { _lastName.value = newLastName }

    fun updateNoKtp(newNoKtp: String) { _noKtp.value = newNoKtp }

    fun updateEmail(newEmail: String) { _email.value = newEmail }

    fun updatePhoneNumber(newPhoneNumber: String) { _phoneNumber.value = newPhoneNumber }

    fun updatePassword(newPassword: String) { _password.value = newPassword }

    fun updateConfirmPassword(newConfirmPassword: String) { _confirmPassword.value = newConfirmPassword }

    fun register() {
        val firstName = _firstName.value
        val lastName = _lastName.value

        if (!isFormValid.value) {
            _state.value = RegisterState.InvalidInput("Please check your input")
            return
        }
        _state.value = RegisterState.Success(firstName = firstName, lastName = lastName)
    }

    fun updateStateIdle() {
        _state.value = RegisterState.Idle
    }

    fun clearForm() {
        _firstName.value = ""
        _lastName.value = ""
        _noKtp.value = ""
        _email.value = ""
        _phoneNumber.value = ""
        _password.value = ""
        _confirmPassword.value = ""
        updateStateIdle()
    }
}