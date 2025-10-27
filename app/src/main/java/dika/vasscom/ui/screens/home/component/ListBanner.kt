package dika.vasscom.ui.screens.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import dika.vasscom.ui.components.BannerService
import dika.vasscom.ui.components.BannerServiceView
import dika.vasscom.ui.components.BannerTips
import dika.vasscom.ui.components.Tips

@Composable
fun ListBanner(
    tips: List<Tips>,
    bannerServices: List<BannerService>,
    onClick: (banner: Any) -> Unit = {}
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        BannerTips(
            onClick = {
                onClick.invoke(it)
            },
            tips = tips
        )
        bannerServices.forEach {
            BannerServiceView(
                bannerService = it,
                onClick = {
                    onClick.invoke(it)
                }
            )
        }
    }
}