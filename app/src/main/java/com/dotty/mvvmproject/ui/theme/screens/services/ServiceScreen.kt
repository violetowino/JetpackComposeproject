package com.dotty.mvvmproject.ui.theme.screens.services

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.dotty.mvvmproject.R

data class ServiceModel(
    val name: String,
    val image: Int,
    val description: String
)

private val serviceList = mutableListOf<ServiceModel>(
    ServiceModel("Outdoor Parking Space", R.drawable.outdoor, "\uD83C\uDF1F Welcome to Neighbors Parking - Where Convenient " +
            "Outdoor Parking Meets Reliability! \uD83C\uDF1F \n" + "\n" + "Uncover the epitome of hassle-free parking with " +
            "our Outdoor Parking Spaces. Nestled strategically in the heart of the City, our outdoor parking facilities" +
            " are your gateway to stress-free parking solutions."),
    ServiceModel("Basement Parking Space", R.drawable.basement, "\uD83D\uDE97 Welcome to Neighbors Parking - Your " +
            "Premier Underground Haven for Hassle-Free Parking! \uD83D\uDE97 \n" + "\n" + "Discover the epitome of convenience " +
            "with our state-of-the-art basement parking facility. Nestled securely beneath popular malls, " +
            "we redefine urban parking, offering a seamless blend of accessibility, security, and modern amenities."),
    ServiceModel("Rooftop Parking Space", R.drawable.rooftop, "☁️ Ascend to Excellence at Neighbors Parking - Elevate Your " +
            "Parking Experience! ☁️\n" + "\n" + "Discover the pinnacle of parking sophistication with our Rooftop Parking Oasis. " +
            "Perched atop prominent Buildings/malls, our rooftop parking facility is more than just a space; it's an " +
            "elevated experience that combines convenience, panoramic views, and security."),
    ServiceModel("Facilities", R.drawable.cars, "These are the facilities in our parking space")
)

@Composable
fun ServicesScreenView(navController:NavHostController, model: ServiceModel) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .background(Color.Gray)
            .border(1.dp, Color.LightGray)
            .padding(5.dp)
    ){
        Spacer(modifier = Modifier.height(15.dp))
        Column {
            Text(
                text = model.name,
                fontSize = 20.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
                color = Color.Blue,
                textAlign = TextAlign.Center,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.padding(15.dp)
            )

            Image(
                painter = painterResource(id = model.image),
                contentDescription = " ",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(4.dp)
            )
            Text(
                text = model.description,
                modifier = Modifier.padding(10.dp),
                fontSize = 12.sp,
                color = Color.Black,
                fontFamily = FontFamily.SansSerif
            )
        }

        }
    }


@Composable
fun ServiceScreen(navController:NavHostController) {
    LazyColumn(
      modifier = Modifier
          .fillMaxSize()
          .background(Color.Gray),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        item {
            Spacer(modifier = Modifier.height(15.dp))
            Text(
            text = "OUR SERVICES",
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
            color = Color.Blue
        )

        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Welcome to our Premier\n car parking booking service,\n " +
                "where convenience meets peace of mind.",
            fontSize = 12.sp,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
        }
        items(serviceList){model ->
            ServicesScreenView(navController = navController, model = model )
        }
    }

}


@Preview
@Composable
fun ServiceScreenPreview() {
    ServiceScreen(rememberNavController())
}