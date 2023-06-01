package com.example.kidssafetyapp

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.kidssafetyapp.notification.AlertNotificationService
import com.example.kidssafetyapp.ui.screens.AppViewModel
import com.example.kidssafetyapp.ui.screens.KidsSafetyApp
import com.example.kidssafetyapp.ui.theme.KidsSafetyAppTheme


class MainActivity : ComponentActivity() {

    private val viewModel: AppViewModel by viewModels{
        AppViewModelFactory(applicationContext)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KidsSafetyAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    KidsSafetyApp(viewModel)
                }
            }
        }
    }
}
