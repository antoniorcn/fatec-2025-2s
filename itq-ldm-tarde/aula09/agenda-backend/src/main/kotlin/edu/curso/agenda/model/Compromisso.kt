package edu.curso.agenda.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonManagedReference
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import jakarta.persistence.*
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import org.hibernate.validator.constraints.Length
import java.time.LocalDateTime

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator::class, property = "id")
data class Compromisso(
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator="compromisso-generator")
    @TableGenerator(name="compromisso-generator", table="id_sequences",
        pkColumnName = "seq_id",
        pkColumnValue = "compromisso",
        valueColumnName = "seq_value",
        initialValue = 5)
    var id : Int?,

    @field:Length(min = 5, max = 50, message = "Titulo precisa ter entre 5 e 50 caracteres")
    @field:NotEmpty(message = "O titulo precisa ser preenchido")
    @Column(length = 50)
    val titulo : String,

    val descricao : String?,

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val inicio : LocalDateTime,

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val termino : LocalDateTime,

    @Column(length = 50)
    val local : String?,

    @Column(length = 20)
    @field:NotEmpty(message = "O tipo precisa ser preenchido")
    val tipo : String,

    @ManyToOne
    @JoinColumn(name = "contato_id")
    // @JsonManagedReference("contato")
    val contato : Contato
) {
    constructor():this(id=0, titulo="", descricao=null,
        inicio=LocalDateTime.now(), termino=LocalDateTime.now(),
        local=null, tipo="", contato=Contato())
}