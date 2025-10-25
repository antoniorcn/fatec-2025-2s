package edu.curso.agenda.controller

import edu.curso.agenda.dto.UsuarioDTO
import edu.curso.agenda.security.TokenService
import edu.curso.agenda.security.UserDetailsServiceImplementation
import jakarta.validation.Valid
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.Calendar
import java.util.Date

@RestController
@RequestMapping("/auth")
class UsuarioController(
    val tokenServico : TokenService,
    val servico : UserDetailsServiceImplementation) {

    private val logger = LoggerFactory.getLogger(UsuarioController::class.java)

    fun generateToken(usuarioDTO : UsuarioDTO) : String {
        val cal = Calendar.getInstance()
        cal.add(Calendar.DAY_OF_MONTH, 1)
        val d = cal.time
        logger.info("Gerando token para data: $d")
        val token = tokenServico.generateToken(usuarioDTO.username, d )
        logger.info("Token gerado ==>: $token")
        return """{"status": "ok", "token": "$token"}"""
    }

    @PostMapping("/signup", produces = ["application/json"])
    fun signup( @Valid @RequestBody usuarioDTO : UsuarioDTO) :
            ResponseEntity<String> {
        servico.signup( usuarioDTO.username, usuarioDTO.password )
        return ResponseEntity.ok( generateToken( usuarioDTO ) )
    }

    @PostMapping("/signin")
    fun signin( @Valid @RequestBody usuarioDTO : UsuarioDTO) :
            ResponseEntity<String> {
        servico.loadUserByUsername( usuarioDTO.username )
        return ResponseEntity.ok( generateToken( usuarioDTO ) )
    }

}
