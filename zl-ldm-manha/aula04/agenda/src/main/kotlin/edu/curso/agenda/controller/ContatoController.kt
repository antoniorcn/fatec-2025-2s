package edu.curso.agenda.controller

import edu.curso.agenda.model.Contato
import edu.curso.agenda.service.ContatoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/contato")
class ContatoController(val service : ContatoService) {

    @GetMapping
    fun lerTodos() : ResponseEntity<List<Contato>> {
        return ResponseEntity.ok(service.consultarTodos())
    }

    @PostMapping
    fun adicionarContato( @RequestBody contato : Contato ) :
            ResponseEntity<String> {
        service.adicionar( contato )
        return ResponseEntity.ok("Contato gravado com sucesso")
    }

    /*
        Passando parametro na URL ==>
           http://localhost:8080/contato?id=2
        @DeleteMapping
        fun removerContato(@RequestParam("id") id : Int)
     */

    /*
        Passando path value na URL ==>
        http://localhost:8080/contato/2
        @DeleteMapping("/{id}")
        fun removerContato(@PathVariable("id") id : Int)
    */

    @DeleteMapping("/{id}")
    fun removerContato(@PathVariable("id") id : Int) :
            ResponseEntity<String> {
        service.remover( id )
        return ResponseEntity.ok("Contato removido com sucesso")
    }

    @PutMapping("/{id}")
    fun atualizarContato(@PathVariable("id") id : Int,
                         @RequestBody contato : Contato) :
            ResponseEntity<String> {
        service.atualizar( id, contato )
        return ResponseEntity.ok("Contato atualizado com sucesso")
    }
}