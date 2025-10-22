package edu.curso.agenda.model

import com.fasterxml.jackson.annotation.*
import jakarta.persistence.*
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size
import java.time.LocalDateTime

@JsonIdentityInfo(property = "id", generator = ObjectIdGenerators.PropertyGenerator::class)
@Entity
data class Compromisso(
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE,
                                generator="compromisso-generator")
    @TableGenerator(name="compromisso-generator",
        table="id_sequences",
        pkColumnName = "seq_id",
        valueColumnName = "seq_value")
    var id : Int?,
    @Column(length = 50)
    @field:NotEmpty()
    @field:Size(min=5, max=50)
    var titulo : String,

    @Column(length = 255)
    var descricao : String?,

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    var inicio : LocalDateTime,

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    var termino : LocalDateTime,

    @Column(length = 50)
    var local : String?,

    @Column(length = 10)
    @field:NotEmpty()
    var tipo : String,

    @ManyToOne
    @JoinColumn(name="contato_id")
//    @JsonBackReference
    var contato : Contato

) {
    constructor() : this(null, "", null,
        LocalDateTime.now(), LocalDateTime.now(),
        "", "", Contato())
}