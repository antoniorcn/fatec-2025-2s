package edu.curso.helloworld

import org.springframework.boot.web.servlet.error.ErrorController
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/")
class Controlador {

    @RequestMapping("/")
    fun helloWorld() : ResponseEntity<String> {
        return ResponseEntity.ok("<h1>Hello World Spring Boot e Kotlin<h1>")
    }

    @GetMapping("/contato")
    fun contato() : ResponseEntity<String> {
        return ResponseEntity.ok("<h1>Agenda de contato</h1>")
    }
}

@Controller
class ControladorErro : ErrorController {

    @RequestMapping("/error")
    fun error() : ResponseEntity<String> {
        return ResponseEntity.ok("<h1>Erro ao acessar o recurso</h1>")
    }
}