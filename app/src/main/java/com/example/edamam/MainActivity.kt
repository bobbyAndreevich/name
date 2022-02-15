package com.example.edamam

import android.os.Bundle
import android.util.Log
import android.widget.Toolbar
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.edamam.ui.theme.EdamamTheme

@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EdamamTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("state", "onStart")
    }
}

@ExperimentalAnimationApi
@Composable
fun Greeting(name: String) {
    Card {
        var expanded by remember {mutableStateOf(false)}
        Column(Modifier.clickable { expanded = !expanded }) {
            Image(painterResource(R.drawable.ic_launcher_foreground), "")
            AnimatedVisibility(visible = expanded) {
                Text(text = "JetPack Compose")
            }

        }
    }
}

@ExperimentalAnimationApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EdamamTheme {
        Greeting("Android")
    }
}