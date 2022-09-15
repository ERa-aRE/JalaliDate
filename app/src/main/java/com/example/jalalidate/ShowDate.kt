package com.example.jalalidate

import android.widget.TextClock
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun ShowDate(timeCapsule: IntArray, modifier: Modifier = Modifier) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "${timeCapsule[0]}/${timeCapsule[1]}/${timeCapsule[2]}", fontSize = 30.sp, modifier = modifier)
        AndroidView(modifier = Modifier
            .background(color = Color.Gray
            ),
            // on below line we are initializing our text clock.
            factory = { context ->
                TextClock(context).apply {
                    // on below line we are setting 12 hour format.
                    format24Hour?.let { this.format24Hour = "hh:mm:ss a " }
                    // on below line we are setting time zone.
                    timeZone?.let { this.timeZone = it }
                    // on below line we are setting text size.
                    textSize.let { this.textSize = 30f }
                }
            })
    }
}