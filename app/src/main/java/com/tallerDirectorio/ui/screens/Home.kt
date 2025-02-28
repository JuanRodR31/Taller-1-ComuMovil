package com.tallerDirectorio.ui.screens

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
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

//import com.juligraph.listapp.Routes
import com.tallerDirectorio.model.User
//import com.juligraph.listapp.network.KtorClient
//import com.juligraph.listapp.ui.components.Loader
import com.tallerDirectorio.ui.theme.MyApplicationTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier,
               navController: NavController,
               apiClient: KtorClient = KtorClient()
            ){
    val context = LocalContext.current
    var users by remember { mutableStateOf(listOf<User>()) }
    LazyColumn(

    ) {
        stickyHeader {
            Text("hola")
        }
        if(users.isEmpty()){

        }else{
            items(users) { usr ->
                ListItem(
                    headlineContent = {
                        Text("${usr.firstName} - (${usr.gender})")
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
        HomeScreen(navController = rememberNavController())
    }
}