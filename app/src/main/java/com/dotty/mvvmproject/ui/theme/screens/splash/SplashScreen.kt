package com.dotty.mvvmproject.ui.theme.screens.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dotty.mvvmproject.R
import com.dotty.mvvmproject.navigation.ROUTE_HOME
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    val scale = remember {androidx.compose.animation.core.Animatable(0f)}

    LaunchedEffect(key1 = true){
       scale.animateTo(
           targetValue = 2.0f,
           animationSpec = tween(
               durationMillis = 800,
               easing = {
                   OvershootInterpolator(4f).getInterpolation(it)
               }
           )
       )
        delay(3000L)
        navController.navigate(ROUTE_HOME)
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Gray)
    )
    {
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ){
            Image(
                painter = painterResource(id = R.drawable.cars),
                contentDescription = "Profile pic",
                modifier = Modifier.scale(scale.value)
            )
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "WELCOME",
                style = TextStyle(
                    shadow = Shadow(
                        color = Color.Black,
                        offset = Offset(5f, 5f),
                        blurRadius = 5f
                    )
                ),
                fontSize = 50.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
                color = Color.Blue,
            )
        }


    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    SplashScreen(rememberNavController())
}