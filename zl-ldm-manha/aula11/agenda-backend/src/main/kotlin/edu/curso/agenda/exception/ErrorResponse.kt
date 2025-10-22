package edu.curso.agenda.exception

import java.time.LocalDateTime

data class ErrorResponse(
    val erro : String,
    val message : String,
    val status : Int,
    val path : String? = null,
    val timestamp : LocalDateTime = LocalDateTime.now()
)