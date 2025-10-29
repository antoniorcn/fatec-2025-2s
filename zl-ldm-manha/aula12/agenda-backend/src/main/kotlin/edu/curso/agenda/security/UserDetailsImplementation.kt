package edu.curso.agenda.security

import edu.curso.agenda.model.Usuario
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class UserDetailsImplementation(val usuario : Usuario) : UserDetails {
    override fun getUsername() : String {
        return usuario.email
    }

    override fun getPassword() : String {
        return usuario.senha
    }

    override fun getAuthorities(): Collection<GrantedAuthority?>? {
        val perfis = usuario.perfil.split(",")   // "ADMIN, GERENTE, CONVIDADO"
        return perfis.map { GrantedAuthority {"ROLE_${it.trim()}"} }
    }

    override fun isEnabled(): Boolean {
        return true
    }
}