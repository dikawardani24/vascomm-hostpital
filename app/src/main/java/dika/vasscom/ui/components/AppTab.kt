package dika.vasscom.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dika.vasscom.ui.theme.GrayBlue
import dika.vasscom.ui.theme.Navy
import dika.vasscom.ui.theme.SageGreen
import dika.vasscom.ui.theme.VascommHospitalTheme
import dika.vasscom.ui.theme.figtreeFontFamily

@Composable
fun AppTabs(
    list: List<String>,
    onTabSelected: (pos: Int) -> Unit
) {
    var selectedIndex by remember { mutableIntStateOf(0) }

    TabRow(selectedTabIndex = selectedIndex,
        contentColor = SageGreen,
        modifier = Modifier
            .clip(RoundedCornerShape(50))
            .wrapContentWidth(),
        indicator = { tabPositions: List<TabPosition> ->
            Box {}
        }
    ) {
        list.forEachIndexed { index, text ->
            val selected = selectedIndex == index
            Tab(
                modifier = if (selected) Modifier
                    .clip(RoundedCornerShape(50))
                    .background(SageGreen)
                else Modifier,
                selected = selected,
                onClick = {
                    selectedIndex = index
                    onTabSelected(index)
                },
                text = {
                    val color = if (selected) Navy else GrayBlue
                    val fontWeight = if (selected) FontWeight(600) else FontWeight(200)
                    Text(
                        text = text,
                        color = color,
                        fontWeight = fontWeight,
                        fontFamily = figtreeFontFamily,
                        maxLines = 1
                    )
                }
            )
        }
    }
}

@Composable
@Preview
fun AppTabsPreview() {
    VascommHospitalTheme {
        AppTabs(
            list = listOf("Tab 1", "Tab 2", "Tab 3"),
            onTabSelected = {}
        )
    }
}