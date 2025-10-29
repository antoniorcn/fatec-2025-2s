package edu.curso.agenda.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Medicao(
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="medicao-generator")
    @TableGenerator(name="medicao-generator", table="id_sequences",
        pkColumnName = "seq_id",
        valueColumnName = "seq_value")
    var id : Long?,
    val temperatura : Double,
    val umidade : Double,
    val sensor : String,
    val dataHoraCriacao : LocalDateTime = LocalDateTime.now()
) {
    constructor() : this(0, 0.0, 0.0, "")
}