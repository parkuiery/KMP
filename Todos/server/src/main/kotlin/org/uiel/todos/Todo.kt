package org.uiel.todos

import kotlinx.serialization.Serializable

@Serializable
data class Todo (
    val id:Int,
    val title: String,
    val content: String,
)
