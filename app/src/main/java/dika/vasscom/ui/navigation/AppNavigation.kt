package dika.vasscom.ui.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dika.vasscom.ui.screens.home.HomeScreen
import dika.vasscom.ui.screens.login.LoginScreen
import dika.vasscom.ui.screens.register.RegisterScreen

@Composable
fun AppNavigation(
    navController: NavHostController
) {
    val enterAnim = scaleIn(
        animationSpec = tween(400),
        initialScale = 1.2f
    ) + fadeIn(animationSpec = tween(400))
    val exitAnim = scaleOut(
        animationSpec = tween(400),
        targetScale = 1.2f
    ) + fadeOut(animationSpec = tween(400))

    NavHost(
        navController = navController,
        startDestination = Route.Home.name
    ) {
        composable(
            route = Route.Login.name,
            enterTransition = { enterAnim },
            exitTransition = { exitAnim },
        ) {
            LoginScreen(
                navigateToRegister = {
                    navController.navigate(Route.Register.name)
                },
                navigateToHome = {
                    navController.navigate(Route.Home.name)
                }
            )
        }

        composable(
            route = Route.Register.name,
            enterTransition = { enterAnim },
            exitTransition = { exitAnim },
        ) {
            RegisterScreen(
                navigateToLogin = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = Route.Home.name,
            enterTransition = { enterAnim },
            exitTransition = { exitAnim },
        ) {
            HomeScreen()
        }

    }
}