package edu.curso.agenda.controller

import edu.curso.agenda.dto.UsuarioDTO
import edu.curso.agenda.security.UserDetailsServiceImplementation
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class UsuarioController(val servico : UserDetailsServiceImplementation) {

    @PostMapping("/signup")
    fun signup( @Valid @RequestBody usuarioDTO : UsuarioDTO) :
            ResponseEntity<String> {
        servico.signup( usuarioDTO.username, usuarioDTO.password )
        return ResponseEntity.ok("Usuario adicionado com sucesso")
    }

    @PostMapping("/signin")
    fun signin( @Valid @RequestBody usuarioDTO : UsuarioDTO) :
            ResponseEntity<String> {
        servico.loadUserByUsername( usuarioDTO.username )
        return ResponseEntity.ok("Usuario carregado com sucesso")
    }

}
