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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composedemo.ui.theme.ComposeDemoTheme
import com.example.composedemo.utils.Const
import com.example.composedemo.view.HomePage
import com.example.composedemo.view.LoginPage
import com.example.composedemo.view.SignUpPage

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
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Const.Screen.SPLASH) {
                        composable(Const.Screen.SPLASH) { Splash(navController) }
                        composable(Const.Screen.LOGIN) { LoginPage.LoginPage(navController) }
                        composable(Const.Screen.SIGNUP) { SignUpPage.SignUpPage(navController) }
                        composable(Const.Screen.HOME) { HomePage.HomePage() }
                    }
                }
            }
        }
    }
}

@Composable
fun Splash(navController: NavController) {
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

        SplashButton(navController)
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
fun SplashButton(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LoginButton("Login") { navController.navigate(Const.Screen.LOGIN) }

        TextButton(onClick = { navController.navigate(Const.Screen.SIGNUP) },
            Modifier
                .height(52.dp)
                .width(304.dp)) {
            Text(text = "Sign up", fontSize = 16.sp, color = colorResource(R.color.mainColor))
        }
    }
}

@Composable
fun LoginButton(label: String, onClick: () -> Unit) {
    Button(onClick = onClick,
        Modifier
            .height(52.dp)
            .width(304.dp),
        colors = ButtonDefaults.buttonColors(colorResource(R.color.mainColor)),
        shape = RoundedCornerShape(14.dp)
    ) {
        Text(text = label, fontSize = 16.sp)
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
//            Login()
//            LoginPage.LoginPage()
        }
    }
}