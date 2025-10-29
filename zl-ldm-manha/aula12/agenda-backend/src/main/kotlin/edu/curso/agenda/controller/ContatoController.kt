package edu.curso.agenda.controller

import edu.curso.agenda.dto.ContatoDTO
import edu.curso.agenda.model.Contato
import edu.curso.agenda.service.ContatoService
import jakarta.validation.Valid
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
    fun adicionarContato( @RequestBody @Valid contatoDTO : ContatoDTO ) :
            ResponseEntity<String> {
        val contato = Contato( null, contatoDTO.nome,
            contatoDTO.telefone, contatoDTO.email)
        service.adicionar( contato )
        return ResponseEntity.ok("Contato gravado com sucesso")
    }

    @DeleteMapping("/{id}")
    fun removerContato(@PathVariable("id") id : Long) :
            ResponseEntity<String> {
        service.remover( id )
        return ResponseEntity.ok("Contato removido com sucesso")
    }

    @PutMapping("/{id}")
    fun atualizarContato(@PathVariable("id") id : Long,
                         @RequestBody @Valid contato : Contato) :
            ResponseEntity<String> {
        service.atualizar( id, contato )
        return ResponseEntity.ok("Contato atualizado com sucesso")
    }
}