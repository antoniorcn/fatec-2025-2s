package edu.curso.agenda.repository

import edu.curso.agenda.model.Contato
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param


interface ContatoRepositoryInDB : JpaRepository<Contato, Long?> {

    @Query("Select c From Contato c Where c.nome Like %:nome%")
    fun consultarPorNome(@Param("nome") nome : String) : List<Contato>

}