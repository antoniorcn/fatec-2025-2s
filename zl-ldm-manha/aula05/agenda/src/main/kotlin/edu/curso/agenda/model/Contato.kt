package edu.curso.agenda.model

import jakarta.persistence.*
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size

@Entity
data class Contato(
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="contato-generator")
    @TableGenerator(name="contato-generator", table="id_sequences",
        pkColumnName = "seq_id",
        valueColumnName = "seq_value")
    var id : Int?,
    @Column(length = 100)
    @field:NotEmpty()
    @field:Size(min=5, max=100)
    val nome : String,
    @Column(length = 30)
    @field:Size(min=5, max=30)
    val telefone : String,
    @Column(length = 100)
    @field:Email
    val email: String
) {
    constructor() : this(id=null, nome="", telefone="", email="")
}