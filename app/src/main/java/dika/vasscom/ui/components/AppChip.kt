package dika.vasscom.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dika.vasscom.ui.theme.Navy
import dika.vasscom.ui.theme.figtreeFontFamily

@Composable
fun AppChip(
    modifier: Modifier = Modifier,
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Box(modifier = Modifier.padding(16.dp)) {
        Card(
            modifier = modifier.clickable(
                enabled = true,
                onClick = onClick
            ),
            shape = RoundedCornerShape(30.dp),
            colors = CardDefaults.cardColors(containerColor = if (isSelected) Navy else Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 12.dp)
        ) {
            Box(
                modifier = modifier
                    .padding(horizontal = 24.dp, vertical = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = label,
                    fontSize = 12.sp,
                    fontFamily = figtreeFontFamily,
                    fontWeight = FontWeight(700),
                    color = if (isSelected) Color.White else Navy,
                )
            }
        }
    }
}
