package com.tallerDirectorio.ui.screens

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import com.tallerDirectorio.Network.KtorClient

import com.tallerDirectorio.Routes
import com.tallerDirectorio.model.User
import com.tallerDirectorio.ui.Components.Loader
import com.tallerDirectorio.ui.theme.MyApplicationTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Home(modifier: Modifier = Modifier,
               navController: NavController,
               apiClient: KtorClient = KtorClient()
            ){
    val context = LocalContext.current
    var users by remember { mutableStateOf(listOf<User>()) }
    LaunchedEffect(key1 = null) {
        users = apiClient.getUsers().users
    }
    LazyColumn(

    ) {
        stickyHeader {
            Text("hola")
        }
        if(users.isEmpty()){
            item {
                Loader(modifier = Modifier.fillMaxSize())
            }
        }else{
            items(users) { usr ->
                ListItem(

                    leadingContent = {
                        AsyncImage(
                            model = usr.image,
                            contentDescription = "Imagen de perfil",
                            modifier = Modifier.size(40.dp)
                        )
                    },
                    headlineContent = {
                        Text("${usr.firstName} ${usr.lastName}")
                    },
                    supportingContent = {
                        Text("${usr.email} ")
                    },
                    trailingContent = {
                        androidx.compose.material3.Icon(Icons.Default.Menu, contentDescription = "-")
                        Spacer(modifier = Modifier.height(16.dp))
                    },
                    modifier = Modifier.clickable {

                    }

                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Home(navController = rememberNavController())
    }
}