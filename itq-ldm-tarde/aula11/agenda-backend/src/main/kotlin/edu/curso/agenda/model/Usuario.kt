package edu.curso.agenda.model

import jakarta.persistence.*

@Entity
data class Usuario(
    @field:Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator="usuario-generator")
    @TableGenerator(name="usuario-generator", table="id_sequences",
        pkColumnName = "seq_id",
        pkColumnValue = "usuario",
        valueColumnName = "seq_value",
        initialValue = 5)
    val id : Long?=null,

    @Column(length=100, unique = true, nullable = false)
    val email : String,

    @Column(length=255)
    val password : String,

    @Column(length=50)
    val perfil : String
) { 
    constructor() : this(null, email = "", password = "", perfil = "")
}