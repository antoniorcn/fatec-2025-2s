package edu.curso.agendacontato

import kotlinx.serialization.Serializable

@Serializable
data class Contato(
    val id : Int = 0,
    val nome : String,
    val telefone : String,
    val email : String
)
