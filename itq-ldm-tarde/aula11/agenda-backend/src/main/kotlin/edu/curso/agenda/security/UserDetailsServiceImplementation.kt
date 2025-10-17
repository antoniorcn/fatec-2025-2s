package edu.curso.agenda.security

import edu.curso.agenda.model.Usuario
import edu.curso.agenda.repository.UsuarioRepositoryDB
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserDetailsServiceImplementation(
    val repository : UsuarioRepositoryDB
) : UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails? {
        if (username != null) {
            return UserDetailsImplementation(
                repository.findByEmail(username).get()
            )
        } else {
            throw UsernameNotFoundException("Usuario não encontrado")
        }
    }

    fun signup(username : String, password : String) {
        val usuario = Usuario(email = username, password = password, perfil="USER")
        repository.save(usuario)
    }

}