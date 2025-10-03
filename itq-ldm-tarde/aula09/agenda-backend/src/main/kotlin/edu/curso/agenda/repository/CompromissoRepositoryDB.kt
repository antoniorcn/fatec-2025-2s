package edu.curso.agenda.repository

import edu.curso.agenda.model.Compromisso
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface CompromissoRepositoryDB : JpaRepository<Compromisso, Int> {

    @Query("Select c From Compromisso c Where c.titulo Like %:titulo%")
    fun consultarPorTitulo( @Param("titulo") titulo : String ) : List<Compromisso>

}