package com.example.composedemo.view.custom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composedemo.R
import com.example.composedemo.ui.theme.ComposeDemoTheme

class SearchBar {

    companion object {
        @OptIn(ExperimentalMaterial3Api::class)
        @Composable
        fun SearchBar() {
            Row() {
                var textInput by remember { mutableStateOf("") }
                TextField(
                    value = textInput,
                    onValueChange = { textInput = it },
                    label = {
                        Text(text = "Search for task", color = colorResource(id = R.color.gray))
                    },
                    leadingIcon = {
                        Icon(
                            painterResource(R.drawable.ic_search),
                            contentDescription = null
                        )
                    },
                    trailingIcon = {
                        Icon(
                            painterResource(R.drawable.ic_close_search),
                            contentDescription = null
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = colorResource(id = R.color.bg_search_color),
                            shape = RoundedCornerShape(14.dp)
                        ),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = colorResource(id = android.R.color.transparent),
                        unfocusedIndicatorColor = colorResource(id = android.R.color.transparent)
                    ),
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {
    ComposeDemoTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            SearchBar.SearchBar()
        }
    }
}


