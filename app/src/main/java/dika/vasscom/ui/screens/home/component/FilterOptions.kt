package dika.vasscom.ui.screens.home.component

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import dika.vasscom.ui.components.AppChip

@Composable
fun FilterOption() {
    val filterLabelList = listOf("All Product", "Layanan Kesehatan", "Alat Kesehatan")
    var selectedIndex by remember { mutableIntStateOf(0) }

    LazyRow(
        content = {
            itemsIndexed(filterLabelList) { index, item ->
                AppChip(
                    label = item,
                    isSelected = index == selectedIndex,
                    onClick = {
                        selectedIndex = index
                    }
                )
            }
        }
    )
}
