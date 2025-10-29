package edu.curso.agenda.dto

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size
import java.time.LocalDateTime

@JsonIdentityInfo(property = "id", generator = ObjectIdGenerators.PropertyGenerator::class)
data class CompromissoDTO(
    var id : Long?,
    @field:NotEmpty()
    @field:Size(min=5, max=50)
    var titulo : String,

    var descricao : String?,

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    var inicio : LocalDateTime,

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    var termino : LocalDateTime,

    var local : String?,

    @field:NotEmpty()
    var tipo : String,

    var contato : Long

) {
    constructor() : this(null, "", null,
        LocalDateTime.now(), LocalDateTime.now(),
        "", "", 0)
}