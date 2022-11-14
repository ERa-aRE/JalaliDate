package com.example.jalalidate

import android.os.Bundle
import android.widget.TextClock
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.jalalidate.ui.theme.JalaliDateTheme
import java.time.Clock

class MainActivity : ComponentActivity() {
    //Here we will make an instance of Date Class
    val jalaliDate = Date()
    val timeCapsule = TimeCapsule(jalaliDate.todayInJalali,jalaliDate.todayInGregory)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JalaliDateTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ShowDate(timeCapsule = timeCapsule)

                }
            }
        }
    }
}



