package edu.curso.agenda.service

import edu.curso.agenda.model.Contato
import edu.curso.agenda.repository.ContatoRepositoryInDB
import org.springframework.stereotype.Service

@Service
class ContatoService(val repository : ContatoRepositoryInDB) {

    fun consultarTodos() : List<Contato> {
        return repository.findAll()
    }

    fun consultarPorNome( nome : String ) : List<Contato> {
        return repository.consultarPorNome( nome )
    }

    fun adicionar(contato : Contato) {
        repository.save( contato )
    }

    fun remover(id : Int) {
        repository.deleteById( id )
    }

    fun atualizar(id : Int, contato : Contato) {
        val contatoCopia = contato.copy(id = id)
        repository.save( contatoCopia )
    }
}