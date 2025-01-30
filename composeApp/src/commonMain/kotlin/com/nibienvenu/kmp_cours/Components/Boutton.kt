package com.nibienvenu.kmp_cours.Components

import androidx.compose.material.Button
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun BouttonFilled(){
    Button(
        onClick = {}
    ) {
        Text("Remplie")
    }
}

@Composable
fun OutlinedButton(onClick : () -> Unit){
    OutlinedButton(onClick = { onClick() }) {
        Text("Décrite")
    }
}

@Composable
fun ElevatedButton(onClick: () -> Unit, function: @Composable () -> Unit){
    ElevatedButton(onClick = { onClick() }) {
        Text("Elevated")
    }
}