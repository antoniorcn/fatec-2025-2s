package edu.curso.agenda.controller

import edu.curso.agenda.dto.UsuarioDTO
import edu.curso.agenda.exception.APIException
import edu.curso.agenda.model.Usuario
import edu.curso.agenda.security.JwtUtils
import edu.curso.agenda.service.UsuarioService
import jakarta.validation.Valid
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatusCode
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class UsuarioController(
    val service : UsuarioService,
    val passwordEncoder : PasswordEncoder
) {

    val logger : Logger = LoggerFactory.getLogger(UsuarioController::class.java)

    @PostMapping("/signin")
    fun signin(@RequestBody @Valid usuario : UsuarioDTO) : ResponseEntity<String> {
        val userDB : Usuario? = service.consultarPorEmail( usuario.email )
        if (userDB != null) {
            // Authenticação

            // 123456           $2a$10$LkYJ8qhsNS0mgE....
            // usuario.senha == userDB.senha
            if (passwordEncoder.matches(usuario.senha, userDB.senha)) {
                val jwtUtils = JwtUtils()
                val token = jwtUtils.createToken(userDB.email, userDB.perfil)
                val retorno = """
                    {
                        "status": "ok",
                        "token": "$token"
                    }
                """.trimIndent()
                /*
                {
                    "status": "ok",
                    "token": "23kj4h2k43hk23h4k234..."
                }
                 */

                return ResponseEntity
                    .ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(retorno)
            } else {
                return ResponseEntity
                    .status(HttpStatusCode.valueOf(401))
                    .body ("Usuario não autorizado")
            }
        }
        throw APIException(401, "Credenciais incorretas")
    }

    @PostMapping("/signup")
    fun signup( @RequestBody @Valid usuario : Usuario) :
            ResponseEntity<String> {
        val user = usuario.copy(senha = passwordEncoder.encode(usuario.senha))
        service.adicionar( user )
        return ResponseEntity.ok("Usuario cadastrado com sucesso")
    }
}