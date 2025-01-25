package com.nibienvenu.kmp_cours

import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.SnackbarResult
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {

    val snackbarHostState = remember { SnackbarHostState() }


    val channel = remember { Channel<Int>(Channel.CONFLATED) }


    LaunchedEffect(channel) {
        channel.receiveAsFlow().collect { count ->
            val result = snackbarHostState.showSnackbar(
                message = "Snackbar number $count",
                actionLabel = "Action"
            )

            when (result) {
                SnackbarResult.ActionPerformed -> {
                    // Handle action performed
                }
                SnackbarResult.Dismissed -> {
                    // Handle snackbar dismissed
                }
            }
        }
    }

    MaterialTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("KMP Cours") },
                    backgroundColor = Color.Green,
                    contentColor = Color.White
                )
            },
            floatingActionButton = {
                var clickCount by remember { mutableStateOf(0) }
                ExtendedFloatingActionButton(
                    text = { Text("Toast") },
                    onClick = {
                        clickCount++
                        channel.trySend(clickCount)
                    }
                )
            },
            snackbarHost = {
                SnackbarHost(hostState = snackbarHostState)
            },
        ) { innerPadding ->
            // Your main content goes here
            // Use innerPadding to apply padding to content
        }
    }
}