package org.uiel.todos

import org.uiel.todos.data.KtorTodosApi
import org.uiel.todos.data.TodoObject
import org.uiel.todos.data.TodosApi

class NetworkRepository(private val ktorTodosApi: KtorTodosApi) {

    suspend fun getData(): List<TodoObject> = ktorTodosApi.getData()
}
