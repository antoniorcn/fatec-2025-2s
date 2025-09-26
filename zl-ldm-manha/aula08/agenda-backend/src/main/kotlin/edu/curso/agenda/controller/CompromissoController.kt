package edu.curso.agenda.controller

import edu.curso.agenda.dto.CompromissoDTO
import edu.curso.agenda.dto.CompromissoViewDTO
import edu.curso.agenda.mapper.CompromissoMapper
import edu.curso.agenda.service.CompromissoService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/compromisso")
class CompromissoController(val service : CompromissoService,
    val compromissoMapper: CompromissoMapper) {

    @GetMapping
    fun lerCompromissos(@RequestParam("titulo") titulo : String?) : ResponseEntity<List<CompromissoViewDTO>> {
        val compromissos = if (titulo == null) {
            service.consultarTodos()
        } else {
            service.consultarPorTitulo( titulo )
        }
        return ResponseEntity.ok( compromissos.map { compromissoMapper.toDTO( it ) } )
    }

    @PostMapping
    fun adicionarCompromisso( @RequestBody @Valid compromissoDTO : CompromissoDTO) :
            ResponseEntity<String> {
        val compromisso = compromissoMapper.fromDTO( compromissoDTO )
        service.adicionar( compromisso )
        return ResponseEntity.ok("Compromisso gravado com sucesso")
    }

    @DeleteMapping("/{id}")
    fun removerCompromisso(@PathVariable("id") id : Int) :
            ResponseEntity<String> {
        service.remover( id )
        return ResponseEntity.ok("Compromisso removido com sucesso")
    }

    @PutMapping("/{id}")
    fun atualizarCompromisso(@PathVariable("id") id : Int,
                         @RequestBody @Valid compromissoDto : CompromissoDTO) :
            ResponseEntity<String> {
        val compromisso = compromissoMapper.fromDTO( compromissoDto )
        service.atualizar( id, compromisso )
        return ResponseEntity.ok("Compromisso atualizado com sucesso")
    }
}