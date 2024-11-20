package com.ibrahimcanerdogan.canvas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.ibrahimcanerdogan.canvas.ui.theme.ComposeCookBookTheme
import com.ibrahimcanerdogan.canvas.ui.theme.purple

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeCookBookTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CanvasDemo(innerPadding)
                }
            }
        }
    }
}

@Composable
fun CanvasDemo(innerPadding: PaddingValues) {
    Column(
        modifier = Modifier.fillMaxSize().padding(innerPadding)
    ) {
        Surface(
            modifier = Modifier.fillMaxSize().weight(.5f)
        ) {
            Box(
                contentAlignment = Alignment.Center, modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape)
            ) {
                MultiStateAnimationCircleFilledCanvas(purple, 400f)
            }
        }
        Surface(
            modifier = Modifier.fillMaxSize().weight(.5f)
        ) {
            Box(
                contentAlignment = Alignment.Center, modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape)
            ) {
                MultiStateAnimationCircleStrokeCanvas()
            }
        }
    }
}
