package dika.vasscom.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dika.vasscom.R
import dika.vasscom.ui.theme.Cream
import dika.vasscom.ui.theme.Navy
import dika.vasscom.ui.theme.VascommHospitalTheme
import dika.vasscom.ui.theme.figtreeFontFamily
import dika.vasscom.ui.theme.gilroyFontFamily

@Composable
fun AppFooter(
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(107.dp),
        color = Navy,
        contentColor = Cream,
        shape = RectangleShape
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(painter = painterResource(id = R.drawable.ic_subtract), contentDescription = null)
                Image(modifier = Modifier
                    .padding(bottom = 40.dp, start = 80.dp), painter = painterResource(id = R.drawable.ic_ornamen), contentDescription = null)
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Ingin mendapat update\ndari kami?",
                    fontSize = 16.sp,
                    fontFamily = gilroyFontFamily,
                    fontWeight = FontWeight(700),
                    color = Cream,
                )
                Text(
                    text = "Dapatkan\nnotifikasi",
                    fontSize = 14.sp,
                    fontFamily = figtreeFontFamily,
                    fontWeight = FontWeight(400),
                    color = Cream,
                )

                Icon(imageVector = Icons.Rounded.ArrowForward, contentDescription = null)
            }
        }
    }

}

@Preview
@Composable
fun BottomBarPreview() {
    VascommHospitalTheme {
        AppFooter()
    }
}