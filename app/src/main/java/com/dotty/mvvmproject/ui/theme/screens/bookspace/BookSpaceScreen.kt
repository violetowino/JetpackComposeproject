package com.dotty.mvvmproject.ui.theme.screens.bookspace

import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.dotty.mvvmproject.navigation.ROUTE_CONFIRM
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.datetime.time.timepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

data class ParkingSpace(
    val id: Int,
    var isBooked: Boolean = false
)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookSpaceScreen(navController:NavHostController) {
    val context = LocalContext.current
    var selectedTime by remember { mutableStateOf("") }
    var selectedDate by remember { mutableStateOf("") }
    var selectedSpaceIndex by remember { mutableStateOf<Int?>(null) }

    var date by remember { mutableStateOf(TextFieldValue()) }
    var time by remember { mutableStateOf(TextFieldValue()) }


    var totalCost by remember { mutableStateOf(0) }
    var pickedDate by remember { mutableStateOf(LocalDate.now()) }
    var pickedTime by remember { mutableStateOf(LocalTime.now()) }
    val formattedDate by remember { derivedStateOf {
        DateTimeFormatter
            .ofPattern("MMM dd yyyy")
            .format(pickedDate)
        }
    }

    val formattedTime by remember { derivedStateOf {
        DateTimeFormatter
            .ofPattern("hh:mm")
            .format(pickedTime)
        }
    }

    val dateDialogState = rememberMaterialDialogState()
    val timeDialogState = rememberMaterialDialogState()


    Box {

    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = "SELECT A SPACE",
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

        if (selectedSpaceIndex != null) {
            val spaceCost = 150 // Cost per space
            totalCost = spaceCost
            Text(
                text = "You selected space $selectedSpaceIndex, amount Ksh.$totalCost",
                fontSize = 16.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
            )
        }


        Row {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Select date",
                    fontSize = 16.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Red
                )


                OutlinedButton(
                    onClick = {
                        dateDialogState.show()
                    },
                    contentPadding = PaddingValues(8.dp),
                    modifier = Modifier
                        .width(120.dp)
                        .padding(4.dp), // Add padding to adjust the appearance
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color.Blue,
//                        backgroundColor = Color.Transparent, // Set background color to transparent
                    ),
                    shape = CutCornerShape(10)
                    ) {

                    Text(
                        text = if (formattedDate.isBlank()) "Select Date" else formattedDate,
                        fontSize = 14.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(8.dp)
                    )
                }

            }

            Spacer(modifier = Modifier.width(10.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Time-in",
                    fontSize = 16.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Red
                )


                OutlinedButton(
                    onClick = {
                        timeDialogState.show()
                    },
                    contentPadding = PaddingValues(8.dp),
                    modifier = Modifier
                        .width(120.dp)
                        .padding(4.dp), // Add padding to adjust the appearance
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color.Blue,
                    ),
                    shape = CutCornerShape(10)
                ) {
                    Text(
                        text = if (formattedTime.isBlank()) "Time-in" else formattedTime,
                        fontSize = 14.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(8.dp)
                    )
                }

            }

            Spacer(modifier = Modifier.width(10.dp))
            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    text = "Time-out",
                    fontSize = 16.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Red
                )


                OutlinedButton(
                    onClick = {
                        timeDialogState.show()
                    },
                    contentPadding = PaddingValues(8.dp),
                    modifier = Modifier
                        .width(120.dp)
                        .padding(4.dp), // Add padding to adjust the appearance
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color.Blue,
//                        backgroundColor = Color.Transparent, // Set background color to transparent
                    ),
                    shape = CutCornerShape(10)
                ) {
                    Text(
                        text = if (formattedTime.isBlank()) "Time-out" else formattedTime,
                        fontSize = 14.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(8.dp)
                    )
                }
            }


        }


        Spacer(modifier = Modifier.height(30.dp))
        Divider(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            thickness = 2.dp,
            Color.Black
        )

        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ){
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .padding(16.dp)
            ) {
                val parkingSpaces = generateParkingSpaces()
                itemsIndexed(items = parkingSpaces.chunked(4)) { _, rowSpaces ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        rowSpaces.forEach { parkingSpace ->
                            ParkingSpaceItem(
                                parkingSpace = parkingSpace,
                                selectedSpaceIndex = selectedSpaceIndex,
                                onSpaceClick = {
                                    selectedSpaceIndex = it.id

                                }
                            )
                        }

                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedButton(
                onClick = {
                    if (selectedSpaceIndex != null) {
                        // Navigate to the confirmation page with the selected details
                        navController.navigate("$ROUTE_CONFIRM/" +
                                "?selectedDate=$selectedDate" +
                                "&selectedTimeIn=$formattedTime" +
                                "&selectedTimeOut=$formattedTime" +
                                "&selectedSpaceIndex=$selectedSpaceIndex"
                        )
                    }
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
                    text = "Submit",
                    fontSize = 18.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(8.dp)
                )
            }
        }

    }


    MaterialDialog (
        dialogState = dateDialogState,
        buttons = {
            positiveButton(text = "Ok"){}
            negativeButton(text = "Cancel")
        }
    ){
       datepicker(
           initialDate = LocalDate.now(),
           title = "Pick a date",
       ){
           pickedDate = it
           selectedDate = DateTimeFormatter.ofPattern("MMM dd yyyy").format(it)
       }
    }

    MaterialDialog (
        dialogState = timeDialogState,
        buttons = {
            positiveButton(text = "Ok"){}
            negativeButton(text = "Cancel")
        }
    ){
        timepicker(
            initialTime = LocalTime.now(),
            title = "Pick time",
            timeRange = LocalTime.MIDNIGHT..LocalTime.NOON
        ){
            pickedTime = it
        }
    }

}

@Composable
fun ParkingSpaceItem(
    parkingSpace: ParkingSpace,
    selectedSpaceIndex: Int?,
    onSpaceClick: (ParkingSpace) -> Unit
) {
    Box(
        modifier = Modifier
            .size(55.dp)
            .clip(RoundedCornerShape(15))
            .background(
                when {
                    parkingSpace.isBooked -> Color.Red
                    parkingSpace.id == selectedSpaceIndex -> Color.Red
                    else -> Color.Blue
                }
            )
            .clickable {
                onSpaceClick(parkingSpace)
            }
    ) {
        Text(
            text = parkingSpace.id.toString(),
            modifier = Modifier
                .align(Alignment.Center)
                .padding(8.dp),
            color = Color.White
        )
    }
}


fun generateParkingSpaces(): List<ParkingSpace> {
    return List(20) { index ->
        ParkingSpace(id = index + 1)
    }
}


@Preview
@Composable
fun BookSpaceScreenPreview() {
    BookSpaceScreen(rememberNavController())
}

