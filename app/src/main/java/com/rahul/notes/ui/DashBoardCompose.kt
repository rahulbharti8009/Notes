@file:OptIn(ExperimentalMaterial3Api::class)

package com.rahul.notes.ui

import android.annotation.SuppressLint
import android.content.res.Resources
import android.util.Log
import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.rahul.notes.R
import kotlinx.coroutines.launch

@Composable
fun DashBoardUI(navController : NavHostController, title : String) {
    Box {
        Column {
//            MyAppTopBar(title = "HOME")
            val myList = listOf( 1,2,3,4,5,6,7,8,9,10,11,12)
            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Fixed(1),
                contentPadding = PaddingValues(10.dp),
                horizontalArrangement = Arrangement.spacedBy(1.dp),
            ) {
                items(myList.size) { item ->
                    itemsCards(item.toString())
//               Divider(color = Color.Black, thickness = 0.5.dp)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppTopBar(title: String) {
    TopAppBar(
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
            Text(text = title, style = MaterialTheme.typography.titleSmall, fontSize = 18.sp)
        },
        modifier = Modifier.fillMaxWidth(),


    )
}

@Composable
fun itemsCards(email: String) {
    Card(
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(0.5.dp, Color.Gray),
        modifier = Modifier
            .padding(2.dp)
            .fillMaxWidth()
            , colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFFFFF),
        )
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(6.dp)) {
            Box(
                contentAlignment = Alignment.Center, modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(Color.Gray)
            ) {
                Text(text = email.substring(0, 1).uppercase(), fontSize = 20.sp)
            }
            Spacer(modifier = Modifier.width(10.dp))
            Column(Modifier.weight(.8f)) {
                Text(text = "Title $email", style = MaterialTheme.typography.titleSmall)
                Text(text = "text")
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun DashBoardComposePreview() {
    Column {
        DashBoardUI(navController = rememberNavController(), "rb@gmail.com")
    }
}

