package dika.vasscom.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dika.vasscom.ui.theme.Navy
import dika.vasscom.ui.theme.VascommHospitalTheme
import dika.vasscom.ui.theme.figtreeFontFamily

@Composable
fun AppSmallButton(
    title: String,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .shadow(
                elevation = 4.dp,
                ambientColor = Color(0x3D1D334F)
            ),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Navy),
    ) {
        Text(
            text = title,
            fontSize = 16.sp,
            fontFamily = figtreeFontFamily,
            fontWeight = FontWeight(600),
            color = Color.White,
            modifier = Modifier.padding(1.dp)
        )
    }
}

@Composable
@Preview
fun AppSmallButtonPreview() {
    VascommHospitalTheme {
        AppSmallButton("Login") { }
    }
}