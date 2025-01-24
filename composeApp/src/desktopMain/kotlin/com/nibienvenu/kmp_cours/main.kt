package com.nibienvenu.kmp_cours

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "KMPCours",
    ) {
        App()
    }
}