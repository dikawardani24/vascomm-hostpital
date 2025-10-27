package dika.vasscom.core.domain.model

import dika.vasscom.R
import dika.vasscom.ui.components.BannerService
import dika.vasscom.ui.components.IconPosition

enum class HealthServiceOfferType {
    SPECIAL_SERVICE,
    TRACKING_CHECK_UP
}

data class HealthServiceOffer(
    val title: String,
    val desc: String,
    val type: HealthServiceOfferType
) {
    companion object {
        fun HealthServiceOffer.toBanner(): BannerService {
            return BannerService(
                title = title,
                desc = desc,
                actionTitle = if (type == HealthServiceOfferType.SPECIAL_SERVICE) "Daftar Test" else "Track",
                iconResId = if (type == HealthServiceOfferType.SPECIAL_SERVICE) R.drawable.ic_special_service else R.drawable.ic_tracking,
                iconPosition = if (type == HealthServiceOfferType.SPECIAL_SERVICE) IconPosition.RIGHT else IconPosition.LEFT
            )
        }
    }
}