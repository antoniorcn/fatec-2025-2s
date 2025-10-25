package edu.curso.agenda.dto

import com.fasterxml.jackson.annotation.JsonFormat
import jakarta.validation.constraints.NotEmpty
import org.hibernate.validator.constraints.Length
import java.time.LocalDateTime

data class CompromissoDTO(
    var id : Int?,

    @field:Length(min = 5, max = 50, message = "Titulo precisa ter entre 5 e 50 caracteres")
    @field:NotEmpty(message = "O titulo precisa ser preenchido")
    val titulo : String,

    val descricao : String?,

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val inicio : LocalDateTime,

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val termino : LocalDateTime,

    val local : String?,

    @field:NotEmpty(message = "O tipo precisa ser preenchido")
    val tipo : String,

    val contato : Int
) {
    constructor():this(id=0, titulo="", descricao=null,
        inicio=LocalDateTime.now(), termino=LocalDateTime.now(),
        local=null, tipo="", contato=0
    )
}