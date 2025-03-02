package com.tallerDirectorio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose.AppTheme

import com.tallerDirectorio.ui.screens.Home
import com.tallerDirectorio.ui.screens.UserDetailScreenFromNavigation
import com.tallerDirectorio.viewmodel.ContactViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme  {
                val navController = rememberNavController()
                val contactViewModel: ContactViewModel = viewModel ()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Reemplazar NavigationStack con NavHost
                    NavHost(
                        navController = navController,
                        startDestination = "home",
                        modifier = Modifier
                            .padding(innerPadding)
                            .background(MaterialTheme.colorScheme.background)
                    ) {
                        composable("home") {
                            Home(navController = navController)
                        }
                        composable("user_detail/{userId}") { backStackEntry ->
                            val userId = backStackEntry.arguments?.getString("userId")
                            UserDetailScreenFromNavigation(userId = userId, navController = navController,contactViewModel = contactViewModel )
                        }

                    }
                }
            }
        }
    }
}
