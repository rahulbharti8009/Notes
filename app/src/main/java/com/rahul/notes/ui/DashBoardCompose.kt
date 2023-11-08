package com.rahul.notes.ui

import android.content.res.Resources
import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rahul.notes.R

@Composable
fun DashBoardCompose(email : String) {
    val items = listOf( 1,2,3,4,5,6,7)
    LazyColumn {
        items(10) { item ->
            itemsCards(item.toString())
            Divider(color = Color.Black, thickness = 0.5.dp)
        }
    }
}

@Composable
fun itemsCards(email: String) {
    Card(
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(0.5.dp, Color.Gray),
        modifier = Modifier
            .clip(CircleShape)
            .padding(16.dp)
            .fillMaxWidth(), colors = CardDefaults.cardColors(
            containerColor = Color.White,
        )
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(16.dp)) {
//                Image(painter = painterResource(id = R.drawable.ic_launcher_foreground),
//                    contentDescription = "", modifier = Modifier
//                        .size(100.dp)
//                        .background(Color.Black)
//                        .weight(.2f))
            Box(
                contentAlignment = Alignment.Center, modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(Color.Gray)
            ) {
                Text(text = "${email.substring(0, 1).uppercase()}", fontSize = 20.sp)
            }
            Spacer(modifier = Modifier.width(10.dp))
            Column(Modifier.weight(.8f)) {
                Text(text = "Title $email", style = MaterialTheme.typography.titleSmall)
                Text(text = "text")
            }
        }
    }
}

@Preview(showSystemUi = false)
@Composable
fun DashBoardComposePreview() {
    DashBoardCompose("rb@gmail.com")
}