package com.dotty.mvvmproject.ui.theme.screens.customlistview

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.dotty.mvvmproject.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

data class PersonModel(val name: String, val image: Int, val description: String)

private val personsList = mutableListOf<PersonModel>(
    PersonModel("Celine", R.drawable.profile, "Hi there"),
    PersonModel("Cate", R.drawable.profile2, "Welcome to my Channel"),
    PersonModel("Rita", R.drawable.profile3, "Watch my shows"),
    PersonModel("Peter", R.drawable.profile4, "Subscribe to my channel"),
    PersonModel("Ken", R.drawable.profile5, "Support my video app")
)

@Composable
fun CustomListView(navController: NavHostController, model: PersonModel) {
    var isDescriptionVisible by remember { mutableStateOf(false) }
    val context = LocalContext.current
    
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .background(Color.Gray)
                .border(1.dp, Color.LightGray)
                .padding(5.dp)
                .clickable {
                    isDescriptionVisible = !isDescriptionVisible
                }
        )
        {
            Image(
                painter = painterResource(id = model.image),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)

            )

            Column {
                Text(
                    text = model.name,
                    modifier = Modifier.padding(5.dp),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily.Serif,
                    color = Color.Blue
                )
                if (isDescriptionVisible) {
                    Text(
                        text = model.description,
                        modifier = Modifier.padding(6.dp),
                        fontSize = 12.sp,
                        color = Color.Black
                    )
                }
            }
        }

    }


    @Composable
    fun CustomListScreen(navController: NavHostController) {
        Spacer(modifier = Modifier.height(15.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Gray),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item {
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = "LIST VIEW",
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
//                    modifier = Modifier.fillMaxWidth().padding(5.dp),
                    textAlign = TextAlign.Center
                )
            }
            items(personsList) { model ->
                CustomListView(navController = navController, model = model)

            }
        }
    }

@Composable
private fun CarouselSlider(carouselImages: List<Painter>) {
    var index by remember { mutableStateOf(0) }
    val scrollState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(key1 = true, block = {
        coroutineScope.launch {
            while (true){
                delay(1000)
                if (index == carouselImages.size - 1) index = 0
                else index++
                scrollState.animateScrollToItem(index)
            }
        }
    })

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Box(
            modifier = Modifier.padding(16.dp)
        ) {
            LazyRow(
                state =scrollState,
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ){
                itemsIndexed(carouselImages){ index, painter ->
                    Card(
                        modifier = Modifier.height(500.dp),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 8.dp
                        )
                    ) {
                        AsyncImage(
                            model = painter,
                            contentDescription = "image",
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier.width(300.dp))
                    }
                }
            }
        }
    }
    //bookspace


    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.Center
    ){
        Button(
            onClick = {
//                val simToolKitLaunchIntent =
//                    context.packageManager.getLaunchIntentForPackage("com.android.stk")
//
//                simToolKitLaunchIntent?.let { context.startActivity(it) }
            },
            modifier = Modifier
                .width(240.dp)
                .padding(16.dp),
            colors = ButtonDefaults.buttonColors(Color.Blue),
            shape = CutCornerShape(10)
        ) {
            Text(
                text = "Pay with MPESA",
                fontSize = 14.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
        }


        Spacer(modifier = Modifier.width(15.dp))
        Button(onClick = {}
        )
        {
            Text(
                text = "Proceed",
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
fun CustomListViewPreview() {
    CustomListScreen(rememberNavController())
}


