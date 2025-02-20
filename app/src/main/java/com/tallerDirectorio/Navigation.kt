package com.tallerDirectorio

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable

@Serializable
sealed interface Routes{

    @Serializable
    object Home

    /*
    @Serializable
    data class userDetails()

     */
}

@Composable
fun NavigationStack(modifier: Modifier = Modifier){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.Home.toString(), modifier = modifier) {

    }
}