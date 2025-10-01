package edu.curso.agenda.service

import edu.curso.agenda.model.Compromisso
import edu.curso.agenda.repository.CompromissoRepositoryInDB
import org.springframework.stereotype.Service

@Service
class CompromissoService(val repository : CompromissoRepositoryInDB) {

    fun consultarTodos() : List<Compromisso> {
        return repository.findAll()
    }

    fun consultarPorTitulo( titulo : String ) : List<Compromisso> {
        return repository.consultarPorTitulo( titulo )
    }

    fun adicionar(compromisso : Compromisso) {
        repository.save( compromisso )
    }

    fun remover(id : Int) {
        repository.deleteById( id )
    }

    fun atualizar(id : Int, compromisso : Compromisso) {
        val compromissoCopia = compromisso.copy(id = id)
        repository.save( compromissoCopia )
    }
}