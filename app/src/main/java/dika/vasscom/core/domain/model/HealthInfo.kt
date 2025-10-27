package dika.vasscom.core.domain.model

import dika.vasscom.ui.components.Tips

data class HealthInfo(
    val title: String,
    val desc: String,
    val iconResId: Int,
) {
    companion object {
        fun HealthInfo.toTips(): Tips {
            val titles = title.split(",")
            return Tips(
                title = titles[0],
                titleBold = if (titles.size > 1) titles[1] else "",
                desc = desc,
                iconResId = iconResId,
            )
        }
    }
}