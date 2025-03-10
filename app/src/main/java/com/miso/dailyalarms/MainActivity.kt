package com.miso.dailyalarms

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.AppTheme
import com.miso.dailyalarms.ui.DailyAlarmsApp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this
        enableEdgeToEdge()

        setContent {
            AppTheme(darkTheme = false) {
                DailyAlarmsApp()
            }
        }

    }
    companion object {
        lateinit var context: MainActivity
            private set
    }
}

@Preview(showBackground = true)
@Composable
fun DailyAlarmsAppPreview() {
    AppTheme(darkTheme = false) {
        DailyAlarmsApp()
    }
}