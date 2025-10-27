package dika.vasscom.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dika.vasscom.ui.theme.GrayBlue
import dika.vasscom.R
import dika.vasscom.ui.theme.VascommHospitalTheme
import dika.vasscom.ui.theme.figtreeFontFamily

data class Tips(
    val title: String,
    val titleBold: String,
    val desc: String,
    val iconResId: Int,
)

@Composable
fun TipsView(
    title: @Composable () -> Unit,
    desc: String,
    onClick: () -> Unit,
    iconResId: Int
) {
    Box(modifier = Modifier.fillMaxWidth()
        .padding(top = 36.dp)) {
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
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Color.White,
                                Color(0xFFDAE9F9)
                            ),
                            startX = 0f,
                            endX = Float.POSITIVE_INFINITY
                        )
                    )
            ) {
                Row {
                    Column(
                        modifier = Modifier.padding(16.dp)
                            .weight(1f)
                    ) {
                        title()

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

                        AppSmallButton(
                            title = "Selengkapnya",
                            onClick = onClick,
                        )
                    }
                    Box(
                        modifier = Modifier.width(110.dp)
                    ) {}
                }
            }
        }
        Image(
            painter = painterResource(id = iconResId),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .offset(y = -(36.dp))
        )
    }
}

@Composable
fun BannerTips(
    onClick: (tips: Tips) -> Unit,
    tips: List<Tips> = emptyList()
) {
    if (tips.isEmpty()) return
    var selectedTips by remember { mutableStateOf(tips[0]) }

    Box {
        TipsView(
            title = {
                TitleAnnotated(
                    title = selectedTips.title,
                    boldText = selectedTips.titleBold,
                    fontSize = 18
                )
            },
            desc = selectedTips.desc,
            onClick = {
                onClick.invoke(selectedTips)
            },
            iconResId = selectedTips.iconResId
        )
        AppPager(
            modifier = Modifier.align(Alignment.BottomEnd)
                .padding(end = 50.dp, bottom = 30.dp),
            numberOfPages = tips.size,
            onSelected = {
                selectedTips = tips[it]
            }
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BannerTipsPreview() {
    VascommHospitalTheme {
        BannerTips(
            onClick = {},
            tips = listOf(
                Tips(
                    title = "Solusi, ",
                    titleBold = "Kesehatan anda",
                    desc = "Update informasi seputar kesehatan\nsemua bisa disini !",
                    iconResId = R.drawable.ic_schedule
                ),
                Tips(
                    title = "Solusi 1, ",
                    titleBold = "Kesehatan anda",
                    desc = "Update informasi seputar kesehatan\nsemua bisa disini !",
                    iconResId = R.drawable.ic_schedule
                ),
                Tips(
                    title = "Solusi 2, ",
                    titleBold = "Kesehatan anda",
                    desc = "Update informasi seputar kesehatan\nsemua bisa disini !",
                    iconResId = R.drawable.ic_schedule
                )
            )
        )
    }
}