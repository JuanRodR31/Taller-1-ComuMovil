package com.tallerDirectorio.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tallerDirectorio.viewmodel.ContactViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.tallerDirectorio.model.Address
import com.tallerDirectorio.model.User
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.HorizontalDivider
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


@Composable
fun UserDetailScreenFromNavigation(userId: String?, navController: NavController, contactViewModel: ContactViewModel = viewModel()) {

    val uiState by contactViewModel.uiState.collectAsState()
    val context = LocalContext.current

    val userIdInt = userId?.toIntOrNull()
    val user = uiState.usersList.find { it.id == userIdInt }

    if (user != null) {
        Column(modifier = Modifier.padding(16.dp)) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Red)
                .height(200.dp)
                .offset(y = 95.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
                ) {
                Box(modifier = Modifier
                    .border(5.dp, Color.Green, RoundedCornerShape(50.dp))
                    .clip(RoundedCornerShape(300.dp))
                )
                {
                    AsyncImage(
                        model = user.image,
                        contentDescription = "Imagen de perfil",
                        modifier = Modifier
                            .size(110.dp)
                            .clip(RoundedCornerShape(300.dp))
                            .align(Alignment.Center)
                            .background(color = Color.Blue)

                    )
                }
            }

            Spacer(modifier = Modifier.height(60.dp))


            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(top = 40.dp)

            ) {
                Text(
                    text = "${user.firstName} ${user.lastName}" +
                            (if (!user.maidenName.isNullOrBlank()) " (${user.maidenName})" else ""),
                    color = Color.Blue,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.5.sp,
                    modifier = Modifier.padding(8.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))
                Row (modifier = Modifier
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text("${user.phone} ")
                    androidx.compose.material3.Button(
                        onClick = { makePhoneCall(context = context, user.phone) }
                    ) {
                        androidx.compose.material3.Icon(
                            imageVector = androidx.compose.material.icons.Icons.Default.Phone,
                            contentDescription = "Call",
                            tint = Color.White
                        )
                        Text(text = "Call", color = Color.White)
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                HorizontalDivider(modifier = Modifier
                    .padding(vertical = 4.dp)
                    .padding(horizontal = 15.dp)
                    .background(color = Color.Gray)
                )

                Spacer(modifier = Modifier.height(20.dp))

                Column (modifier = Modifier
                    .padding(20.dp)
                ){
                    Text("Correo: ${user.email}")
                    Text("Edad: ${user.age}")
                    Text("Género: ${user.gender}")
                    Text("Fecha de nacimiento: ${user.birthDate}")
                }


                Spacer(modifier = Modifier.height(16.dp))

                Column (modifier = Modifier
                    .padding(20.dp)
                ) {
                    Text("Dirección: ${user.address.address}")
                    Text("Ciudad: ${user.address.city}")
                    Text("Estado: ${user.address.state}")
                    Text("Código postal: ${user.address.postalCode}")
                    Text("Pais: ${user.address.country}")
                    Text("Código de estado: ${user.address.stateCode}")

                }

                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    } else {
        Text("Usuario no encontrado ${userId} ")
    }
}


fun makePhoneCall(context: Context, phoneNumber: String) {
    val intent = Intent(Intent.ACTION_DIAL).apply {
        data = Uri.parse("tel:$phoneNumber")
    }
    context.startActivity(intent)
}

