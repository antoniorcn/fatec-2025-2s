package edu.curso.HelloWorldSpringKoltin

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/")
class Controlador(val servico: Servico) {

    // val servico : Servico = Servico()

    @RequestMapping("/")
    fun olaPrincipal() : ResponseEntity<String> {
        return ResponseEntity.ok(servico.gerarOla())
    }

    @RequestMapping("/contato")
    fun olaAgendaContato() : ResponseEntity<String> {
        return ResponseEntity.ok(servico.gerarAgendaContato())
    }

}