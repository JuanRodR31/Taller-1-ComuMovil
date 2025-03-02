package com.tallerDirectorio.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tallerDirectorio.viewmodel.ContactViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val contactViewModel: ContactViewModel = viewModel() // ViewModel compartido

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            Home(navController = navController, contactViewModel = contactViewModel)
        }
        composable("user_detail/{userId}") { backStackEntry ->
            val userId = backStackEntry.arguments?.getString("userId")
            UserDetailScreenFromNavigation(userId = userId, navController = navController, contactViewModel = contactViewModel)
        }
    }
}