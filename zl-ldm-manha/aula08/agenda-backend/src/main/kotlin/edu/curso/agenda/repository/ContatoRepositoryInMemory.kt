package edu.curso.agenda.repository

import edu.curso.agenda.model.Contato
import org.springframework.stereotype.Component

@Component
class ContatoRepositoryInMemory {
    var indice : Int = 3
    val listaContatos : MutableList<Contato> = mutableListOf(
        Contato(id=1, nome="João Silva", telefone="(11) 1111", email="joao@teste.com"),
        Contato(id=2, nome="Maria Silva", telefone="(11) 2222", email="maria@teste.com"),
    )

    fun consultarTodos() : List<Contato> {
        return listaContatos
    }

    fun adicionar(contato : Contato) {
        contato.id = indice
        listaContatos.add(contato)
        indice++
    }

    fun remover(id : Int) {
        val listaFiltrada = listaContatos.filter{
            contato -> contato.id == id}
        listaContatos.removeAll( listaFiltrada )
    }

    fun atualizar(id : Int, contato: Contato) {
        for ( indice in 0..< listaContatos.size) {
            val c = listaContatos[indice]
            if (c.id == id) {
                listaContatos[indice] = contato.copy(id=id)
            }
        }
    }
}