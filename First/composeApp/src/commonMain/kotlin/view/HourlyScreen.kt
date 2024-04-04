package view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import component.WeatherIcon
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@Composable
fun HourlyScreen() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
    ) {
        LazyRow {
            items(12) {
                WeatherItem(
                )
            }
        }
    }
}
@OptIn(ExperimentalResourceApi::class)
@Composable
private fun WeatherItem(
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 6.dp)
            .background(
                shape = RoundedCornerShape(30.dp),
                color = Color(0xFF48319D).copy(alpha = 0.8f),
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(
                vertical = 16.dp
            ),
            text = "12 AM",
            fontSize = 15.sp,
            color = Color.White,
        )
        Image(
            modifier = Modifier.padding(
                horizontal = 8.dp,
            ),
            painter = painterResource(WeatherIcon.MoonRain),
            contentDescription = "weather_icon"
        )
        Text(
            modifier = Modifier.padding(vertical = 16.dp),
            text = "19°",
            fontSize = 20.sp,
            color = Color.White,
        )
    }
}