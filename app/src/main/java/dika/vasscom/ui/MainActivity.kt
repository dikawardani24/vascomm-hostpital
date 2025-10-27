package dika.vasscom.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import dika.vasscom.ui.navigation.AppNavigation
import dika.vasscom.ui.theme.VascommHospitalTheme

class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            VascommHospitalTheme {
                Surface {
                    AppNavigation(rememberNavController())
                }
            }
        }
    }
}