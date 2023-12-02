package com.example.composedemo.view.custom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composedemo.R
import com.example.composedemo.ui.theme.ComposeDemoTheme

class WeekDay {

    companion object {
        @Composable
        fun WeekDay() {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(71.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Day("MO", "12", false)
                Day("TU", "13", false)
                Day("WE", "14", true)
                Day("TH", "15", false)
                Day("FR", "16", false)
                Day("SA", "17", false)
                Day("SU", "18", false)
            }
        }

        @Composable
        private fun Day(dayOfWeek: String, date: String, isSelected: Boolean) {
            val fontColor = if (isSelected) android.R.color.white else R.color.purple_700
            val backgroundColor =
                if (!isSelected) android.R.color.transparent else R.color.mainColor

            Column(
                modifier = Modifier
                    .background(
                        color = colorResource(id = backgroundColor),
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(12.dp, 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = dayOfWeek,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(500),
                    color = colorResource(id = fontColor),
                    modifier = Modifier.padding(bottom = 6.dp)
                )
                Text(
                    text = date,
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    color = colorResource(id = fontColor)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WeekDayPreview() {
    ComposeDemoTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            WeekDay.WeekDay()
        }
    }
}