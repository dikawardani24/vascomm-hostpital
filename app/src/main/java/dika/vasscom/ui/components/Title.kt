package dika.vasscom.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import dika.vasscom.ui.theme.PaleNavy
import dika.vasscom.ui.theme.VascommHospitalTheme
import dika.vasscom.ui.theme.gilroyFontFamily

@Composable
fun AppTitle(
    title: String,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    size: Int = 16
) {
    val style = TextStyle(fontSize = size.sp)
    if (onClick != null) {
        Text(
            modifier = modifier.clickable(enabled = true, onClick = onClick),
            text = title,
            color = PaleNavy,
            fontWeight = FontWeight(600),
            fontFamily = gilroyFontFamily,
            style = style
        )

        return
    }
    Text(
        modifier = modifier,
        text = title,
        color = PaleNavy,
        fontWeight = FontWeight(600),
        fontFamily = gilroyFontFamily,
        style = style
    )
}

@Preview
@Composable
fun AppTitlePreview() {
    VascommHospitalTheme {
        Column {
            AppTitle(title = "Title")
            AppTitle(title = "Title", onClick = {})
        }
    }
}