package dika.vasscom.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dika.vasscom.ui.theme.Gray
import dika.vasscom.ui.theme.Navy
import dika.vasscom.ui.theme.VascommHospitalTheme
import dika.vasscom.ui.theme.figtreeFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppInput(
    value: String,
    placeholderText: String,
    shape: RoundedCornerShape = RoundedCornerShape(8.dp),
    trailingIcon: @Composable () -> Unit = {},
    onValueChange: (String) -> Unit,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
) {

    TextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                text = placeholderText,
                fontSize = 12.sp,
                lineHeight = 14.4.sp,
                fontWeight = FontWeight(400),
                fontFamily = figtreeFontFamily,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        },
        singleLine = true,
        modifier = Modifier
            .shadow(
                elevation = 24.dp,
                spotColor = Color(0x29BEBEBE),
//                    ambientColor = Color(0x29BEBEBE)
            )
            .fillMaxWidth(),
        shape = shape,
        textStyle = TextStyle(
            fontSize = 16.sp,
            fontFamily = figtreeFontFamily,
            fontWeight = FontWeight(600),
            color = Navy,
        ),
        colors = TextFieldDefaults.colors(
            focusedTextColor = Navy,
            unfocusedTextColor = Navy,
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            unfocusedPlaceholderColor = Gray,
            focusedPlaceholderColor = Gray,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent
        ),
        trailingIcon = trailingIcon,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions
    )
}

@Preview
@Composable
fun AppInputPreview() {
    VascommHospitalTheme {
        AppInput(value = "", placeholderText = "Tess", onValueChange = {})
    }
}