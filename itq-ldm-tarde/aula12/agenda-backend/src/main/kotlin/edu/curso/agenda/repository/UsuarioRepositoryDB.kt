package edu.curso.agenda.repository

import edu.curso.agenda.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UsuarioRepositoryDB : JpaRepository<Usuario, Int> {
//    @Query("Select u From Usuario u Where u.email = :email")
//    fun consultarPorEmail( @Param("email") emailDoUsuario : String ) : Optional<Usuario>
    fun findByEmail(email: String): Optional<Usuario>
}