package dika.vasscom.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dika.vasscom.ui.theme.GrayBlue
import dika.vasscom.ui.theme.Navy
import dika.vasscom.R
import dika.vasscom.ui.theme.VascommHospitalTheme
import dika.vasscom.ui.theme.figtreeFontFamily
import dika.vasscom.ui.theme.gilroyFontFamily

enum class IconPosition {
    LEFT, RIGHT
}

data class BannerService(
    val title: String,
    val desc: String,
    val actionTitle: String,
    val iconResId: Int,
    val iconPosition: IconPosition
)

@Composable
private fun BoxScope.IconBannerService(iconResId: Int, alignment: Alignment, iconPosition: IconPosition) {
    val x = when(iconPosition) {
        IconPosition.LEFT -> 15.dp
        IconPosition.RIGHT -> (-20).dp
    }
    val y = when(iconPosition) {
        IconPosition.LEFT -> -(30.dp)
        IconPosition.RIGHT -> -(36.dp)
    }
    Image(
        painter = painterResource(id = iconResId),
        contentDescription = null,
        modifier = Modifier
            .align(alignment)
            .size(width = 120.dp, height = 120.dp)
            .offset(y = y, x = x)
    )
}

@Composable
private fun RowScope.ContentBanner(
    title: String,
    desc: String,
    actionTitle: String,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier.padding(16.dp)
            .weight(1f)
    ) {
        Text(
            text = title,
            fontSize = 16.sp,
            lineHeight = 33.6.sp,
            fontWeight = FontWeight(600),
            color = Navy,
            fontFamily = gilroyFontFamily,
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = desc,
            fontSize = 12.sp,
            fontFamily = figtreeFontFamily,
            lineHeight = 13.sp,
            fontWeight = FontWeight(400),
            color = GrayBlue,
        )

        Spacer(modifier = Modifier.height(12.dp))

        AppTextButton (
            title = actionTitle,
            icon = Icons.AutoMirrored.Default.ArrowForward,
            onClick = onClick,
        )
    }
}

@Composable
fun BannerServiceView(
    bannerService: BannerService,
    marginTop: Int = 0,
    onClick: () -> Unit
) {
    var top = 30
    if (marginTop > 0) top += marginTop
    Box(modifier = Modifier.fillMaxWidth()
        .padding(top = top.dp)) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 10.dp),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 20.dp),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.End)
                    .background(color = Color.White)
            ) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    if (bannerService.iconPosition == IconPosition.LEFT) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(.6f)
                        )
                    }
                    ContentBanner(
                        title = bannerService.title,
                        desc = bannerService.desc,
                        actionTitle = bannerService.actionTitle,
                        onClick = onClick
                    )
                    if (bannerService.iconPosition == IconPosition.RIGHT) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(.6f)
                        )
                    }
                }

            }
        }

        if (bannerService.iconPosition == IconPosition.LEFT) {
            IconBannerService(bannerService.iconResId, Alignment.TopStart, bannerService.iconPosition)
        }

        if (bannerService.iconPosition == IconPosition.RIGHT) {
            IconBannerService(bannerService.iconResId, Alignment.TopEnd, bannerService.iconPosition)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun BannerServicePrev() {
    VascommHospitalTheme {
        Column {
            BannerServiceView(
                bannerService = BannerService(
                    title = "Covid-19",
                    desc = "ajkhdjkhajkhahsdkjhjkasd",
                    actionTitle = "Daftar Test",
                    iconResId = R.drawable.ic_special_service,
                    iconPosition = IconPosition.RIGHT
                ),
                onClick = {}
            )
            BannerServiceView(
                bannerService = BannerService(
                    title = "Covid-19",
                    desc = "ajkhdjkhajkhahsdkjhjkasd",
                    actionTitle = "Daftar Test",
                    iconResId = R.drawable.ic_special_service,
                    iconPosition = IconPosition.LEFT,
                ),
                onClick = {}
            )
        }
    }
}