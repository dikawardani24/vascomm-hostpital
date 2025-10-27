package dika.vasscom.ui.screens.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dika.vasscom.R
import dika.vasscom.ui.components.AppSpacer
import dika.vasscom.ui.components.AppTextLite
import dika.vasscom.ui.components.AppTitle
import dika.vasscom.ui.theme.Green
import dika.vasscom.ui.theme.Orange
import dika.vasscom.ui.theme.SageGreen
import dika.vasscom.ui.theme.VascommHospitalTheme
import dika.vasscom.ui.theme.figtreeFontFamily

enum class StockStatus {
    READY, OUT_OF_STOCK
}

data class StockStatusConfig(
    val colorFont: Color,
    val backgroundColor: Color,
    val desc: String
)

private fun getStockStatus(stockStatus: StockStatus): StockStatusConfig {
    return when (stockStatus) {
        StockStatus.READY -> StockStatusConfig(
            colorFont = Green,
            backgroundColor = SageGreen,
            desc = "Ready Stock"
        )
        StockStatus.OUT_OF_STOCK -> StockStatusConfig(
            colorFont = Color.White,
            backgroundColor = Color.Red,
            desc = "Out of Stock"
        )
    }
}

@Composable
fun ItemTools(
    title: String,
    price: String,
    stockStatus: StockStatus,
    imageResource: Int,
    rate: Int,
    onClick: () -> Unit = {}
) {
    val config = getStockStatus(stockStatus)
    Box(
        modifier = Modifier.padding(16.dp)
    ) {
        Card(
            modifier = Modifier
                .width(100.dp)
                .clickable(enabled = true, onClick = onClick),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 20.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
                contentColor = Color.White
            )
        ) {
            Box(
                modifier = Modifier.padding(10.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Image(
                        modifier = Modifier.size(10.dp),
                        painter = painterResource(id = R.drawable.ic_star),
                        contentDescription = null
                    )
                    AppSpacer(width = 2)
                    AppTextLite(text = rate.toString(), size = 8)
                }
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        modifier = Modifier.size(70.dp),
                        painter = painterResource(id = imageResource),
                        contentDescription = null
                    )
                    AppSpacer(5)
                    AppTitle(modifier = Modifier.fillMaxWidth(), title = title, size = 10)
                    AppSpacer(height = 2)
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            modifier = Modifier.weight(1f),
                            text = price,
                            fontFamily = figtreeFontFamily,
                            fontWeight = FontWeight(600),
                            color = Orange,
                            style = TextStyle(fontSize = 6.sp)
                        )
                        Box(
                            modifier = Modifier
                                .background(
                                    color = config.backgroundColor,
                                    shape = RoundedCornerShape(3.dp)
                                )
                        ) {
                            Text(
                                modifier = Modifier.padding(2.dp),
                                text = config.desc,
                                fontFamily = figtreeFontFamily,
                                fontWeight = FontWeight(600),
                                color = config.colorFont,
                                style = TextStyle(fontSize = 6.sp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun ItemToolsPrev() {
    VascommHospitalTheme {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(5.dp)
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
        }
    }
}