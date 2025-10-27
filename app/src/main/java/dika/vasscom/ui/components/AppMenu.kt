package dika.vasscom.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dika.vasscom.ui.theme.LightGray
import dika.vasscom.ui.theme.VascommHospitalTheme

data class ItemMenu(
    val title: String,
    val icon: ImageVector
)

@Composable
private fun ItemMenuView(
    title: String,
    icon: ImageVector,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AppTextLite(
            modifier = Modifier.weight(1f),
            text = title,
            size = 14,
        )
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = LightGray
        )
    }
}

@Composable
fun AppMenu(
    modifier: Modifier = Modifier,
    menus: List<ItemMenu>,
    onClick: (item: ItemMenu) -> Unit = {},
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        menus.forEach {
            Box(
                modifier = Modifier.clip(RoundedCornerShape(8.dp))
                    .padding(4.dp)
                    .clickable(enabled = true, onClick = { onClick.invoke(it) })
            ) {
                ItemMenuView(
                    title = it.title,
                    icon = it.icon
                )
            }
        }
    }
}

@Composable
@Preview
fun AppMenuPreview() {
    VascommHospitalTheme {
        val menus = listOf(
            ItemMenu(
                title = "Jajan",
                icon = Icons.AutoMirrored.Default.ArrowForwardIos
            ),
            ItemMenu(
                title = "Jajan 1",
                icon = Icons.AutoMirrored.Default.ArrowForwardIos
            ),
            ItemMenu(
                title = "Jajan 2",
                icon = Icons.AutoMirrored.Default.ArrowForwardIos
            )
        )
        AppMenu(menus = menus) {

        }
    }
}