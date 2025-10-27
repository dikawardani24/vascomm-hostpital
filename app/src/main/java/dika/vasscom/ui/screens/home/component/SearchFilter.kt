package dika.vasscom.ui.screens.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import dika.vasscom.R
import dika.vasscom.ui.components.AppInput
import dika.vasscom.ui.theme.Navy

@Composable
fun SearchFilter() {
    Box(modifier = Modifier.fillMaxWidth()
        .padding(16.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                containerColor = Color.White,
                contentColor = Navy,
                elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 24.dp),
                shape = CircleShape
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_filter),
                    contentDescription = null
                )
            }

            AppInput(
                value = "",
                placeholderText = "Search",
                shape = RoundedCornerShape(30.dp),
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.Search,
                        contentDescription = null,
                        tint = Navy
                    )
                },
                onValueChange = {}
            )
        }
    }
}