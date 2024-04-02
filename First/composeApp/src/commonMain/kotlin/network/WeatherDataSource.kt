package network

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json

class WeatherDataSource {
    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }

    suspend fun getWeatherData(serviceKey: String,baseDate: String,baseTime: String,nx: String, ny: Long) {
        withContext(Dispatchers.IO) {
            return@withContext httpClient
                .get("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst?serviceKey=$serviceKey&dateType=JSON&base_date=$baseTime&base_time=$baseDate&nx=$nx&ny=$ny")
        }
    }
}