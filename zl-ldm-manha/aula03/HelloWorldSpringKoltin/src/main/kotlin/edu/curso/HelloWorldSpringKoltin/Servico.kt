package edu.curso.HelloWorldSpringKoltin

import org.springframework.stereotype.Service

@Service
class Servico(var aluno : Aluno) {
    fun gerarOla() : String {
        return "<h1>Hello World - ${aluno.nome}</h1>"
    }
    fun gerarAgendaContato() : String {
        return "<h1>AgendaContato - ${aluno.ra}</h1>"
    }
}