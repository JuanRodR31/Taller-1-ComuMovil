package com.tallerDirectorio.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tallerDirectorio.viewmodel.ContactViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun UserDetailScreenFromNavigation(userId: String?, navController: NavController, contactViewModel: ContactViewModel = viewModel()) {

    val uiState by contactViewModel.uiState.collectAsState()

    val userIdInt = userId?.toIntOrNull()
    val user = uiState.usersList.find { it.id == userIdInt }

    if (user != null) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Nombre: ${user.firstName} ${user.lastName}")
            Text("Correo: ${user.email}")
            Text("Edad: ${user.age}")
            Spacer(modifier = Modifier.height(8.dp))
            Text("Teléfono: ${user.phone}")
            Spacer(modifier = Modifier.height(8.dp))
            Text("Dirección: ${user.address.address}, ${user.address.city}, ${user.address.state}, ${user.address.postalCode}, ${user.address.country}")
            Spacer(modifier = Modifier.height(8.dp))
        }
    } else {
        Text("Usuario no encontrado ${userId} ")
    }
}



