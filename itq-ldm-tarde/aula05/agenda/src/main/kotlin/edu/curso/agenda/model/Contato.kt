package edu.curso.agenda.model

import jakarta.persistence.*
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import org.hibernate.validator.constraints.Length

@Entity
data class Contato(
    @field:Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator="contato-generator")
    @TableGenerator(name="contato-generator", table="id_sequences",
        pkColumnName = "seq_id",
        pkColumnValue = "contato",
        valueColumnName = "seq_value",
        initialValue = 5)
    var id : Int?,

    @field:Length(min = 5, max = 100, message = "Nome precisa ter entre 5 e 100 caracteres")
    @field:NotEmpty(message = "O nome precisa ser preenchido")
    @field:Column(length = 100)
    val nome : String,

    @field:NotEmpty(message = "O telefone precisa ser preenchido")
    @field:Length(min = 8, max = 30, message = "Telefone precisa ter entre 8 e 30 caracteres")
    @field:Column(length = 30)
    val telefone : String,

    @field:NotEmpty(message = "O email precisa ser preenchido")
    @field:Email(message = "Você deve informar um email valido")
    @field:Column(length = 100) val email : String
) {
    constructor():this(id=0, nome="", telefone="", email="")
}