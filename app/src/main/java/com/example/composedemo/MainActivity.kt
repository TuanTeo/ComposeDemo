package com.example.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composedemo.ui.theme.ComposeDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Login()
                }
            }
        }
    }
}

@Composable
fun Login() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painterResource(R.drawable.img_splash),
            "content description",
            Modifier
                .width(width = 294.dp)
                .height(291.dp),
        )

        IntroductionApplication()

        SplashButton()
    }
}

@Composable
fun IntroductionApplication() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painterResource(R.drawable.img_logo),
            "content description"
        )

        Text(text = "Plan what you will do to be more organized for today, tomorrow and beyond",
            fontSize = 14.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun SplashButton() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LoginButton()

        TextButton(onClick = { },
            Modifier
                .height(52.dp)
                .width(304.dp)) {
            Text(text = "Sign up")
        }
    }
}

@Composable
fun LoginButton() {
    Button(onClick = {  },
        Modifier
            .height(52.dp)
            .width(304.dp),
    ) {
        Text(text = "Login")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeDemoTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Login()
        }
    }
}