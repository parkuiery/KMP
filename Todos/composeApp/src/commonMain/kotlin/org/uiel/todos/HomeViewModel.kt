package org.uiel.todos

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.uiel.todos.data.TodoObject

class HomeViewModel(private val networkRepository: NetworkRepository) {
    private val _homeState = MutableStateFlow(HomeState())
    val homeViewState = _homeState.asStateFlow()

    init {
        getData()
    }

    private fun getData() {
        CoroutineScope(Dispatchers.IO).launch {
            runCatching {
                networkRepository.getData()
            }.onSuccess { todos->
                _homeState.update { it.copy(todos = todos) }
            }.onFailure {
                println(it)
            }
        }
    }

    data class HomeState(
        val todos: List<TodoObject> = emptyList()
    )
}