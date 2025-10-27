package dika.vasscom.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dika.vasscom.ui.theme.PaleNavy
import dika.vasscom.ui.theme.VascommHospitalTheme
import dika.vasscom.ui.theme.gilroyFontFamily
import dika.vasscom.utils.createAnnotated

private fun createBoldText(
    title: String,
    boldText: String,
    isBoldFirst: Boolean
): AnnotatedString {
    if (isBoldFirst) {
        return buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight(800),
                    color = PaleNavy,
                    fontFamily = gilroyFontFamily,
                )
            ) {
                append(boldText)
            }
            append(title)
        }
    }
    return buildAnnotatedString {
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
}

@Composable
fun TitleAnnotated(
    modifier: Modifier = Modifier,
    title: String,
    boldText: String,
    fontSize: Int,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip,
    isBoldFirst: Boolean = false
) {
    val an = createBoldText(title, boldText, isBoldFirst)
    Text(
        modifier = modifier,
        text = an,
        color = PaleNavy,
        fontFamily = gilroyFontFamily,
        maxLines = maxLines,
        overflow = overflow,
        style = TextStyle(fontSize = fontSize.sp,)
    )
}

@Composable
@Preview(showBackground = true)
fun TitleAnnotatedPreview() {
    VascommHospitalTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TitleAnnotated(
                title = "SText, ",
                boldText = "Bolx",
                fontSize = 18
            )
            TitleAnnotated(
                title = "SText",
                boldText = "Bolx, ",
                fontSize = 18,
                isBoldFirst = true
            )
        }

    }
}