package edu.curso.agenda.service

import edu.curso.agenda.model.Compromisso
import edu.curso.agenda.repository.CompromissoRepositoryDB
import edu.curso.agenda.repository.RespostaCallback
import org.springframework.stereotype.Service

@Service
class CompromissoServico(val repository : CompromissoRepositoryDB) {

    fun adicionar( compromisso : Compromisso) {
        repository.save( compromisso )
    }

    fun lerTodos() : List<Compromisso> {
        return repository.findAll()
    }

    fun consultarPorTitulo(titulo : String) : List<Compromisso> {
        return repository.consultarPorTitulo( titulo )
    }

    fun apagar( id : Int, callback: RespostaCallback) {
        repository.deleteById( id )
        callback.resposta()
    }

    fun atualizar( id : Int, compromisso : Compromisso, callback: RespostaCallback) {
        val compromissoCopia = compromisso.copy(id = id)
        repository.save( compromissoCopia )
        callback.resposta()
    }
}