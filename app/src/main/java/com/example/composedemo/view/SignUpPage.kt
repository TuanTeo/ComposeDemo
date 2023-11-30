package com.example.composedemo.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composedemo.LoginButton
import com.example.composedemo.R
import com.example.composedemo.ui.theme.ComposeDemoTheme

/**
 * Created by tuan.tran3 on 11/30/2023.
 */
class SignUpPage {
    companion object {

        @Composable
        fun SignUpPage() {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(35.dp, 0.dp, 0.dp, 0.dp),
                    horizontalArrangement = Arrangement.Start,
                ) {
                    Text(
                        text = "Sign Up",
                        fontSize = 36.sp,
                        color = colorResource(R.color.mainColor),
                        style = TextStyle(fontWeight = FontWeight(600))
                    )
                }

                Column {
                    TextFieldExample("Username", R.drawable.message)
                    TextFieldExample("Email ID", R.drawable.lock)
                    TextFieldExample("Password", R.drawable.lock)
                }

                LoginButton("Create")

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painterResource(R.drawable.img_or_with),
                        "content description",
                        modifier = Modifier.padding(30.dp)
                    )

                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Image(
                            painterResource(R.drawable.img_google),
                            "content description",
                            modifier = Modifier.padding(8.dp)
                        )
                        Image(
                            painterResource(R.drawable.img_facebook),
                            "content description",
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(id = R.string.have_any_account),
                        color = colorResource(id = R.color.mainColor),
                        fontSize = 12.sp,
                        fontWeight = FontWeight(weight = 400),
                    )
                    Text(
                        text = stringResource(id = R.string.sign_in),
                        color = colorResource(id = R.color.mainColor),
                        fontSize = 14.sp,
                        fontWeight = FontWeight(weight = 600),
                        modifier = Modifier.padding(4.dp, 0.dp, 0.dp, 0.dp)
                    )
                }
            }
        }

        @OptIn(ExperimentalMaterial3Api::class)
        @Composable
        fun TextFieldExample(label: String, leadingIcon: Int, trailingIcon: Int? = null) {
            var textInput by remember { mutableStateOf("") }
            TextField(
                value = textInput,
                onValueChange = { textInput = it},
                label = {
                    Text(text = label, color = colorResource(id = R.color.gray)) },
                leadingIcon = { Icon(painterResource(leadingIcon), contentDescription = null) },
                trailingIcon = { if (trailingIcon != null) Icon(painterResource(trailingIcon), contentDescription = null) else null },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(PaddingValues(35.dp, 0.dp, 35.dp, 10.dp)),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = colorResource(id = android.R.color.transparent),
                    unfocusedIndicatorColor = colorResource(id = R.color.gray)
                ),
            )
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    ComposeDemoTheme {
//        Surface(
//            modifier = Modifier.fillMaxSize(),
//            color = MaterialTheme.colorScheme.background
//        ) {
//            SignUpPage.SignUpPage()
//        }
//    }
//}