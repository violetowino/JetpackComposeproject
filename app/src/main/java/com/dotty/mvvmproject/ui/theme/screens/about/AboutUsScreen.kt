package com.dotty.mvvmproject.ui.theme.screens.about

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun AboutUsScreen(navController:NavHostController) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color.Gray)
    ) {
        Spacer(modifier = Modifier.height(80.dp))
        Text(
            text = "ABOUT US",
            style = TextStyle(
                shadow = Shadow(
                    color = Color.Black,
                    offset = Offset(5f, 5f),
                    blurRadius = 5f
                )
            ),
            fontSize = 30.sp,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold,
            color = Color.Blue,
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "MISSION",
            color = Color.Red,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif,
            fontSize = 20.sp,
            textDecoration = TextDecoration.Underline
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "To provide efficient and reliable car parking solutions that enhances" +
                    "convenience and accessibility for our customers, while prioritizing safety," +
                    "sustainability and exceptional services",
            fontSize = 14.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "VISION",
            color = Color.Red,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif,
            fontSize = 20.sp,
            textDecoration = TextDecoration.Underline
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "Achieving seamless urban mobility through innovative and sustainable parking " +
                    "solutions, where our commitment to efficiency, accessibility, and environmental" +
                    "responsibility transforms parking into a hassle-free experience for everyone",
            fontSize = 14.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "CORE VALUES",
            color = Color.Red,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif,
            fontSize = 20.sp,
            textDecoration = TextDecoration.Underline
        )
        Spacer(modifier = Modifier.height(5.dp))
        CoreValues()

//        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "",
            fontSize = 12.sp,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            textAlign = TextAlign.Center
        )

    }
}

@Composable
fun CoreValues() {
    val values = listOf(
        "Integrity",
        "Innovation",
        "Sustainability",
        "Safety and Security",
        "Customer-Centricity",
        "Teamwork and Respect",
        "Community Engagement"
    )

    val annotatedString = buildAnnotatedString {
        values.forEachIndexed { index, value ->
            withStyle(style = SpanStyle(color = Color.Black, fontWeight = FontWeight.SemiBold)) {
                append("• $value")
            }
            if (index < values.size - 1) {
                append("\n")
            }
        }
    }

    Column(
        modifier = Modifier.padding(6.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = annotatedString,
            fontSize = 14.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.Black,
            modifier = Modifier.fillMaxWidth(),
//            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center
        )
    }
}


@Preview
@Composable
fun AboutUsScreenPreview() {
    AboutUsScreen(rememberNavController())
}