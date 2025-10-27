package dika.vasscom.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dika.vasscom.ui.theme.GrayBlue
import dika.vasscom.ui.theme.VascommHospitalTheme
import dika.vasscom.R
import dika.vasscom.ui.theme.figtreeFontFamily

@Composable
fun AppGreet() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        val padding = 16.dp
        TitleAnnotated(
            modifier = Modifier.padding(start = padding, end = padding),
            title = "Hi, ",
            boldText = "Selamat Datang",
            fontSize = 28
        )
        Spacer(modifier = Modifier
            .height(4.dp)
            .padding(20.dp))
        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = "Silahkan login untuk melanjutkan",
            fontSize = 12.sp,
            lineHeight = 15.6.sp,
            fontWeight = FontWeight(600),
            color = GrayBlue,
            fontFamily = figtreeFontFamily,
        )
        Image(
            painter = painterResource(id = R.drawable.login_img),
            contentDescription = null,
            modifier = Modifier.align(Alignment.End)
                .fillMaxWidth()
                .height(280.dp),
            contentScale = ContentScale.FillBounds
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AppGreetPreview() {
    VascommHospitalTheme {
        AppGreet()
    }
}