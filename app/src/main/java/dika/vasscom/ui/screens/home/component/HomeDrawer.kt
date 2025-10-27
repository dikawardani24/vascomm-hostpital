package dika.vasscom.ui.screens.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.rounded.AddHome
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Facebook
import androidx.compose.material.icons.rounded.Whatsapp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.layout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.offset
import androidx.compose.ui.unit.sp
import dika.vasscom.ui.components.AppMenu
import dika.vasscom.ui.components.AppUserInfo
import dika.vasscom.ui.components.ItemMenu
import dika.vasscom.ui.theme.Navy
import dika.vasscom.ui.theme.VascommHospitalTheme
import dika.vasscom.ui.theme.figtreeFontFamily
import dika.vasscom.ui.theme.gilroyFontFamily

@Composable
private fun RowScope.ActionView(
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .weight(.2f)
            .layout { measurable, constraints ->
                val topPadding = -(40).dp
                val placeable =
                    measurable.measure(constraints.offset(vertical = -topPadding.roundToPx() * 2))
                layout(
                    placeable.width,
                    placeable.height + topPadding.roundToPx() * 2
                ) {
                    // Where the composable gets placed
                    placeable.place(0, +topPadding.roundToPx())
                }
            }
            .background(Navy.copy(alpha = 0.8f)),
        contentAlignment = Alignment.TopCenter
    ) {
        IconButton(onClick = onClick) {
            Icon(
                imageVector = Icons.Rounded.Close,
                contentDescription = null,
                modifier = Modifier,
                tint = Color.White,

                )
        }
    }
}

@Composable
private fun RowScope.ContentOptions(
    navigateToProfile: () -> Unit,
    navigateToSetting: () -> Unit,
    navigateToLogin: () -> Unit,
) {
    Column(
        modifier = Modifier
            .weight(1f)
            .fillMaxHeight()
            .padding(40.dp),

        ) {
        AppUserInfo(
            firstName = "Dika",
            lastName = "Wardani",
            membership = "Membership BBLK"
        )

        Spacer(modifier = Modifier.height(40.dp))

        AppMenu(
            menus = listOf(
                ItemMenu(
                    title = "Profile Saya",
                    icon = Icons.AutoMirrored.Default.ArrowForwardIos
                ),
                ItemMenu(
                    title = "Pengaturan",
                    icon = Icons.AutoMirrored.Default.ArrowForwardIos
                )
            )
        ) {
            when (it.title) {
                "Profile Saya" -> navigateToProfile()
                "Pengaturan" -> navigateToSetting()
            }
        }

        Spacer(modifier = Modifier.padding(40.dp))

        Button(
            onClick = {
                navigateToLogin()
            },
            colors = ButtonDefaults.buttonColors(Color.Red),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Logout", fontSize = 11.sp,
                fontFamily = figtreeFontFamily,
                fontWeight = FontWeight(400),
                color = Color(0xFFFFFFFF),
            )
        }

        Spacer(modifier = Modifier.height(80.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Ikuti kami di",
                fontSize = 16.sp,
                fontFamily = gilroyFontFamily,
                fontWeight = FontWeight(500),
                color = Color(0xFF002060),
            )

            Icon(
                imageVector = Icons.Rounded.Facebook,
                contentDescription = null,
                tint = Navy
            )
            Icon(
                imageVector = Icons.Rounded.AddHome,
                contentDescription = null,
                tint = Navy
            )
            Icon(
                imageVector = Icons.Rounded.Whatsapp,
                contentDescription = null,
                tint = Navy
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppDrawer(
    modifier: Modifier = Modifier,
    drawerState: DrawerState,
    navigateToProfile: () -> Unit,
    navigateToSetting: () -> Unit,
    navigateToLogin: () -> Unit,
    onCloseTap: () -> Unit
) {
    ModalDrawerSheet(
        modifier = modifier.fillMaxSize()
            .background(Color.Red),
        drawerState = drawerState,
        drawerContainerColor = Color.White,
        drawerShape = RectangleShape
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 40.dp)
        ) {
            Spacer(modifier = Modifier.height(40.dp))

            ActionView(onClick = onCloseTap)
            ContentOptions(
                navigateToSetting = navigateToSetting,
                navigateToLogin = navigateToLogin,
                navigateToProfile = navigateToProfile,
            )
        }
    }
}

@Preview
@Composable
fun AppDrawerPreview() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Open)

    VascommHospitalTheme {
        AppDrawer(
            drawerState = drawerState,
            navigateToLogin = {},
            navigateToSetting = {},
            navigateToProfile = {},
            onCloseTap = {}
        )
    }
}


