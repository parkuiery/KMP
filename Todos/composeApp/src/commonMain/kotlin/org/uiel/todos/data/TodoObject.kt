package org.uiel.todos.data

import kotlinx.serialization.Serializable

@Serializable
data class TodoObject(
    val id: Int,
    val title: String,
    val content: String,
)
