package dika.vasscom.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dika.vasscom.ui.theme.Gray
import dika.vasscom.ui.theme.LightGray
import dika.vasscom.ui.theme.Navy
import dika.vasscom.ui.theme.VascommHospitalTheme
import dika.vasscom.ui.theme.figtreeFontFamily

@Composable
private fun CustomButton(
    title: String,
    icon: ImageVector? = null,
    onClick: () -> Unit,
    enable: Boolean = true
) {
    val color = if (enable) Navy else Gray
    Button(
        onClick = {
            if (enable) onClick.invoke()
        },
        modifier = Modifier
            .shadow(
                elevation = 4.dp,
                ambientColor = LightGray
            )
            .height(48.dp),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(containerColor = color),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = title,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontFamily = figtreeFontFamily,
                fontWeight = FontWeight(600),
                color = Color.White,
                modifier = Modifier.padding(1.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            if (icon != null) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }
    }
}

@Composable
fun AppButton(
    title: String,
    onClick: () -> Unit,
    marginTop: Int = 0,
    enable: Boolean = true,
    icon: ImageVector? = null
) {
    if (marginTop > 0) {
        Column {
            AppSpacer(marginTop)
            CustomButton(title = title, onClick = onClick, icon = icon)
        }
        return
    }
    CustomButton(title = title, onClick = onClick, icon = icon, enable = enable)
}

@Preview
@Composable
fun AppButtonPreview() {
    VascommHospitalTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            AppButton(
                title = "Login",
                icon = Icons.AutoMirrored.Rounded.ArrowForward,
                onClick = {},
            )
            AppButton(
                title = "Login",
                icon = Icons.AutoMirrored.Rounded.ArrowForward,
                onClick = {},
                enable = false
            )
        }

    }
}