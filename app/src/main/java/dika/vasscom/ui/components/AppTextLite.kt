package dika.vasscom.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import dika.vasscom.ui.theme.LightGray
import dika.vasscom.ui.theme.VascommHospitalTheme
import dika.vasscom.ui.theme.figtreeFontFamily

@Composable
fun AppTextLite(
    modifier: Modifier = Modifier,
    text: String,
    size: Int
) {
    Text(
        modifier = modifier,
        text = text,
        fontWeight = FontWeight(400),
        color = LightGray,
        fontFamily = figtreeFontFamily,
        style = TextStyle(fontSize = size.sp)
    )
}

@Preview(showBackground = false)
@Composable
fun AppTextLitePreview() {
    VascommHospitalTheme {
        AppTextLite(
            text = "This is a preview",
            size = 5
        )
    }
}