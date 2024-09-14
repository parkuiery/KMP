package com.uiel.core.test

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform