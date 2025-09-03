package edu.curso.agenda.model

import jakarta.persistence.*

@Entity
data class Contato(
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="contato-generator")
    @TableGenerator(name="contato-generator", table="id_sequences",
        pkColumnName = "seq_id",
        valueColumnName = "seq_value")
    var id : Int?,
    @Column(length = 100)
    val nome : String,
    @Column(length = 30)
    val telefone : String,
    @Column(length = 100)
    val email: String
) {
    constructor() : this(id=null, nome="", telefone="", email="")
}