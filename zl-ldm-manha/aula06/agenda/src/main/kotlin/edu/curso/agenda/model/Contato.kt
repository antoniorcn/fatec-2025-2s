package edu.curso.agenda.model

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonManagedReference
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import jakarta.persistence.*
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size

@Entity
@JsonIdentityInfo(property = "id", generator = ObjectIdGenerators.PropertyGenerator::class)
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
    val email: String,

    @OneToMany( mappedBy = "contato")
//    @JsonManagedReference
    val compromissos : MutableList<Compromisso> = mutableListOf()
) {
    constructor() : this(id=null, nome="", telefone="", email="")
}