package edu.curso.agenda

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform