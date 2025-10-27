package dika.vasscom.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AppSpacer(
    height: Int = 16,
    width: Int? = null
) {
    if (width != null) {
        Spacer(modifier = Modifier.width(width.dp))
        return
    }
    Spacer(modifier = Modifier.height(height.dp))
}