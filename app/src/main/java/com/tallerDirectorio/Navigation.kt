package com.tallerDirectorio

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.tallerDirectorio.model.User
import com.tallerDirectorio.ui.screens.Home
import com.tallerDirectorio.ui.screens.UserDetails
import kotlinx.serialization.Serializable

@Serializable
sealed interface Routes{

    @Serializable
    object Home

    @Serializable
    data class userDetails(val user: User)

}

@Composable
fun NavigationStack(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.Home, modifier = modifier) {
        composable<Routes.Home> {
            Home(navController = navController)
        }
        /*
        composable<Routes.userDetails> {
            val args = it.toRoute<Routes.userDetails>()
            UserDetails()
        }

         */

    }
}