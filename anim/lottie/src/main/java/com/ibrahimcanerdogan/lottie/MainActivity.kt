package com.ibrahimcanerdogan.lottie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.ibrahimcanerdogan.lottie.component.LottieCryptoLoadingView
import com.ibrahimcanerdogan.lottie.component.LottieFoodView
import com.ibrahimcanerdogan.lottie.component.LottieLoaderLoadingView
import com.ibrahimcanerdogan.lottie.component.LottieWorkingLoadingView
import com.ibrahimcanerdogan.lottie.ui.theme.ComposeCookBookTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeCookBookTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LottieDemo(innerPadding)
                }
            }
        }
    }
}

@Composable
fun LottieDemo(innerPadding: PaddingValues) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(0.25f),
            contentAlignment = Alignment.Center
        ) {
            LottieCryptoLoadingView(context)
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(0.25f),
            contentAlignment = Alignment.Center
        ) {
            LottieFoodView(context)
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(0.25f),
            contentAlignment = Alignment.Center
        ) {
            LottieLoaderLoadingView(context)
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(0.25f),
            contentAlignment = Alignment.Center
        ) {
            LottieWorkingLoadingView(context)
        }
    }
}