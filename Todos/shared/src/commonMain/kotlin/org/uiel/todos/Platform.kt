package org.uiel.todos

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform