package edu.curso.agenda.mapper

import edu.curso.agenda.dto.CompromissoDTO
import edu.curso.agenda.dto.CompromissoDTOView
import edu.curso.agenda.model.Compromisso
import edu.curso.agenda.service.ContatoServico
import org.springframework.stereotype.Component

@Component
class CompromissoMapper(
    val contatoServico : ContatoServico
) {
fun fromDTO(dto: CompromissoDTO): Compromisso? {
        val contato = contatoServico.procurarPorId( dto.contato )
        return if ( contato.isPresent ) {
            Compromisso(
                id = dto.id,
                titulo = dto.titulo,
                descricao = dto.descricao,
                inicio = dto.inicio,
                termino = dto.termino,
                local = dto.local,
                tipo = dto.tipo,
                contato = contato.get()
            )
        } else {
            null;
        }
    }

    fun toDTO(compromisso: Compromisso): CompromissoDTO {
        return CompromissoDTO(
            id = compromisso.id,
            titulo = compromisso.titulo,
            descricao = compromisso.descricao,
            inicio = compromisso.inicio,
            termino = compromisso.termino,
            local = compromisso.local,
            tipo = compromisso.tipo,
            contato = compromisso.contato.id?:0
        )
    }

    fun toDTOView(compromisso: Compromisso): CompromissoDTOView {
//        val contatoId = if (compromisso.contato != null && compromisso.contato.id != null) {
        val contatoId = if (compromisso.contato.id != null) {
            compromisso.contato.id?:0
        } else {
            0
        }
        return CompromissoDTOView(
            id = compromisso.id,
            titulo = compromisso.titulo,
            descricao = compromisso.descricao,
            inicio = compromisso.inicio,
            termino = compromisso.termino,
            local = compromisso.local,
            contato = contatoId
        )
    }
}