package edu.curso.agenda.repository

import edu.curso.agenda.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository : JpaRepository<Usuario, Long>{

    fun findByEmail(email : String) : Usuario?


}