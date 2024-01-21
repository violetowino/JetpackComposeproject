package com.dotty.mvvmproject.ui.theme.screens.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.dotty.mvvmproject.R
import com.dotty.mvvmproject.data.AuthViewModel
import com.dotty.mvvmproject.navigation.ROUTE_LOGIN

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navController: NavHostController) {
    var username by remember { mutableStateOf(TextFieldValue()) }
    var email by remember { mutableStateOf(TextFieldValue()) }
    var password by remember { mutableStateOf(TextFieldValue()) }
    var confirmpassword by remember { mutableStateOf(TextFieldValue()) }
    var passwordVisibility by remember { mutableStateOf(false) }
    val context = LocalContext.current

    val checked = remember { mutableStateOf(false) }
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
    ) {
        Spacer(modifier = Modifier.height(100.dp))
        Text(
            text = "REGISTER HERE",
            style = TextStyle(
                shadow = Shadow(
                    color = Color.Black,
                    offset = Offset(5f, 5f),
                    blurRadius = 5f
                )
            ),
            fontSize = 25.sp,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold,
            color = Color.Blue,
        )

        Spacer(modifier = Modifier.height(35.dp))
        OutlinedTextField(
            value = username, label = {
                Text(
                    text = "Enter Username",
                    fontWeight = FontWeight.Light,
                    fontFamily = FontFamily.Serif,
                    fontSize = 16.sp,
                    color = Color.Blue
                )
            },
            onValueChange = { username = it },
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Person,
                        contentDescription = "user icon",
                        tint = Color.Blue
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            )
        )

        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = email, label = {
                Text(
                    text = "Enter Email",
                    fontWeight = FontWeight.Light,
                    fontFamily = FontFamily.Serif,
                    fontSize = 16.sp,
                    color = Color.Blue
                )
            },
            onValueChange = { email = it },
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Email,
                        contentDescription = "Email icon",
                        tint = Color.Blue
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
               keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            )
        )

        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = password, label = {
                Text(
                    text = "Enter Password",
                    fontWeight = FontWeight.Light,
                    fontFamily = FontFamily.Serif,
                    fontSize = 16.sp,
                    color = Color.Blue
                )
            },
            onValueChange = { password = it },
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Lock,
                        contentDescription = "Password icon",
                        tint = Color.Blue
                    )
                }
            },
            trailingIcon = {
                IconButton(onClick = { passwordVisibility = !passwordVisibility },
                    modifier = Modifier.padding(4.dp)) {
                    Icon(imageVector = if (passwordVisibility) ImageVector.vectorResource(id = R.drawable.baseline_visibility_24)
                            else ImageVector.vectorResource(id = R.drawable.baseline_visibility_off_24),
                        contentDescription = "Password visibility",
                        tint = Color.Blue
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            ),
            visualTransformation = if (passwordVisibility) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            }
        )

        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = confirmpassword, label = {
                Text(
                    text = "Confirm Password",
                    fontWeight = FontWeight.Light,
                    fontFamily = FontFamily.Serif,
                    fontSize = 16.sp,
                    color = Color.Blue
                )
            },
            onValueChange = { confirmpassword = it },
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Lock,
                        contentDescription = "Password icon",
                        tint = Color.Blue
                    )
                }
            },
            trailingIcon = {
                IconButton(onClick = { passwordVisibility = !passwordVisibility },
                    modifier = Modifier.padding(4.dp)) {
                    Icon(imageVector = if (passwordVisibility) ImageVector.vectorResource(id = R.drawable.baseline_visibility_24)
                    else ImageVector.vectorResource(id = R.drawable.baseline_visibility_off_24),
                        contentDescription = "Password visibility",
                        tint = Color.Blue
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done
            ),
            visualTransformation = if (passwordVisibility) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            }
        )
        
        Row {
            Checkbox(
                checked = checked.value,
                onCheckedChange = { isChecked -> checked.value = isChecked },
            )
            Text(
                text = "Accept Terms and Conditions",
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                color = Color.Blue,
                modifier = Modifier.padding(15.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
                         val myRegister = AuthViewModel(navController, context)
            myRegister.signup(
                username.text.trim(),
                email.text.trim(),
                password.text.trim(),
                confirmpassword.text.trim()
            )
        },
            modifier = Modifier.width(280.dp),
            colors = ButtonDefaults.buttonColors(Color.Blue),
            shape = CutCornerShape(10)
        ) {
            Text(text = "Register",
                fontSize = 18.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.SemiBold,
                color = Color.White)

        }

        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
                         navController.navigate(ROUTE_LOGIN)
        },
            modifier = Modifier.width(280.dp),
            colors = ButtonDefaults.buttonColors(Color.Blue),
            shape = CutCornerShape(10)
        ) {
            Text(text = "Already have an account? Login",
                fontSize = 14.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.SemiBold,
                color = Color.White)

        }


    }

}

@Preview
@Composable
fun Registerscreenprev() {
    RegisterScreen(rememberNavController())
}