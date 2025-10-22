package edu.curso.agenda.service

import edu.curso.agenda.exception.APIException
import edu.curso.agenda.model.Usuario
import edu.curso.agenda.repository.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class UsuarioService(val repository : UsuarioRepository) {

    fun consultarPorEmail( email : String ) : Usuario? {
        try {
            return repository.findByEmail( email )
        } catch (e: Exception) {
            throw APIException(500, "Erro ao consultar o usuario pelo email",  e )
        }
    }

    fun adicionar(usuario : Usuario) {
        try {
            repository.save( usuario )
        } catch (e: Exception) {
            throw APIException(500, "Erro ao gravar o usuario",  e )
        }
    }
}