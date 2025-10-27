package dika.vasscom.ui.screens.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import dika.vasscom.utils.showSuccess
import dika.vasscom.utils.showWarning
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.KoinApplication

@Composable
private fun FormSection(
    viewModel: RegisterViewModel
) {
    val firstName by viewModel.firstName.collectAsState()
    val lastName by viewModel.lastName.collectAsState()
    val noKtn by viewModel.noKtp.collectAsState()
    val phoneNumber by viewModel.phoneNumber.collectAsState()
    val email by viewModel.email.collectAsState()
    val password by viewModel.password.collectAsState()
    val confirmPassword by viewModel.confirmPassword.collectAsState()
    val isFormValid by viewModel.isFormValid.collectAsState()

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            AppInputWithTitle(
                modifier = Modifier.weight(1f),
                title = stringResource(R.string.firstname),
                placeholderText = stringResource(R.string.firstname_placeholder),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                value = firstName,
                onValueChange = { newValue -> viewModel.updateFirstName(newValue) }
            )
            AppSpacer(width = 20)
            AppInputWithTitle(
                modifier = Modifier.weight(1f),
                title = stringResource(R.string.last_name),
                placeholderText = stringResource(R.string.last_name_placeholder),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                value = lastName,
                onValueChange = { newValue -> viewModel.updateLastName(newValue) }
            )
        }
        AppInputWithTitle(
            title = stringResource(R.string.no_ktn),
            placeholderText = stringResource(R.string.no_ktn_placeholder),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            value = noKtn,
            onValueChange = { newValue -> viewModel.updateNoKtp(newValue) }
        )
        AppInputWithTitle(
            title = stringResource(R.string.email),
            placeholderText = stringResource(R.string.email_placeholder),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            value = email,
            onValueChange = { newValue -> viewModel.updateEmail(newValue) }
        )
        AppInputWithTitle(
            title = stringResource(R.string.no_telp),
            placeholderText = stringResource(R.string.no_telp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            value = phoneNumber,
            onValueChange = { newValue -> viewModel.updatePhoneNumber(newValue) }
        )
        AppInputPassword(
            title = stringResource(R.string.password),
            placeholderText = stringResource(R.string.password_placeholder),
            value = password,
            onValueChange = { newValue -> viewModel.updatePassword(newValue) },
        )
        AppInputPassword(
            title = stringResource(R.string.password_confirm),
            placeholderText = stringResource(R.string.password_confirm_placeholder),
            value = confirmPassword,
            onValueChange = { newValue -> viewModel.updateConfirmPassword(newValue) },
        )
        AppButton(
            title = stringResource(R.string.login),
            marginTop = 20,
            enable = isFormValid,
            icon = Icons.AutoMirrored.Rounded.ArrowForward,
            onClick = { viewModel.register() }
        )
    }
}

@Composable
private fun Footer(
    navigateToLogin: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.padding(top = 16.dp)
        ){
            AppTextLite(
                text = stringResource(R.string.has_account_quest),
                size = 14
            )
            AppSpacer(width = 10)
            AppTitle(
                title = stringResource(R.string.login_now),
                size = 14,
                onClick = navigateToLogin
            )
        }
        AppSpacer()
        AppCopyRight()
        Box(modifier = Modifier.padding(
            bottom = 50.dp
        ))
    }
}

@Composable
fun RegisterScreen(navigateToLogin: () -> Unit) {
    var isLoading by remember { mutableStateOf(false) }
    val viewModel: RegisterViewModel = koinViewModel()
    val state by viewModel.state.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(state) {
        if (state is RegisterState.InvalidInput) {
            val invalidState = state as RegisterState.InvalidInput
            context.showWarning(invalidState.message)
            viewModel.updateStateIdle()
        }
        if (state is RegisterState.Success) {
            viewModel.clearForm()
            val successState = state as RegisterState.Success
            context.showSuccess("Welcome, ${successState.firstName} ${successState.lastName}")
            navigateToLogin.invoke()
        }
    }

    Box(
        modifier = Modifier.fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
                .fillMaxHeight()
                .padding(top = 50.dp)
                .verticalScroll(rememberScrollState()),
        ) {
            AppSpacer(30)
            AppGreet()
            FormSection(viewModel)
            Footer(navigateToLogin)
            Spacer(modifier = Modifier.imePadding())
        }
        LoadingDialog(isLoading = isLoading)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegisterScreenPreview() {
    VascommHospitalTheme {
        KoinApplication(application = {
            allModules()
        }) {
            RegisterScreen {}
        }

    }
}
