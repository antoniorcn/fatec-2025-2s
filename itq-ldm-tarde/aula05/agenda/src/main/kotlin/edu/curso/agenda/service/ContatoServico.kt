package edu.curso.agenda.service

import edu.curso.agenda.model.Contato
import edu.curso.agenda.repository.ContatoRepositoryDB
import edu.curso.agenda.repository.RespostaCallback
import org.springframework.stereotype.Service

@Service
class ContatoServico(val repository : ContatoRepositoryDB) {

    fun adicionar( contato : Contato) {
        repository.save( contato )
    }

    fun lerTodos() : List<Contato> {
        return repository.findAll()
    }

    fun consultarPorNome(nome : String) : List<Contato> {
        return repository.consultarPorNome( nome )
    }

    fun apagar( id : Int, callback: RespostaCallback) {
        repository.deleteById( id )
        callback.resposta()
    }

    fun atualizar( id : Int, contato : Contato, callback: RespostaCallback) {
        val contatoCopia = contato.copy(id = id)
        repository.save( contatoCopia )
        callback.resposta()
    }

}