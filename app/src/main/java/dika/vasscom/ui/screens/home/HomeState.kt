package dika.vasscom.ui.screens.home

import dika.vasscom.ui.components.BannerService
import dika.vasscom.ui.components.Tips

sealed class HomeState {
    object Idle: HomeState()
    object Loading : HomeState()
    data class ShowData(
        val tips: List<Tips>,
        val banners: List<BannerService>
    ): HomeState()
    data class Error(val message: String): HomeState()
}