package edu.curso.agenda.service

import edu.curso.agenda.model.Contato
import edu.curso.agenda.repository.ContatoRepositorio
import edu.curso.agenda.repository.RespostaCallback
import org.springframework.stereotype.Service

@Service
class ContatoServico(val repository : ContatoRepositorio) {

    fun adicionar( contato : Contato) {
        repository.adicionar( contato )
    }

    fun lerTodos() : List<Contato> {
        return repository.lerTodos()
    }

    fun apagar( id : Int, callback: RespostaCallback) {
        repository.apagar( id, callback )
    }

    fun atualizar( id : Int, contato : Contato, callback: RespostaCallback) {
        repository.atualizar( id, contato, callback )
    }

}