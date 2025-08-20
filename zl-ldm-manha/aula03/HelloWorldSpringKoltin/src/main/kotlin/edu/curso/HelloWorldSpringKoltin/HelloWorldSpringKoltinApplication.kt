package edu.curso.HelloWorldSpringKoltin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class HelloWorldSpringKoltinApplication {
	@Bean
	fun gerarAluno() : Aluno {
		return Aluno("Joao Silva", "11111")
	}
}

data class Aluno(var nome : String, var ra : String) {

}

fun main(args: Array<String>) {
	runApplication<HelloWorldSpringKoltinApplication>(*args)
}
