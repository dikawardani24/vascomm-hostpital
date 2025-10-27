package dika.vasscom.ui.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dika.vasscom.core.domain.ApiResult
import dika.vasscom.core.domain.useCase.LoginUseCase
import dika.vasscom.core.domain.useCase.SaveTokenUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginUseCase: LoginUseCase,
    private val saveTokenUseCase: SaveTokenUseCase
) : ViewModel() {

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email.asStateFlow()

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password.asStateFlow()

    private val _state = MutableStateFlow<LoginState>(LoginState.Idle)
    val state: StateFlow<LoginState> = _state.asStateFlow()
    val isFormValid = LoginFormValidator(
        password = _password,
        email = _email,
        scope = viewModelScope
    ).isFormValid

    fun updateEmail(email: String) {
        _email.value = email
    }

    fun updatePassword(password: String) {
        _password.value = password
    }

    fun updateStateIdle() {
        _state.value = LoginState.Idle
    }

    fun clearForm() {
        updateEmail("")
        updatePassword("")
        updateStateIdle()
    }

    fun login() {
        val inputEmail = _email.value
        val inputPassword = _password.value

        if (!isFormValid.value) {
            _state.value = LoginState.InvalidInput("Please check your email and password")
            return
        }

        _state.value = LoginState.Loading
        viewModelScope.launch {
            when (val result = loginUseCase.execute(inputEmail, inputPassword)) {
                is ApiResult.Success -> {
                    saveTokenUseCase.execute(result.data)
                    _state.value = LoginState.Success
                }
                is ApiResult.Error -> {
                    _state.value = LoginState.Error(result.message)
                }
            }
        }
    }

}