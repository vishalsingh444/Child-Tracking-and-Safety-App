package com.example.kidssafetyapp.ui.screens

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kidssafetyapp.ui.components.CardComponent
import com.example.kidssafetyapp.ui.components.CardComponentWithText
import com.example.kidssafetyapp.ui.components.KidsSafetyTopAppBar
import com.example.kidssafetyapp.R
import com.example.kidssafetyapp.notification.AlertNotificationService

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun KidsSafetyApp(viewModel: AppViewModel){
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            KidsSafetyTopAppBar()
        }
    ){
        NavHost(
            navController = navController,
            startDestination = "home"
        ){
            composable(route = "home"){
                HomeScreen(viewModel,modifier = Modifier,navController = navController)
            }

            composable(route = "image"){
                ImageScreen(viewModel = viewModel,navController = navController)
            }
        }

    }
}
@Composable
fun HomeScreen(
    viewModel: AppViewModel,
    navController: NavController,
    modifier: Modifier = Modifier
){
    val context = LocalContext.current
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Row{
            CardComponentWithText(info = viewModel.uiState.value.heartRate, text = "Pulse Rate")
            Spacer(modifier.width(16.dp))
            CardComponent(icon = R.drawable.location_on_48px, text = "Location", onClick = {viewModel.openGoogleMaps(context)})
        }
        Row{
            CardComponentWithText(info = viewModel.uiState.value.temperature, text = "Temperature" )
            Spacer(modifier.width(16.dp))
            CardComponent(icon = R.drawable.imagesmode_48px, text = "Images", onClick = { navController.navigate("image") })
        }
        Row{
            CardComponentWithText(info = viewModel.uiState.value.battery, text = "Battery")
            Spacer(modifier.width(16.dp))
            CardComponent(icon = R.drawable.sos_48px, text = "SOS!", onClick = {} )
        }
    }
}


//@Preview(showSystemUi = true)
//@Composable
//fun HomeScreenPreview(){
//    KidsSafetyAppTheme() {
//        KidsSafetyApp()
//    }
//}