package edu.curso.agenda.model

import jakarta.persistence.*

@Entity
data class Usuario(
    @Id
    @GeneratedValue( strategy = GenerationType.TABLE, generator="usuario-generator")
    @TableGenerator(name="usuario-generator", table="id_sequences",
        pkColumnName = "seq_id",
        valueColumnName = "seq_value")
    var id : Long?,
    @Column(length=100)
    val nome : String,
    @Column(length=100, unique = true)
    val email : String,
    @Column(length=255)
    val senha : String,
    @Column(length=50)
    val perfil : String)
{
    constructor() : this(id=null, nome="", email="", senha="", perfil="")
}