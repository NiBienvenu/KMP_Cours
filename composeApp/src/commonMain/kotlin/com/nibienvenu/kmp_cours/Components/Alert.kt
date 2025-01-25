package com.nibienvenu.kmp_cours.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun TopToast(
    message: String,
    icon: ImageVector = Icons.Default.Check,
    backgroundColor: Color = Color.Black.copy(alpha = 0.8f),
    textColor: Color = Color.White,
    duration: Long = 3000L,
    onDismiss: () -> Unit = {}
) {
    var isVisible by remember { mutableStateOf(true) }

    LaunchedEffect(message) {
        delay(duration)
        isVisible = false
        onDismiss()
    }

    if (isVisible) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            Row(
                modifier = Modifier
                    .background(
                        color = backgroundColor,
                        shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp)
                    )
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = "Toast Icon",
                    tint = textColor
                )
                Text(
                    text = message,
                    color = textColor
                )
            }
        }
    }
}

// Example Usage
@Composable
fun AlertExample() {
    var showToast by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {
        Button(
            onClick = { showToast = true }
        ) {
            Text("Show Top Toast")
        }

        if (showToast) {
            TopToast(
                message = "Action Completed Successfully!",
                onDismiss = { showToast = false }
            )
        }
    }
}