package com.ibrahimcanerdogan.charts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ibrahimcanerdogan.charts.component.Charts
import com.ibrahimcanerdogan.charts.ui.theme.ComposeCookBookTheme

class ChartsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeCookBookTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ChartDemo(innerPadding)
                }
            }
        }
    }
}

@Composable
fun ChartDemo(innerPadding: PaddingValues) {
    Box(
        modifier = Modifier.fillMaxSize().padding(innerPadding),
        contentAlignment = Alignment.Center
    ) {
        Charts()
    }
}