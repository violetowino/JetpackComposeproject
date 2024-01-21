package com.dotty.mvvmproject.ui.theme.screens.contact

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactUsScreen(navController:NavHostController) {
    var email by remember { mutableStateOf(TextFieldValue()) }
    var message by remember { mutableStateOf(TextFieldValue()) }


    val context = LocalContext.current
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
            text = "CONTACT US",
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
        Text(
            text = "Got a question,\n we're ready to help.\n Reach out to us anytime.",
            color = Color.Black,
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily.Serif,
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 4.dp, end = 4.dp),
            verticalAlignment = Alignment.CenterVertically
            )
        {
            Text(text = "Call:",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif,
                fontSize = 18.sp,
                modifier = Modifier
                    .width(100.dp)
                    .padding(12.dp)
            )
            Text(
                text = "+254727542403",
                color = Color.Blue,
                fontWeight = FontWeight.Medium,
                fontFamily = FontFamily.Serif,
                fontSize = 16.sp,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier
                    .width(150.dp)
                    .clickable {
                        val phone = "+254727542403"
                        val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))
                        context.startActivity(intent)
                    }
                )
        }

        Spacer(modifier = Modifier.height(5.dp))
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 4.dp, end = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Text(text = "Email:",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif,
                fontSize = 18.sp,
                modifier = Modifier
                    .width(100.dp)
                    .padding(12.dp)
            )
            Text(
                text = "info@neighborspark.com",
                color = Color.Blue,
                fontWeight = FontWeight.Medium,
                fontFamily = FontFamily.Serif,
                fontSize = 16.sp,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier
                    .width(300.dp)
                    .clickable {
                        val emailIntent =
                            Intent(
                                Intent.ACTION_SENDTO,
                                Uri.fromParts("mailto", "info@neighborspark.com", null)
                            )
                        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject")
                        emailIntent.putExtra(Intent.EXTRA_TEXT, "Body")
                        context.startActivity(Intent.createChooser(emailIntent, "Send Email..."))
                    }
            )
        }


        Spacer(modifier = Modifier.height(5.dp))
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 4.dp, end = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Location:",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif,
                fontSize = 18.sp,
                modifier = Modifier
                    .width(120.dp)
                    .padding(12.dp)
            )

            val text = "https://maps.app.goo.gl/vCvXd8fbPQazzkki7"
            val annotatedString = buildAnnotatedString {
                withStyle(style = SpanStyle(
                    color = Color.Blue,
                    fontWeight = FontWeight.Medium,
                    textDecoration = TextDecoration.Underline)) {
                    append(text)
                }
                addStringAnnotation(
                    tag = "URL",
                    annotation = "https://maps.app.goo.gl/vCvXd8fbPQazzkki7",
                    start = 0,
                    end = text.length
                )
            }

            Text(
                text = annotatedString,
                modifier = Modifier
                    .clickable {
                        val uri = Uri.parse("https://maps.app.goo.gl/vCvXd8fbPQazzkki7")
                        val intent = Intent(Intent.ACTION_VIEW, uri)
                        context.startActivity(intent)
                    }
                    .padding(8.dp),
                fontFamily = FontFamily.Serif,
                fontSize = 16.sp,
            )
        }
        
        Spacer(modifier = Modifier.height(15.dp))
        Text(text = "Leave a message",
            style = TextStyle(
                shadow = Shadow(
                    color = Color.Red,
                    offset = Offset(5f, 5f),
                    blurRadius = 5f
                )
            ),
            fontSize = 20.sp,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        OutlinedTextField(
            value = email,
            label = {
                Text(
                    text = "Email Address",
                    color = Color.Blue,
                    fontWeight = FontWeight.Light,
                    fontFamily = FontFamily.Serif,
                    fontSize = 12.sp,
                    )
                    },
            onValueChange = { email = it },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = message,
            label = {
                Text(
                    text = "Your Message",
                    color = Color.Blue,
                    fontWeight = FontWeight.Light,
                    fontFamily = FontFamily.Serif,
                    fontSize = 12.sp,
                )
            },
            onValueChange = { message = it },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Default
            ),
            maxLines = 5,
            modifier = Modifier
                .height(100.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = {},

            modifier = Modifier.width(150.dp),
            colors = ButtonDefaults.buttonColors(Color.Blue),
            shape = CutCornerShape(10)
        ) {
            Text(text = "Submit",
                fontSize = 18.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )


        }
    }
}


@Preview
@Composable
fun ContactUsScreenPreview() {
    ContactUsScreen(rememberNavController())
}

