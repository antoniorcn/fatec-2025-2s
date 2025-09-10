package edu.curso.agenda.dto

import com.fasterxml.jackson.annotation.*
import edu.curso.agenda.model.Contato
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size
import java.time.LocalDateTime

@JsonIdentityInfo(property = "id", generator = ObjectIdGenerators.PropertyGenerator::class)
data class CompromissoViewDTO(
    var id : Int?,
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

//    @JsonBackReference
    var contato : Contato

) {
    constructor() : this(null, "", null,
        LocalDateTime.now(), LocalDateTime.now(),
        "", "", Contato())
}