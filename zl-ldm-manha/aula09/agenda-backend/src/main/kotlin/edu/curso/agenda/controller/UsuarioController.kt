package edu.curso.agenda.controller

import edu.curso.agenda.exception.APIException
import edu.curso.agenda.model.Usuario
import edu.curso.agenda.service.UsuarioService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class UsuarioController(val service : UsuarioService) {

    @PostMapping("/signin")
    fun signin(@RequestBody @Valid usuario : Usuario) : ResponseEntity<String> {
        val userDB : Usuario? = service.consultarPorEmail( usuario.email )
        if (userDB != null) {
            // Authenticação
            return ResponseEntity.ok("Usuario authenticado com sucesso")
        }
        throw APIException(401, "Credenciais incorretas")
    }

    @PostMapping("/signup")
    fun signup( @RequestBody @Valid usuario : Usuario) :
            ResponseEntity<String> {
        service.adicionar( usuario )
        return ResponseEntity.ok("Usuario cadastrado com sucesso")
    }
}