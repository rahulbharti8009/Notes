package com.rahul.notes.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LoginCompose(onClick : (String)-> Unit) {
    Column(modifier = Modifier, Arrangement.Center, Alignment.CenterHorizontally) {
        Text(text = "LoginCompose", modifier = Modifier.clickable {  onClick("rb@gmail.com") }, )
    }
}

@Preview(uiMode = DEFAULT_BUFFER_SIZE , showSystemUi = false)
@Composable
fun PreLoginCompose() {
    LoginCompose(onClick = {})
}