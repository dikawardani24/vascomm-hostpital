package dika.vasscom.ui.components

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dika.vasscom.ui.theme.VascommHospitalTheme

@Composable
fun AppPager(
    modifier: Modifier = Modifier,
    numberOfPages: Int,
    selectedPage: Int = 0,
    selectedColor: Color = Color.White,
    defaultColor: Color = Color.Gray,
    defaultRadius: Dp = 8.dp,
    selectedLength: Dp = 40.dp,
    space: Dp = 4.dp,
    onSelected: (Int) -> Unit = {}
) {
    var currentPos by remember { mutableIntStateOf(selectedPage) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(space),
        modifier = modifier
    ) {
        repeat(numberOfPages) {
            Indicator(
                isSelected = it == currentPos,
                selectedColor = selectedColor,
                defaultColor = defaultColor,
                defaultRadius = defaultRadius,
                selectedLength = selectedLength,
                modifier = Modifier
                    .height(defaultRadius)
                    .clip(CircleShape)
                    .clickable(enabled = true, onClick = {
                        currentPos = it
                        onSelected(currentPos)
                    })
            )
        }
    }
}

/**
 * pager indicator item
 */
@Composable
fun Indicator(
    modifier: Modifier = Modifier,
    isSelected: Boolean,
    selectedColor: Color,
    defaultColor: Color,
    defaultRadius: Dp,
    selectedLength: Dp,
) {
    val width by animateDpAsState(
        targetValue = if (isSelected) selectedLength else defaultRadius,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy)
    )
    Box(
        modifier = modifier
            .width(width)
            .clip(CircleShape)
            .background(color = if (isSelected) selectedColor else defaultColor)
    )
}

@Composable
@Preview
fun AppPagerPreview() {
    VascommHospitalTheme {
        AppPager(
            numberOfPages = 5,
        )
    }
}
