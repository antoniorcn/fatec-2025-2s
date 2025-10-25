package edu.curso.agenda.security

import edu.curso.agenda.model.Usuario
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class UserDetailsImplementation( val usuario : Usuario) :
    UserDetails {

//    override fun getUsername() {
//        return usuario.email
//    }

    override fun getUsername() = usuario.email

    override fun getPassword() = usuario.password

//    override fun getAuthorities(): Collection<GrantedAuthority?>? {
//        val roles = usuario.perfil.split(",")
//        val listaAuthorities : MutableList<GrantedAuthority> = mutableListOf()
//        for (role in roles) {
//            listaAuthorities.add(
//                SimpleGrantedAuthority("ROLE_${role.trim()}")
//            )
//        }
//        return listaAuthorities
//    }
    override fun getAuthorities() = usuario.perfil
        .split(",")
        .map { SimpleGrantedAuthority("ROLE_${it.trim()}") }
}