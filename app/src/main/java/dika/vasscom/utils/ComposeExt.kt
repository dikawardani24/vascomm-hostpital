package dika.vasscom.utils

import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import dika.vasscom.ui.theme.PaleNavy
import dika.vasscom.ui.theme.gilroyFontFamily

fun createAnnotated(
    title: String,
    boldText: String,
    isBoldFirst: Boolean = false
) = buildAnnotatedString {
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