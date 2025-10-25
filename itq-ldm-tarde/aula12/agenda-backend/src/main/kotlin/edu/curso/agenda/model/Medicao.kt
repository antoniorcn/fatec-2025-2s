package edu.curso.agenda.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Medicao(
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,
        generator="medicao-generator")
    @TableGenerator(name="medicao-generator", table="id_sequences",
        pkColumnName = "seq_id",
        pkColumnValue = "medicao",
        valueColumnName = "seq_value",
        initialValue = 5)
    var id : Long?,
    val temperatura : Double,
    val umidade : Double,
    val datahoraAtual: LocalDateTime = LocalDateTime.now()
) {
    constructor() : this(null, 0.0, 0.0, LocalDateTime.now())
}