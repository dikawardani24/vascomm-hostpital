package dika.vasscom.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import dika.vasscom.ui.theme.PaleNavy
import dika.vasscom.ui.theme.VascommHospitalTheme
import dika.vasscom.ui.theme.gilroyFontFamily

@Composable
fun TitleAnnotated(
    modifier: Modifier = Modifier,
    title: String,
    boldText: String,
    fontSize: Int
) {
    val an = buildAnnotatedString {
        append(title)
        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight(800),
                color = PaleNavy,
                fontFamily = gilroyFontFamily,
            )
        ) {
            append(boldText)
        }
    }
    Text(
        modifier = modifier,
        text = an,
        fontSize = fontSize.sp,
        lineHeight = 33.6.sp,
        color = PaleNavy,
        fontFamily = gilroyFontFamily,
    )
}

@Composable
@Preview(showBackground = true)
fun TitleAnnotatedPreview() {
    VascommHospitalTheme {
        TitleAnnotated(
            title = "SText, ",
            boldText = "Bolx",
            fontSize = 18
        )
    }
}