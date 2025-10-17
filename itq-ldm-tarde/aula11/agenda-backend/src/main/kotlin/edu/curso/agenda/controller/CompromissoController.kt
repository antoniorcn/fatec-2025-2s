package edu.curso.agenda.controller

import edu.curso.agenda.dto.CompromissoDTO
import edu.curso.agenda.dto.CompromissoDTOView
import edu.curso.agenda.mapper.CompromissoMapper
import edu.curso.agenda.model.Compromisso
import edu.curso.agenda.repository.RespostaCallback
import edu.curso.agenda.service.CompromissoServico
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/compromisso")
class CompromissoController(val servico : CompromissoServico,
    val compromissoMapper: CompromissoMapper) {

    @PostMapping
    fun adicionarCompromisso( @Valid @RequestBody compromissoDTO : CompromissoDTO ) :
            ResponseEntity<String> {
        val compromisso = compromissoMapper.fromDTO( compromissoDTO )
        if ( compromisso != null ) {
            servico.adicionar(compromisso)
            return ResponseEntity.ok("Compromisso adicionado com sucesso")
        } else {
            return ResponseEntity.badRequest()
                .body("Não foi possivel localizar o ID do contato deste compromisso")
        }
    }

    @GetMapping()
    fun lerCompromissos(@RequestParam("titulo") titulo : String?) : ResponseEntity<List<CompromissoDTOView>> {
        val listaCompromissos = if (titulo != null) {
            servico.consultarPorTitulo( titulo )
        } else {
            servico.lerTodos()
        }
        val listaDTOView = listaCompromissos
            .map{ it -> compromissoMapper.toDTOView(it) }
        return ResponseEntity.ok(listaDTOView)
    }

    @DeleteMapping("/{id}")
    fun apagarCompromisso(@PathVariable("id") id : Int) : ResponseEntity<String> {
        var mensagem = "Compromisso apagado com sucesso"
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
    fun atualizarCompromisso( @PathVariable("id") id : Int,
                          @Valid @RequestBody compromissoDTO : CompromissoDTO ) :
            ResponseEntity<String> {
        var mensagem = "Compromisso atualizado com sucesso"
        val atualizarCallback = object : RespostaCallback {
            override fun resposta(sucesso: Boolean, msg: String) {
                if (!sucesso) {mensagem = msg}
            }
        }
        println("Id ==> $id")
        val compromisso = compromissoMapper.fromDTO( compromissoDTO )
        if (compromisso != null) {
            println("Compromisso ==> $compromisso")
            servico.atualizar(id, compromisso, atualizarCallback)
            return ResponseEntity.ok(mensagem)
        } else {
            return ResponseEntity.badRequest()
                .body("Não foi possivel localizar o ID do contato deste compromisso")
        }
    }
}
