package org.uiel.todos.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

interface TodosApi {
    suspend fun getData(): List<TodoObject>
}

class KtorTodosApi(private val client: HttpClient) : TodosApi {
    companion object {
        private const val API_URL = "http://localhost:8080/" // android: 10.0.2.2
    }

    override suspend fun getData(): List<TodoObject> {
        println(1)
        return try {
            client.get(API_URL).body()
        } catch (e: Exception) {
            e.printStackTrace()

            emptyList()
        }
    }
}
