package edu.curso.agenda.mapper

import edu.curso.agenda.dto.CompromissoDTO
import edu.curso.agenda.dto.CompromissoViewDTO
import edu.curso.agenda.model.Compromisso
import edu.curso.agenda.model.Contato
import edu.curso.agenda.service.ContatoService
import org.springframework.stereotype.Component

@Component
class CompromissoMapper (val contatoService: ContatoService) {

    fun toDTO( compromisso : Compromisso) : CompromissoViewDTO {
        return CompromissoViewDTO(
            id = compromisso.id,
            titulo = compromisso.titulo,
            descricao = compromisso.descricao,
            inicio = compromisso.inicio,
            termino = compromisso.termino,
            local = compromisso.local,
            tipo = compromisso.tipo,
            contato = compromisso.contato
        )
    }

    fun fromDTO( compromissoDTO : CompromissoDTO ) : Compromisso {
        val contato = contatoService.localizarPorId(compromissoDTO.contato)
        return Compromisso(
            id = compromissoDTO.id,
            titulo = compromissoDTO.titulo,
            descricao = compromissoDTO.descricao,
            inicio = compromissoDTO.inicio,
            termino = compromissoDTO.termino,
            local = compromissoDTO.local,
            tipo = compromissoDTO.tipo,
            contato = contato.orElse( Contato() ) )
    }

}