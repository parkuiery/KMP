import network.WeatherDataSource

class Repository {

    private val getWeatherDataSource = WeatherDataSource()

    suspend fun getWeatherRepository(
        serviceKey: String,
        baseDate: String,
        baseTime: String,
        nx: String,
        ny: Long
    ) {
        return getWeatherDataSource.getWeatherData(
            serviceKey = serviceKey,
            baseDate = baseDate,
            baseTime = baseTime,
            nx = nx,
            ny = ny,
        )
    }
}