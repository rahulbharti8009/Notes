package com.rahul.notes.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun LoginCompose(onClick : (String)-> Unit) {
    Column {
        Text(text = "LoginCompose", modifier = Modifier.clickable {  onClick("rb@gmail.com") })
    }
}