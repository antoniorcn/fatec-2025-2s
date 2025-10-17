package edu.curso.agenda.model

import kotlinx.serialization.Serializable

@Serializable
data class Contato (
    val nome : String,
    val email : String,
    val telefone : String
)