package edu.curso.agenda.controller

import edu.curso.agenda.model.Contato
import edu.curso.agenda.service.ContatoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/contato")
class ContatoController(val service : ContatoService) {

    @GetMapping
    fun lerContatos(@RequestParam("nome") nome : String?) : ResponseEntity<List<Contato>> {
        if (nome == null) {
            return ResponseEntity.ok(service.consultarTodos())
        } else {
            return ResponseEntity.ok(service.consultarPorNome( nome ))
        }
    }

    @PostMapping
    fun adicionarContato( @RequestBody contato : Contato ) :
            ResponseEntity<String> {
        service.adicionar( contato )
        return ResponseEntity.ok("Contato gravado com sucesso")
    }

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