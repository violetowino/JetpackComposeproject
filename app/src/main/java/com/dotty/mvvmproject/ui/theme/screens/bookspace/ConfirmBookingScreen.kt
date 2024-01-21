package com.dotty.mvvmproject.ui.theme.screens.bookspace

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun ConfirmBookingScreen(
    navController:NavHostController,
    selectedDate: String,
    selectedTimeIn: String,
    selectedTimeOut: String,
    selectedSpaceIndex: Int
) {
    val context = LocalContext.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color.Gray)
    ) {
        Spacer(modifier = Modifier.height(80.dp))
        Text(
            text = "CONFIRM BOOKING",
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

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedButton(
            onClick = {
                val simToolKitLaunchIntent = context.packageManager.getLaunchIntentForPackage("com.android.stk")
                simToolKitLaunchIntent?.let { context.startActivity(it) }
            },
            contentPadding = PaddingValues(8.dp),
            modifier = Modifier
                .width(150.dp)
                .padding(4.dp) // Add padding to adjust the appearance
                .align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color.Blue,
//                        backgroundColor = Color.Transparent, // Set background color to transparent
            ),
            shape = CutCornerShape(10)
        ) {
            Text(
                text = "PAY WITH M-PESA",
                fontSize = 18.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                modifier = Modifier
                    .padding(8.dp)
            )
        }

        Spacer(modifier = Modifier.height(35.dp))

        Text(
            text = "Selected Date: $selectedDate",
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            ),
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = "Selected Time-In: $selectedTimeIn",
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            ),
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = "Selected Time-Out: $selectedTimeOut",
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            ),
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = "Selected Space Index: $selectedSpaceIndex",
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            ),
            modifier = Modifier.padding(bottom = 8.dp)
        )

    }
    
}


@Preview
@Composable
fun ConfirmBookingScreenPreview() {
    ConfirmBookingScreen(
        rememberNavController(),
        selectedDate = "Jan 01, 2023",
        selectedTimeIn = "10:00 AM",
        selectedTimeOut = "12:00 PM",
        selectedSpaceIndex = 1
    )
}
