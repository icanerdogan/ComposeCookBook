package com.ibrahimcanerdogan.lottie.component

import android.content.Context
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ibrahimcanerdogan.lottie.LottieLoadingView

@Composable
fun LottieCryptoLoadingView(context: Context) {
    LottieLoadingView(
        context = context,
        file = "cryptoload.json",
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
    )
}
