package edu.curso.fatec.agenda

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform