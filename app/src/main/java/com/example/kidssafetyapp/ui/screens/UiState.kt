package com.example.kidssafetyapp.ui.screens

data class UiState(
    val temperature: String = "32",
    val heartRate: String = "98",
    val battery: String = "99",
    val longitude: String = "",
    val latitude: String = "",
    val images: List<String> = emptyList(),
    val sosAlert: Boolean = false
)
