package com.example.fintrack.corePlatform.customViews

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ProvideSpace(height:Float, width: Float = 0.0f) {
//    Spacer(modifier = Modifier.height(height.dp).width(width.dp))
    Spacer(modifier = Modifier.fillMaxHeight(height).fillMaxWidth(width))
}
//import androidx.compose.foundation.layout.*
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.platform.LocalConfiguration
//import androidx.compose.ui.unit.dp
//
////@Composable
////fun ProvideSpace(heightInDp: Int, widthInDp: Int = 0) {
////    val screenWidthDp = LocalConfiguration.current.screenWidthDp
////    val screenHeightDp = LocalConfiguration.current.screenHeightDp
////
////    val heightPercentage = (heightInDp.toFloat() / screenHeightDp) * 100
////    val widthPercentage = if (widthInDp == 0) 1f else (widthInDp.toFloat() / screenWidthDp) * 100
////
////    Spacer(modifier = Modifier
////        .fillMaxHeight(heightPercentage)
////        .fillMaxWidth(widthPercentage)
////    )
////}
