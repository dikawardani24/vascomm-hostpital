package dika.vasscom.ui.navigation

sealed class Route(val name: String) {
    object Login: Route("login")
    object Register: Route("register")
    object Home: Route("home")
    object Profile: Route("profile")
}