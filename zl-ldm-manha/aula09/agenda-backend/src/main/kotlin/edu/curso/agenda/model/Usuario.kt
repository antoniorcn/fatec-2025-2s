package edu.curso.agenda.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.TableGenerator

@Entity
data class Usuario(
    @Id
    @GeneratedValue( strategy = GenerationType.TABLE, generator="usuario-generator")
    @TableGenerator(name="usuario-generator", table="id_sequences",
        pkColumnName = "seq_id",
        valueColumnName = "seq_value")
    val id : Long,
    @Column(length=100)
    val nome : String,
    @Column(length=100)
    val email : String,
    @Column(length=255)
    val senha : String,
    @Column(length=50)
    val perfil : String)