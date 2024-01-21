package com.dotty.mvvmproject.ui.theme.screens.home

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddHome
import androidx.compose.material.icons.filled.BookOnline
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.ContactPage
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
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
import com.dotty.mvvmproject.navigation.ROUTE_ABOUT
import com.dotty.mvvmproject.navigation.ROUTE_BOOKSPACE
import com.dotty.mvvmproject.navigation.ROUTE_CONTACTUS
import com.dotty.mvvmproject.navigation.ROUTE_LOGIN
import com.dotty.mvvmproject.navigation.ROUTE_REGISTER
import com.dotty.mvvmproject.navigation.ROUTE_SERVICES
import kotlinx.coroutines.launch


data class DrawerItems(
    val icon: ImageVector,
    val text: String,
    val hasBadge: Boolean,
    val badgeCount: Int,
    val route: String,
)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController:NavHostController) {

    val notification = rememberSaveable { mutableStateOf("") }
    if (notification.value.isNotEmpty()){
        Toast.makeText(LocalContext.current, notification.value, Toast.LENGTH_LONG).show()
        notification.value = ""}

    val drawerItem = listOf(
        DrawerItems(Icons.Default.AddHome, "About", true, 5, ROUTE_ABOUT),
        DrawerItems(Icons.Default.Category, "Our Services", true, 12, ROUTE_SERVICES),
        DrawerItems(Icons.Default.ContactPage, "Contact Us", false, 0, ROUTE_CONTACTUS),
        DrawerItems(Icons.Default.BookOnline, "Book Space", false, 0, ROUTE_BOOKSPACE),
    )


    val carouselImages = listOf(
        painterResource(id = R.drawable.outdoor),
        painterResource(id = R.drawable.rooftop),
        painterResource(id = R.drawable.basement),
        painterResource(id = R.drawable.cars)
    )


    var selectedItem by remember { mutableStateOf(drawerItem[0]) }
    var drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    var scope = rememberCoroutineScope()


    ModalNavigationDrawer(drawerContent = {
        ModalDrawerSheet {
            Column(
                Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
               Box (
                   modifier = Modifier
                       .fillMaxWidth()
                       .height(200.dp)
                       .background(Color.Gray),
                   contentAlignment = Alignment.Center
               ){
                   Column(
                       Modifier.wrapContentSize(),
                       verticalArrangement = Arrangement.SpaceAround,
                       horizontalAlignment = Alignment.CenterHorizontally
                   ) {
                     Image(
                         painter = painterResource(id = R.drawable.kiwi),
                         contentDescription = "Site Picture",
                         modifier = Modifier
                             .size(130.dp)
                             .clip(CircleShape)
                     )
                     Text(
                         text = "Welcome",
                         Modifier
                             .fillMaxWidth()
                             .padding(top = 16.dp),
                         fontSize = 25.sp,
                         fontFamily = FontFamily.Serif,
                         fontWeight = FontWeight.SemiBold,
                         textAlign = TextAlign.Center
                     )
                   }
                   Divider(
                       Modifier.align(Alignment.BottomCenter),
                       thickness = 2.dp,
                       Color.Black
                   )
               }
                drawerItem.forEach{
                    NavigationDrawerItem(
                        label = { Text(text = it.text) },
                        selected = it == selectedItem,
                        onClick = {
                            selectedItem = it
                            scope.launch {
                                drawerState.close()
                            }
                            navController.navigate(it.route)

                        },
                        modifier = Modifier.padding(horizontal = 20.dp),
                        icon = {
                            Icon(
                                imageVector = it.icon,
                                contentDescription = it.text
                            )
                        },
                        badge = {
                            if (it.hasBadge){
                                BadgedBox(
                                    badge = {
                                        Badge {
                                            Text(
                                                text = it.badgeCount.toString(),
                                                fontSize = 18.sp
                                            )
                                        }
                                    }) {

                                }
                            }
                        }
                    )
                }
            }
        }
    }, drawerState = drawerState
    ) {
        Scaffold (
            topBar = {
                TopAppBar(title = { Text(text = "")},
                    Modifier.background(Color.Gray),
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                scope.launch {
                                    drawerState.open()
                                }
                            }) {
                                Icon(
                                    imageVector = Icons.Filled.Menu,
                                    contentDescription = "menu icon")
                        }
                    })
            }
        ) {paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Gray)
                ) {
                    Spacer(modifier = Modifier.height(50.dp))
                    Text(text = "WELCOME TO OUR SITE PAGE",
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
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        horizontalArrangement = Arrangement.End

                    ) {
                        Text(
                            text = "Register",
                            color = Color.Black,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = FontFamily.Serif,
                            fontSize = 14.sp,
                            textDecoration = TextDecoration.Underline,
                            modifier = Modifier.clickable {
                                navController.navigate(ROUTE_REGISTER)
                            }
                        )

                        Spacer(modifier = Modifier.width(12.dp))

                        Text(
                            text = "Login",
                            color = Color.Black,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Serif,
                            textDecoration = TextDecoration.Underline,
                            modifier = Modifier.clickable {
                                navController.navigate(ROUTE_LOGIN)
                            }
                        )
                    }

                        Spacer(modifier = Modifier.height(20.dp))

                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color.Gray),
                            contentAlignment = Alignment.TopCenter
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.cars),
                                contentDescription = "Image",
                                modifier = Modifier
                                    .width(650.dp)
                                    .height(250.dp)
                                    .clip(RoundedCornerShape(corner = CornerSize(12.dp)))
                            )

                        }
                    Text(
                        text = "QUICK LINKS",
                        color = Color.Magenta,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Cursive,
                        textDecoration = TextDecoration.Underline
                    )

                }
            }

        }
    }

}



@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(rememberNavController())

}