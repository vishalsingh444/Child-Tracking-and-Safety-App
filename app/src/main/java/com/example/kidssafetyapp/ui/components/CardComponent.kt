package com.example.kidssafetyapp.ui.components

import android.content.Context
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kidssafetyapp.ui.theme.KidsSafetyAppTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CardComponent(
    modifier: Modifier = Modifier,
    @DrawableRes
    icon: Int,
    text: String,
    onClick: () -> Unit
){
    val context = LocalContext.current
    Card(
        modifier = modifier
            .height(150.dp)
            .width(150.dp)
            .padding(16.dp)
            .shadow(shape = RoundedCornerShape(8.dp), elevation = 4.dp, ambientColor = Color.Black),
        elevation = 4.dp,
        shape = MaterialTheme.shapes.medium,
        backgroundColor = MaterialTheme.colors.surface,
        onClick = onClick
    ) {
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                Modifier.size(70.dp),
                tint = MaterialTheme.colors.onSurface
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = text,
                fontSize = 16.sp,
                color = MaterialTheme.colors.onSurface,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
@Composable
fun CardComponentWithText(
    modifier: Modifier = Modifier,
    info: String,
    text: String,
){
    Card(
        modifier = modifier
            .height(150.dp)
            .width(150.dp)
            .padding(16.dp)
            .shadow(shape = RoundedCornerShape(8.dp), elevation = 4.dp, ambientColor = Color.Black),
        elevation = 4.dp,
        shape = MaterialTheme.shapes.medium,
        backgroundColor = MaterialTheme.colors.surface,
    ) {
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(text = info,fontSize = 55.sp)
            Text(
                text = text,
                fontSize = 16.sp,
                color = MaterialTheme.colors.onSurface,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

//@Preview(showSystemUi = false)
//@Composable
//fun CardComponentPreview(){
//    KidsSafetyAppTheme() {
//        CardComponent(
//            icon = Icons.Default.LocationOn,
//            text = "Location"
//        )
//    }
//
//}