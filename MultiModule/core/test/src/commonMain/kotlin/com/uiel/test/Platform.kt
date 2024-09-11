package com.uiel.test

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform