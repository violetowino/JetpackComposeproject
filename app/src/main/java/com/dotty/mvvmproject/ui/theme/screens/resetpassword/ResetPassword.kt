package com.dotty.mvvmproject.ui.theme.screens.resetpassword

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.dotty.mvvmproject.navigation.ROUTE_LOGIN

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResetPassword(navController: NavHostController) {
    var email by remember { mutableStateOf(TextFieldValue()) }
    var newpassword by remember { mutableStateOf(TextFieldValue()) }
    var confirmnewpassword by remember { mutableStateOf(TextFieldValue()) }
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
    ){
        Spacer(modifier = Modifier.height(150.dp))
        Text(text = "RESET PASSWORD",
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

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = email, label = { Text(text = "Enter Email",
                fontWeight = FontWeight.Light,
                fontFamily = FontFamily.Serif,
                fontSize = 16.sp,
                color = Color.Blue)},

            onValueChange = { email = it }
        )
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = newpassword, label = { Text(text = "Enter new Password",
                fontWeight = FontWeight.Light,
                fontFamily = FontFamily.Serif,
                fontSize = 16.sp,
                color = Color.Blue)},

            onValueChange = { newpassword = it }
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = confirmnewpassword, label = { Text(text = "Confirm Password",
                fontWeight = FontWeight.Light,
                fontFamily = FontFamily.Serif,
                fontSize = 16.sp,
                color = Color.Blue)},

            onValueChange = { confirmnewpassword = it }
        )

        Spacer(modifier = Modifier.height(25.dp))
        Button(onClick = {
            navController.navigate(ROUTE_LOGIN)
        },
            modifier = Modifier.width(280.dp),
            colors = ButtonDefaults.buttonColors(Color.Blue),
            shape = CutCornerShape(10)
        ) {
            Text(text = "Reset",
                fontSize = 14.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )

        }


    }

}

@Preview
@Composable
fun ResetPasswordPreview() {
    ResetPassword(rememberNavController())
}