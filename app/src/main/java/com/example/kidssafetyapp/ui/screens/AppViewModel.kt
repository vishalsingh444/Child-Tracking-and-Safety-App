package com.example.kidssafetyapp.ui.screens

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage


class AppViewModel: ViewModel() {

    private val _uiState = mutableStateOf(UiState())
    val uiState: State<UiState> = _uiState

    init{
        fetchDataFromFirebase()
    }
    private fun fetchDataFromFirebase() {
        val storageRef = FirebaseStorage.getInstance().reference
        val imageRef = storageRef.child("images")

        imageRef.listAll().addOnSuccessListener {listResult ->
            val downloadUrls = mutableListOf<String>()
            val imageRefs = listResult.items

            imageRefs.forEach{ imageRef ->
                imageRef.downloadUrl.addOnSuccessListener { downloadUrl ->
                    val imageUrl = downloadUrl.toString()
                    downloadUrls.add(imageUrl)

                    if(downloadUrls.size == imageRefs.size){
                        _uiState.value = _uiState.value.copy(
                            images = downloadUrls
                        )
                    }
                }.addOnFailureListener{ exception ->
                    Log.e(ContentValues.TAG, "Error getting download URL for image: ${exception.message}")
                }
            }
        }.addOnFailureListener { exception ->
            Log.e(ContentValues.TAG, "Error listing images in directory: ${exception.message}")
        }

        val databaseReference = FirebaseDatabase.getInstance().reference
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // Handle the fetched data here
                // Access the data using dataSnapshot.getValue() or iterate through dataSnapshot.getChildren()
                val dataMap: Map<String, Any>? = dataSnapshot.value as? Map<String, Any>
                if (dataMap != null) {
                    val temperature = dataMap["temperature"] as String
                    val heartRate = dataMap["heartRate"] as String
                    val battery  = dataMap["battery"] as String
                    val latitude = dataMap["latitude"] as String
                    val longitude = dataMap["longitude"] as String
                    val sosAlert = dataMap["sosAlert"] as Boolean

                    _uiState.value = _uiState.value.copy(
                        temperature = temperature,
                        heartRate = heartRate,
                        battery = battery,
                        latitude = latitude,
                        longitude = longitude,
                        sosAlert = sosAlert
                    )
                }
            }
            override fun onCancelled(databaseError: DatabaseError) {
                // Handle any error that occurred during data retrieval
                Log.w(ContentValues.TAG, "Failed to read value.", databaseError.toException())
            }
        })
    }

    fun openGoogleMaps(context: Context){
        val latitude = uiState.value.latitude
        val longitude = uiState.value.longitude
        val location = "$latitude,$longitude"
        val gmmIntentUri = Uri.parse("geo:0,0?q=$location")
        val mapIntent = Intent(Intent.ACTION_VIEW,gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        mapIntent.resolveActivity(context.packageManager)?.let {
            context.startActivity(mapIntent)
        }
    }
}