package com.themoonk1d.countertest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.themoonk1d.countertest.screen.CounterLayout
import com.themoonk1d.countertest.ui.theme.CounterTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CounterTestTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CounterLayout(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
