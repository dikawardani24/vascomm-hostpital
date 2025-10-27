package dika.vasscom.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import dika.vasscom.ui.theme.VascommHospitalTheme

@Composable
fun AppInputWithTitle(
    modifier: Modifier = Modifier,
    title: String,
    value: String,
    placeholderText: String,
    onValueChange: (String) -> Unit,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    trailingIcon: @Composable () -> Unit = {},
    trailingTitle: @Composable () -> Unit = {}
) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            AppTitle(title)
            trailingTitle()
        }
        AppSpacer()
        AppInput(
            value = value,
            placeholderText = placeholderText,
            onValueChange = onValueChange,
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            trailingIcon = trailingIcon
        )
    }
}

@Preview
@Composable
fun InputWithLabelPreview() {
    VascommHospitalTheme {
        Column {
            AppInputWithTitle(
                title = "Title",
                value = "",
                placeholderText = "Input here",
                onValueChange = {},
                trailingTitle = {
                    AppTitle("Trailing text")
                }
            )
            AppSpacer()
            AppInputWithTitle(
                title = "Title",
                value = "",
                placeholderText = "Input here",
                onValueChange = {},
                trailingTitle = {
                    AppTitle("Trailing text", onClick = {} )
                }
            )
        }
    }
}