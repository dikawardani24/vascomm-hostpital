package dika.vasscom.ui.screens.home.component

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dika.vasscom.R

@Composable
fun ListTools() {
    Row(
        modifier = Modifier.fillMaxWidth()
            .horizontalScroll(rememberScrollState()),
    ) {
        ItemTools(
            title = "Item Tools",
            price = "Rp. 100.000",
            stockStatus = StockStatus.READY,
            imageResource = R.drawable.ic_tools,
            rate = 10
        )
        ItemTools(
            title = "Item Tools",
            price = "Rp. 100.000",
            stockStatus = StockStatus.OUT_OF_STOCK,
            imageResource = R.drawable.ic_tools,
            rate = 5
        )
        ItemTools(
            title = "Item Tools",
            price = "Rp. 100.000",
            stockStatus = StockStatus.READY,
            imageResource = R.drawable.ic_tools,
            rate = 5
        )
        ItemTools(
            title = "Item Tools",
            price = "Rp. 100.000",
            stockStatus = StockStatus.OUT_OF_STOCK,
            imageResource = R.drawable.ic_tools,
            rate = 5
        )
        ItemTools(
            title = "Item Tools",
            price = "Rp. 100.000",
            stockStatus = StockStatus.READY,
            imageResource = R.drawable.ic_tools,
            rate = 5
        )
        ItemTools(
            title = "Item Tools",
            price = "Rp. 100.000",
            stockStatus = StockStatus.OUT_OF_STOCK,
            imageResource = R.drawable.ic_tools,
            rate = 5
        )
    }
}