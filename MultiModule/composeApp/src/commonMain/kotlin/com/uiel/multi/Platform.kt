package com.uiel.multi

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform