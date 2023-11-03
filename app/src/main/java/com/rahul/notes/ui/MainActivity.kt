package com.rahul.notes.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.rahul.notes.ui.theme.NotesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppController()
                }
            }
        }
    }

//  navHost
//  navGraph
//  navController
    @Composable
    private fun AppController() {
        val navController = rememberNavController()
        val context = LocalContext.current
        val isLogin = if(false) "DashBoard" else "Login"

        NavHost(navController = navController, startDestination = isLogin) {
            composable("Login") {
                Login {
                    navController.navigate("DashBoard/$it")
                }
            }
            composable("Registration") {
                Registration()
            }
            composable("DashBoard/{email}", arguments = listOf(navArgument("email") { type = NavType.StringType })) {
             val email =    it.arguments?.getString("email")
//                Toast.makeText(LocalContext.current, "", Toast.LENGTH_LONG).show()
                EnterAnimation {
                    DashBoard(email!!)
                }
            }
        }
    }

    @Composable
    private fun Login(onClick : (String)-> Unit) {
     Column {
         Text(text = "Login", modifier = Modifier.clickable {  onClick("rb@gmail.com") })
     }
    }


    @Composable
    private fun Registration() {
        Column {
            Text(text = "Registration")
        }
    }

    @Composable
    private fun DashBoard(email : String) {
        Column {
            Text(text = "DashBoard $email")
        }
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    NotesTheme {
//        Greeting("Android")
//    }
//}

@Composable
fun EnterAnimation(content: @Composable () -> Unit) {
    AnimatedVisibility(
        visibleState = MutableTransitionState(
            initialState = false
        ).apply { targetState = true },
        modifier = Modifier,
        enter = slideInVertically(
            initialOffsetY = { -40 }
        ) + expandVertically(
            expandFrom = Alignment.Top
        ) + fadeIn(initialAlpha = 0.3f),
        exit = slideOutVertically() + shrinkVertically() + fadeOut(),
    ) {
        content()
    }
}