package com.example.composedemo.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composedemo.R
import com.example.composedemo.ui.theme.ComposeDemoTheme
import com.example.composedemo.utils.Const
import com.example.composedemo.view.custom.BottomAppBar

/**
 * Created by tuan.tran3 on 11/30/2023.
 */
class HomePage {

    companion object {
        @Composable
        fun HomePage() {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .padding(24.dp, 0.dp, 24.dp, 0.dp)
            ) {
                Column(
                    modifier = Modifier.weight(1f).verticalScroll(rememberScrollState())
                ) {
                    Box(Modifier.height(45.dp))
                    Header()
                    Box(Modifier.height(32.dp))
                    MyTask()
                    Box(Modifier.height(32.dp))
                    TodayTask()
                }
                Column {
                    BottomAppBar.BottomAppBar()
                }
            }
        }

        @Composable
        fun TodayTask() {
            TodayTaskTitle()
            TaskItem(Const.TaskState.ITEM_COMPLETED)
            TaskItem(Const.TaskState.ITEM_PENDING)
            TaskItem(Const.TaskState.ITEM_CANCEL)
            TaskItem(Const.TaskState.ITEM_ON_GOING)
        }

        @Composable
        fun TodayTaskTitle() {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 0.dp, 0.dp, 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TagText("Today Task")

                Text(text = "View all",
                    fontSize = 12.sp,
                    color = colorResource(id = R.color.mainColor))
            }
        }

        @Composable
        fun TaskItem(state: Int) {
            val mainColor = when(state) {
                Const.TaskState.ITEM_COMPLETED -> R.color.task_state_item_text_completed
                Const.TaskState.ITEM_PENDING -> R.color.mainColor
                Const.TaskState.ITEM_CANCEL -> R.color.task_state_item_text_cancel
                Const.TaskState.ITEM_ON_GOING -> R.color.task_state_item_text_on_going
                else -> R.color.mainColor
            }

            val backgroundColor = when(state) {
                Const.TaskState.ITEM_COMPLETED -> R.color.task_state_item_background_completed
                Const.TaskState.ITEM_PENDING -> R.color.task_state_item_background
                Const.TaskState.ITEM_CANCEL -> R.color.task_state_item_background_cancel
                Const.TaskState.ITEM_ON_GOING -> R.color.task_state_item_background_on_going
                else -> R.color.task_state_item_background
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 0.dp, 0.dp, 10.dp)
                    .background(
                        color = colorResource(id = R.color.task_item_background),
                        shape = RoundedCornerShape(15.dp)
                    )
                    .padding(0.dp, 15.dp, 0.dp, 15.dp),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 0.dp, 0.dp, 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row {
                        Box(
                            modifier = Modifier
                                .height(45.dp)
                                .width(28.dp)
                                .padding(16.dp, 0.dp, 10.dp, 0.dp)
                                .background(color = colorResource(id = mainColor))
                        )

                        Column {
                            Text(
                                text = "Cleaning Clothes",
                                fontSize = 16.sp,
                                color = colorResource(R.color.title_color),
                                style = TextStyle(fontWeight = FontWeight(600)),
                                modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 4.dp)
                            )

                            Text(text = "07:00 - 07:15",
                                fontSize = 14.sp,
                                color = colorResource(id = R.color.task_time))
                        }
                    }

                    Image(
                        painter = painterResource(id = R.drawable.ic_menu),
                        contentDescription = null,
                        modifier = Modifier.padding(0.dp, 0.dp, 16.dp, 0.dp)
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(28.dp, 0.dp)
                ) {
                    TaskItemState("Urgent", mainColor, backgroundColor)
                    TaskItemState("Home", mainColor, backgroundColor)
                }
            }
        }

        @Composable
        fun TaskItemState(label: String, mainColor: Int, backgroundColor: Int) {
            Box(
                modifier = Modifier
                    .padding(0.dp, 0.dp, 8.dp, 0.dp)
                    .background(
                        color = colorResource(id = backgroundColor),
                        shape = RoundedCornerShape(3.dp)
                    )
                    .padding(7.dp, 2.dp, 7.dp, 2.dp)

            ) {
                Text(
                    text = label,
                    fontSize = 10.sp,
                    color = colorResource(id = mainColor),
                    fontWeight = FontWeight(600)
                )
            }
        }

        @Composable
        fun MyTask() {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TagText("My Task", modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 16.dp))
            }

            Row(modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Box(modifier = Modifier
                        .weight(5.5f)
                        .fillMaxWidth()
                        .padding(0.dp, 0.dp, 8.dp, 8.dp)
                        .paint(painterResource(id = R.drawable.bg_task_1))
                        .padding(14.dp, 0.dp)
                    ) {
                        Column(modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.SpaceEvenly
                        ) {
                            TaskHeader(R.drawable.img_imac, true)
                            TaskTitle("Completed", true)
                            TaskInfo("86 Task", true)
                        }
                    }
                    Box(modifier = Modifier
                        .weight(4.5f)
                        .fillMaxWidth()
                        .padding(0.dp, 8.dp, 8.dp, 0.dp)
                        .paint(painterResource(id = R.drawable.bg_task_3))
                        .padding(14.dp, 0.dp)
                    ) {
                        Column(modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.SpaceEvenly
                        ) {
                            TaskHeader(R.drawable.img_close, false)
                            TaskTitle("Canceled", false)
                            TaskInfo("15 Task", false)
                        }
                    }
                }

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Box(modifier = Modifier
                        .weight(4.5f)
                        .fillMaxWidth()
                        .padding(8.dp, 0.dp, 0.dp, 8.dp)
                        .paint(painterResource(id = R.drawable.bg_task_2))
                        .padding(14.dp, 0.dp)
                    ) {
                        Column(modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.SpaceEvenly
                        ) {
                            TaskHeader(R.drawable.img_clock, false)
                            TaskTitle("Pending", false)
                            TaskInfo("15 Task", false)
                        }
                    }
                    Box(modifier = Modifier
                        .weight(5.5f)
                        .fillMaxWidth()
                        .padding(8.dp, 8.dp, 0.dp, 0.dp)
                        .paint(painterResource(id = R.drawable.bg_task_4))
                        .padding(14.dp, 0.dp)
                    ) {
                        Column(modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.SpaceEvenly
                        ) {
                            TaskHeader(R.drawable.img_folder, true)
                            TaskTitle("On Going", true)
                            TaskInfo("67 Task", true)
                        }
                    }
                }
            }
        }

        @Composable
        fun TaskHeader(image: Int, highlight: Boolean) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = null
                )

                Image(
                    painter = painterResource(
                        id = if (highlight) R.drawable.ic_narrow_right
                        else R.drawable.ic_narrow_right_white),
                    contentDescription = null
                )
            }
        }

        @Composable
        fun TaskInfo(label: String, highlight: Boolean) {
            Text(text = label,
                color = colorResource(
                    id = if (highlight) R.color.title_color else android.R.color.white),
                fontSize = 14.sp
            )
        }

        @Composable
        fun TaskTitle(label: String, highlight: Boolean) {
            Text(text = label,
                color = colorResource(
                    id = if (highlight) R.color.title_color else android.R.color.white),
                fontSize = 16.sp,
                fontWeight = FontWeight(weight = 500),
            )
        }

        @Composable
        fun Header() {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    TagText("Hi, Steven")
                    Text(
                        text = "Let’s make this day productive",
                        fontSize = 14.sp,
                        color = colorResource(R.color.text_description_color),
                    )
                }
                Image(
                    painter = painterResource(R.drawable.img_avatar),
                    contentDescription = null,
                    Modifier
                        .background(
                            color = colorResource(id = android.R.color.white),
                            shape = RoundedCornerShape(14.dp)
                        )
                        .height(36.dp)
                        .width(36.dp)
                )
            }
        }

        @Composable
        fun TagText(label: String, modifier: Modifier = Modifier) {
            Text(
                text = label,
                modifier = modifier,
                fontSize = 28.sp,
                color = colorResource(R.color.title_color),
                style = TextStyle(fontWeight = FontWeight(600))
            )
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
            HomePage.HomePage()
        }
    }
}