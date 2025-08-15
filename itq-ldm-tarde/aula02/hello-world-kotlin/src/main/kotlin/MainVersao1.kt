package edu.curso

import kotlin.random.Random

class Aluno() {
    var nome : String = ""
    get() = "($field)"
    set(value) {
        if (value != "") {
            field = value
        }
    }

    var ra : String = ""

    override fun toString(): String {
        return "RA: ${this.ra} - Nome: ${this.nome}"
    }
}

fun main() {
    var rnd = Random.Default
    val a = 10;
    var a1 = Aluno()
    a1.nome = "João"
    a1.ra = "00001"
    println("Aluno a1 => $a1")


    var s1 : String
    s1 = "Texto"
    s1 = "Outro Texto"
//    if (rnd.nextInt() % 2 == 0) {
//        s1 = null
//    }

    var x : Any


    if (rnd.nextInt() % 2 == 0) {
        x = s1
    } else {
        x = a1
    }

    if (x is String) {
        println("X em maisculo: ${x.uppercase()}")
    }

    if (x is Aluno) {
        println("X como Aluno => Nome: ${x.nome}")
    }



    println("Valor de a: $a")
    System.out.println("Println feito com Java")
//    if (s1 != null) {
//        println("Valor de s1 em minusculo: ${s1.lowercase()} ")
//    }

    println("Valor de s1 em minusculo: ${s1?.lowercase()?.uppercase()} ")

    /* Modificador para garantir que o valor não será nulo, pode
    produzir null pointer exception se o valor da variavel for nulo
    */
    // println("Valor de s1 em minusculo: ${s1!!.lowercase()} ")

    /*
        Modificador que transforma a sentenca em nulo caso a variavel
        seja nula, sem gerar exception
     */
    // println("Valor de s1 em minusculo: ${s1?.lowercase().uppercase()} ")

}