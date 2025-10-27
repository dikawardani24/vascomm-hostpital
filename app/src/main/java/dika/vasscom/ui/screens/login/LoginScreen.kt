package dika.vasscom.ui.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dika.vasscom.App.Companion.allModules
import dika.vasscom.R
import dika.vasscom.ui.components.AppButton
import dika.vasscom.ui.components.AppCopyRight
import dika.vasscom.ui.components.AppGreet
import dika.vasscom.ui.components.AppInputPassword
import dika.vasscom.ui.components.AppInputWithTitle
import dika.vasscom.ui.components.AppSpacer
import dika.vasscom.ui.components.AppTextLite
import dika.vasscom.ui.components.AppTitle
import dika.vasscom.ui.components.LoadingDialog
import dika.vasscom.ui.theme.VascommHospitalTheme
import dika.vasscom.utils.showError
import dika.vasscom.utils.showWarning
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.KoinApplication

@Composable
private fun FormSection(
    viewModel: LoginViewModel,
) {
    val email by viewModel.email.collectAsState()
    val password by viewModel.password.collectAsState()
    val isFormValid by viewModel.isFormValid.collectAsState()

    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        AppInputWithTitle(
            title = stringResource(R.string.email),
            placeholderText = stringResource(R.string.email_placeholder),
            keyboardOptions = androidx.compose.foundation.text.KeyboardOptions(keyboardType = KeyboardType.Email),
            value = email,
            onValueChange = { newValue ->
                viewModel.updateEmail(newValue)
            }
        )
        AppInputPassword(
            title = stringResource(R.string.password),
            placeholderText = stringResource(R.string.password_placeholder),
            value = password,
            onValueChange = { newValue ->
                viewModel.updatePassword(newValue)
            },
        )
        AppButton(
            title = stringResource(R.string.login),
            marginTop = 20,
            enable = isFormValid,
            icon = Icons.AutoMirrored.Rounded.ArrowForward,
            onClick = {
                viewModel.login()
            }
        )
    }
}

@Composable
private fun Footer(
    navigateToRegister: () -> Unit,
    viewModel: LoginViewModel
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.padding(top = 16.dp)
        ) {
            AppTextLite(
                text = stringResource(R.string.no_account_quest),
                size = 14
            )
            AppSpacer(width = 10)
            AppTitle(
                title = stringResource(R.string.register_now),
                size = 14,
                onClick = {
                    viewModel.clearForm()
                    navigateToRegister()
                }
            )
        }
        AppSpacer()
        AppCopyRight()
    }
}

@Composable
fun LoginScreen(
    navigateToRegister: () -> Unit,
    navigateToHome: () -> Unit,
) {
    val viewModel: LoginViewModel = koinViewModel()
    val state by viewModel.state.collectAsState()
    val context = LocalContext.current

    // Handle state changes
    LaunchedEffect(state) {
        if (state is LoginState.InvalidInput) {
            val invalidState = state as LoginState.InvalidInput
            context.showWarning(invalidState.message)
            viewModel.updateStateIdle()
        }
        if (state is LoginState.Error) {
            val errorState = state as LoginState.Error
            context.showError(errorState.error)
            viewModel.updateStateIdle()
        }
        if (state is LoginState.Success) {
            viewModel.clearForm()
            navigateToHome()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AppGreet()
            FormSection(viewModel)
            Footer(
                navigateToRegister = navigateToRegister,
                viewModel = viewModel
            )
            Spacer(modifier = Modifier.imePadding())
        }

        LoadingDialog(isLoading = state is LoginState.Loading)
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    VascommHospitalTheme {
        KoinApplication(application = {
            allModules()
        }) {
            LoginScreen(
                navigateToRegister = {},
                navigateToHome = {}
            )
        }
    }
}