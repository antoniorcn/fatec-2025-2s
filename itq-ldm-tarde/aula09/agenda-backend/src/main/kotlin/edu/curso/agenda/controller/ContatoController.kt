package edu.curso.agenda.controller

import edu.curso.agenda.model.Contato
import edu.curso.agenda.repository.RespostaCallback
import edu.curso.agenda.service.ContatoServico
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/contato")
class ContatoController( val servico : ContatoServico) {

    @PostMapping
    fun adicionarContato( @Valid @RequestBody contato : Contato ) :
            ResponseEntity<String> {
        servico.adicionar( contato )
        return ResponseEntity.ok("Contato adicionado com sucesso")
    }

    @GetMapping()
    fun lerContatos(@RequestParam("nome") nome : String?) : ResponseEntity<List<Contato>> {
        return if (nome != null) {
            ResponseEntity.ok(servico.consultarPorNome( nome ))
        } else {
            ResponseEntity.ok(servico.lerTodos())
        }
    }

    @DeleteMapping("/{id}")
    fun apagarContato(@PathVariable("id") id : Int) : ResponseEntity<String> {
        var mensagem = "Contato apagado com sucesso"
        val callback = object : RespostaCallback {
            override fun resposta(sucesso: Boolean, msg: String) {
                if( !sucesso ) {
                    mensagem = msg
                }
            }
        }
        servico.apagar( id, callback )
        return ResponseEntity.ok(mensagem)
    }

    @PutMapping("/{id}")
    fun atualizarContato( @PathVariable("id") id : Int,
                          @Valid @RequestBody contato : Contato ) :
            ResponseEntity<String> {
        var mensagem = "Contato atualizado com sucesso"
        val atualizarCallback = object : RespostaCallback {
            override fun resposta(sucesso: Boolean, msg: String) {
                if (!sucesso) {mensagem = msg}
            }
        }
        println("Id ==> $id")
        println("Contato ==> $contato")
        servico.atualizar(id, contato, atualizarCallback)
        return ResponseEntity.ok(mensagem)
    }
}
