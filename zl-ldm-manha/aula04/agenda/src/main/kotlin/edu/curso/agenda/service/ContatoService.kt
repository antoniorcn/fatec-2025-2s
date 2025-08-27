package edu.curso.agenda.service

import edu.curso.agenda.model.Contato
import edu.curso.agenda.repository.ContatoRepository
import org.springframework.stereotype.Service

@Service
class ContatoService(val repository : ContatoRepository) {

    fun consultarTodos() : List<Contato> {
        return repository.consultarTodos()
    }

    fun adicionar(contato : Contato) {
        repository.adicionar( contato )
    }

    fun remover(id : Int) {
        repository.remover( id )
    }

    fun atualizar(id : Int, contato : Contato) {
        repository.atualizar( id, contato )
    }
}