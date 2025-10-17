package edu.curso.agenda.repository

import edu.curso.agenda.model.Contato
import org.springframework.stereotype.Component


interface RespostaCallback {
    fun resposta (sucesso : Boolean = true, msg : String = "") : Unit
}


@Component
class ContatoRepositorioInMemory {
    var indiceContato = 1
    val lista : MutableList<Contato> = mutableListOf()

    fun adicionar( contato : Contato ) {
        contato.id = indiceContato
        lista.add( contato )
        indiceContato ++
    }

    fun lerTodos() : List<Contato> {
        return lista
    }

    fun apagar( id : Int, callback: RespostaCallback ) {
//        var indice = 0
//        while( indice < lista.size) {
//            val contato = lista[indice]
//            if (contato.id == id) {
//                lista.removeAt(indice)
//                break
//            }
//            indice++
//        }

//        for( indice in 0 ..<lista.size ) {
//            val contato = lista[indice]
//            if (contato.id == id) {
//                lista.removeAt(indice)
//                break
//            }
//        }
//        fun teste(b : ()->Unit) {
//            b()
//        }
//
//        teste {
//            println( "Teste ")
//        }

//        lista.forEach { contato -> run {
//            if (contato.id == id) {
//                lista.remove( contato )
//            }
//        } }

        val aRemover = lista.filter{
            contato -> contato.id == id
        }
        if (aRemover.size > 0) {
            lista.removeAll(aRemover)
            callback.resposta()
        } else {
            callback.resposta(false, "Id não encontrado")
        }
    }

    fun atualizar(id : Int, contato : Contato, callback : RespostaCallback) {
        var encontrado = false
        for( indice in 0 ..<lista.size ) {
            val c = lista[indice]
            if (c.id == id) {
                println("Contato encontrado")
                contato.id = id
                lista[indice] = contato
                println("Lista $lista")
                callback.resposta()
                encontrado = true
                break
            }
        }
        if (!encontrado) {
            callback.resposta(false, "Id não encontrado")
        }
    }

}