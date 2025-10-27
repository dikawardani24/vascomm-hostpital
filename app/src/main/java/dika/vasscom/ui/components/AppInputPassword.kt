package dika.vasscom.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import dika.vasscom.ui.theme.VascommHospitalTheme

@Composable
fun AppInputPassword(
    modifier: Modifier = Modifier,
    value: String,
    title: String,
    placeholderText: String,
    onValueChange: (String) -> Unit,
) {
    var isPasswordVisible by remember { mutableStateOf(false) }

    AppInputWithTitle(
        modifier = modifier,
        title = title,
        placeholderText = placeholderText,
        value = value,
        onValueChange = onValueChange,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            Icon(
                imageVector = if (isPasswordVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                contentDescription = null,
                modifier = Modifier.clickable {
                    isPasswordVisible = !isPasswordVisible
                }
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun AppInputPasswordPreview() {
    VascommHospitalTheme {
        AppInputPassword(
            title = "Password",
            placeholderText = "Password",
            value = "",
            onValueChange = {}
        )
    }
}