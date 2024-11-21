package com.ibrahimcanerdogan.fab

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ibrahimcanerdogan.fab.component.AnimatingFabContent
import com.ibrahimcanerdogan.fab.ui.theme.ComposeCookBookTheme

class FloatingActionButtonActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeCookBookTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FabDemo(innerPadding)
                }
            }
        }
    }
}

@Composable
fun FabDemo(innerPadding: PaddingValues) {
    val expandState = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize().padding(innerPadding),
        contentAlignment = Alignment.Center
    ) {
        FloatingActionButton(
            onClick = {
                expandState.value = !expandState.value
            },
            modifier = Modifier
                .padding(16.dp)
                .height(48.dp)
                .widthIn(min = 48.dp),
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.primary
        ) {
            AnimatingFabContent(
                icon = {
                    Icon(
                        imageVector = Icons.Outlined.Edit,
                        contentDescription = stringResource(id = R.string.cd_create_new_email)
                    )
                },
                text = {
                    Text(
                        text = "Compose",
                        modifier = Modifier.padding(end = 8.dp)
                    )
                },
                extended = expandState.value

            )
        }
    }
}
