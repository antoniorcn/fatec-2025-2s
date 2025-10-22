package edu.curso.agenda.service

import edu.curso.agenda.exception.APIException
import edu.curso.agenda.model.Contato
import edu.curso.agenda.repository.ContatoRepositoryInDB
import org.springframework.stereotype.Service
import java.util.*

@Service
class ContatoService(val repository : ContatoRepositoryInDB) {

    fun consultarTodos() : List<Contato> {
        try {
            return repository.findAll()
        } catch (e: Exception) {
            throw APIException(500, "Erro ao carregar os dados do contato",  e )
        }
    }

    fun consultarPorNome( nome : String ) : List<Contato> {
        try {
            return repository.consultarPorNome( nome )
        } catch (e: Exception) {
            throw APIException(500, "Erro ao consulta o contato pelo nome",  e )
        }
    }

    fun adicionar(contato : Contato) {
        try {
            repository.save( contato )
        } catch (e: Exception) {
            throw APIException(500, "Erro ao gravar o contato",  e )
        }
    }

    fun remover(id : Int) {
        try {
            repository.deleteById( id )
        } catch (e: Exception) {
            throw APIException(500, "Erro ao remover o contato",  e )
        }
    }

    fun atualizar(id : Int, contato : Contato) {
        try {
            val contatoCopia = contato.copy(id = id)
            repository.save( contatoCopia )
        } catch (e: Exception) {
            throw APIException(500, "Erro ao atualizar o contato",  e )
        }
    }

    fun localizarPorId( id : Int ) : Optional<Contato> {
        try {
            return repository.findById( id )
        } catch (e: Exception) {
            throw APIException(500, "Erro ao localizar o contato pelo ID",  e )
        }
    }
}