package component

import first.composeapp.generated.resources.Res
import first.composeapp.generated.resources.ic_button
import first.composeapp.generated.resources.ic_moon_cloud_fast_wind
import first.composeapp.generated.resources.ic_moon_cloud_mid_rain
import first.composeapp.generated.resources.ic_sun_cloud_angled_rain
import first.composeapp.generated.resources.ic_sun_cloud_mid_rain
import first.composeapp.generated.resources.ic_tornado
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class)
object WeatherIcon {
    val Wind = Res.drawable.ic_moon_cloud_fast_wind
    val MoonRain = Res.drawable.ic_moon_cloud_mid_rain
    val SunRain = Res.drawable.ic_sun_cloud_mid_rain
    val SunAngledRain = Res.drawable.ic_sun_cloud_angled_rain
    val Tornado = Res.drawable.ic_tornado
}