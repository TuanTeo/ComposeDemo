package com.example.composedemo.view.custom

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composedemo.R
import com.example.composedemo.ui.theme.ComposeDemoTheme

class BottomAppBar {

    object BottomItemType {
        const val HOME = "home"
        const val MENU = "menu"
        const val PICTURE = "picture"
        const val FILE = "file"
    }

    companion object {
        @Composable
        fun BottomAppBar() {
            /* Column cha set Arrangement.SpaceBetween, column còn lại set weight = 1 */
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Bottom
            ) {
                Row(
                    modifier = Modifier
                        .height(74.dp)
                        .fillMaxWidth()
                        .background(
                            color = colorResource(id = R.color.white),
                            shape = RoundedCornerShape(14.dp)
                        ),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    BottomItem(BottomItemType.HOME, true)
                    BottomItem(BottomItemType.MENU, false)
                    AddTaskItem()
                    BottomItem(BottomItemType.PICTURE, false)
                    BottomItem(BottomItemType.FILE, false)
                }
            }
        }

        @Composable
        fun AddTaskItem() {
            Image(
                painter = painterResource(id = R.drawable.ic_add_task),
                contentDescription = null,
            )
        }

        @Composable
        fun BottomItem(type: String, isSelected: Boolean) {
            val icon = when(type) {
                BottomItemType.HOME -> if (isSelected) R.drawable.ic_home_selected else R.drawable.ic_home_unselected
                BottomItemType.MENU -> if (isSelected) R.drawable.ic_menu_selected else R.drawable.ic_menu_unselected
                BottomItemType.PICTURE -> if (isSelected) R.drawable.ic_picture_unselected else R.drawable.ic_picture_unselected
                BottomItemType.FILE -> if (isSelected) R.drawable.ic_file_unselected else R.drawable.ic_file_unselected
                else -> R.drawable.ic_home_selected
            }

            Column(
                modifier = Modifier.fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = icon),
                    contentDescription = null,
                )
                if (isSelected) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_selected_dot),
                        contentDescription = null,
                        Modifier.padding(top = 3.dp)
                    )
                }
            }
        }
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
            BottomAppBar.BottomAppBar()
        }
    }
}


