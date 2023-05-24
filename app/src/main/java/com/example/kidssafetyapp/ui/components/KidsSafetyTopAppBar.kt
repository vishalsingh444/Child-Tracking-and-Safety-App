package com.example.kidssafetyapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kidssafetyapp.ui.theme.KidsSafetyAppTheme

@Composable
fun KidsSafetyTopAppBar(modifier: Modifier = Modifier){
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(color = MaterialTheme.colors.background)
            .shadow(elevation = 2.dp, ambientColor = Color.Black),
        contentAlignment = Alignment.Center
    ){
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ){
            Icon(imageVector = Icons.Default.Menu,
                contentDescription = "Menu",
                tint = MaterialTheme.colors.onSurface,
                modifier = Modifier.size(30.dp)
            )
            Spacer(Modifier.width(70.dp))
            Text(
                text = "Kids Safety App",
                fontSize = 22.sp,
                color = MaterialTheme.colors.onSurface,
            )
        }
    }
}

@Preview
@Composable
fun KidsSafetyTopAppBarPreview(){
    KidsSafetyAppTheme {
        KidsSafetyTopAppBar()
    }
}