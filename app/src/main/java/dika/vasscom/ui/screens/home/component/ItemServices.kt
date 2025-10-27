package dika.vasscom.ui.screens.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.LocalHospital
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dika.vasscom.R
import dika.vasscom.ui.theme.LightGray
import dika.vasscom.ui.theme.Navy
import dika.vasscom.ui.theme.Orange
import dika.vasscom.ui.theme.VascommHospitalTheme
import dika.vasscom.ui.theme.figtreeFontFamily

@Composable
fun ItemService(
    modifier: Modifier = Modifier,
    title: String,
    price: String,
    hospitalName: String,
    location: String,
    imageRes: Int,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
            .clickable(enabled = true, onClick = onClick),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 24.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .padding(vertical = 12.dp)
                    .weight(1f)
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = title,
                    fontSize = 14.sp,
                    lineHeight = 16.8.sp,
                    fontFamily = figtreeFontFamily,
                    fontWeight = FontWeight(600),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    color = Navy,
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = price,
                    fontSize = 14.sp,
                    fontFamily = figtreeFontFamily,
                    fontWeight = FontWeight(600),
                    color = Orange,
                )

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Rounded.LocalHospital,
                        contentDescription = null,
                        tint = Navy
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = hospitalName,
                        fontSize = 14.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontFamily = figtreeFontFamily,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF6A6A6A),
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Rounded.LocationOn,
                        contentDescription = null,
                        tint = Navy
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = location,
                        fontSize = 14.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontFamily = figtreeFontFamily,
                        fontWeight = FontWeight(400),
                        color = LightGray,
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))
            }
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
            ) {
                val painter = painterResource(id = imageRes)
                Image(
                    modifier = Modifier.width(150.dp)
                        .fillMaxHeight(),
                    painter = painter,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.CenterEnd
                )
            }
        }
    }
}

@Composable
@Preview
fun ItemServicePreview() {
    VascommHospitalTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ItemService(
                title = "PCR Swab Test (Drive Thru)\n" +
                        "Hasil 1 Hari Kerja",
                price = "Rp 1.400.000",
                hospitalName = "Lenmarc Surabaya",
                location = "Dukuh Pakis, Surabaya",
                imageRes = R.drawable.img_mask_group
            )
            ItemService(
                title = "PCR Swab Test (Drive Thru)\n" +
                        "Hasil 1 Hari Kerja",
                price = "Rp 1.400.000",
                hospitalName = "Lenmarc Surabaya",
                location = "Dukuh Pakis, Surabaya",
                imageRes = R.drawable.img_mask_group_2
            )
        }
    }
}