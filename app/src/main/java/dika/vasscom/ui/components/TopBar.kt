package dika.vasscom.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Reply
import androidx.compose.material.icons.automirrored.filled.RotateRight
import androidx.compose.material.icons.filled.Redo
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.RotateRight
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dika.vasscom.ui.theme.Navy
import dika.vasscom.ui.theme.VascommHospitalTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    onMenuClick: () -> Unit = {},
    onRefreshClick: () -> Unit = {}
) {
    TopAppBar(
        modifier = modifier,
        title = { },
        navigationIcon = {
            IconButton(onClick = {
                onMenuClick()
            }) {
                Icon(
                    imageVector = Icons.Rounded.Menu,
                    contentDescription = "Menu"
                )
            }
        },
        actions = {
            IconButton(onClick = onRefreshClick) {
                Icon(
                    imageVector = Icons.Rounded.Refresh,
                    contentDescription = "Cart"
                )
            }

            IconButton(onClick = {  }) {
                BadgedBox(badge = {
                    Badge(
                        containerColor = Color.Red, modifier = Modifier
                            .size(6.dp)
                            .offset(x = -(10.dp), y = 6.dp)
                    ) {

                    }
                }) {
                    Icon(
                        imageVector = Icons.Rounded.Notifications,
                        contentDescription = "Notification",
                        modifier = Modifier
                    )
                }
            }
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color.White,
            actionIconContentColor = Navy,
            navigationIconContentColor = Navy
        )
    )
}

@Preview
@Composable
fun TopBarPreview() {
    VascommHospitalTheme {
        Scaffold(
            topBar = {
                TopBar {}
            }
        ) { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {

            }
        }
    }
}