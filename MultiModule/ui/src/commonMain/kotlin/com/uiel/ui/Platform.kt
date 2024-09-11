package com.uiel.ui

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform