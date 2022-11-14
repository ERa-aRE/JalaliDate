package com.example.jalalidate

import android.widget.TextClock
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun ShowDate(timeCapsule: TimeCapsule, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "${timeCapsule.todayInJalali[0]}/${timeCapsule.todayInJalali[1]}/${timeCapsule.todayInJalali[2]}",
            fontSize = 30.sp,
            modifier = modifier
        )
        Spacer(modifier = Modifier.padding(8.dp))
        Text(
            text = "${timeCapsule.todayIntGregory[2]}/${timeCapsule.todayIntGregory[1]}/${timeCapsule.todayIntGregory[0]}",
            fontSize = 30.sp,
            modifier = modifier
        )
        Spacer(modifier = Modifier.padding(8.dp))
        AndroidView(modifier = Modifier
            .background(
                color = Color.Gray
            ),
            // on the line below we initialize our text clock.
            factory = { context ->
                TextClock(context).apply {
                    // on below line we are setting 12 hour format.
                    format12Hour?.let { this.format12Hour = "hh:mm:ss a " }
                    // on below line we are setting time zone.
                    timeZone?.let { this.timeZone = it }
                    // on below line we are setting text size.
                    textSize.let { this.textSize = 25f }
                }
            })

    }
}