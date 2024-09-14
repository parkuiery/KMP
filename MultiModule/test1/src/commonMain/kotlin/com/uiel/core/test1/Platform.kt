package com.uiel.core.test1

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform