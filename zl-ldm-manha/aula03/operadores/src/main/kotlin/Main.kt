package edu.curso

open class Pessoa {
    var nome : String = ""
    var idade : Int = 0
}

//class Aluno(ra : String, notas : Double) : Pessoa() {
//    var ra : String = ""
//    var notas : Double = 0.0
//    init {
//        this.ra = ra
//        this.notas = notas
//    }
//    override fun toString(): String {
//        return "RA:($ra) - Notas: $notas"
//    }
//}


data class Aluno(var ra : String, var notas : Double) : Pessoa()

sealed class MetodoPagamento(var valor : Double)
class CartaoCredito(valor : Double) : MetodoPagamento(valor)
class CartaoDebito(valor : Double) : MetodoPagamento(valor)
class Dinheiro(valor : Double) : MetodoPagamento(valor)
class Pix(valor : Double) : MetodoPagamento(valor)

fun main() {
    println("Operador In")
    val lista = listOf("Joao", "Maria", "Alberto")
    val alfredoInLista = "Alfredo" !in lista
    val joaoInLista = "Joao" !in lista
    println("Joao Fora da Lista ==> $joaoInLista")
    println("Alfredo Fora da Lista ==> $alfredoInLista")


    println("Operador Is")
    val p1 = Pessoa()
    val a1 = Aluno("11111", 6.0)
    val a2 = Aluno("11111", 6.0)
    val a3 = a1.copy(ra = "33333")

    val p2 : Pessoa = a1

    println("Aluno a1 é igual a Aluno a2 ? ==> ${a1 == a2}")
    println("Aluno a1 hashcode ==> ${a1.hashCode()}")
    println("Aluno a2 hashcode ==> ${a2.hashCode()}")
    println("Aluno a3 hashcode ==> ${a3.hashCode()}")

    val (ra1, notas2) = a1
    println("Dados do Aluno1 RA: $ra1 ")
    println("Dados do Aluno1 Notas: $notas2 ")

    println("Nome de P2 ==> ${p2.nome}")
    println("Idade de P2 ==> ${p2.idade}")

    if (p2 is Aluno) {
        println("Aluno ==> $p2")
        println("RA de P2 ==> ${p2.ra}")
        println("Notas de P2 ==> ${p2.notas}")
    }

    println("Sealed Classes")

    var metodo1 : MetodoPagamento = CartaoCredito(100.0)
    var taxa = 0.0
//    if (metodo1 is CartaoDebito) {
//        taxa = 0.05
//    } else if (metodo1 is CartaoCredito) {
//        taxa = 0.10
//    }


//    when (metodo1) {
//        is CartaoDebito -> {taxa = 0.05}
//        else -> {taxa = 0.0}
//    }

    taxa = when (metodo1) {
        is CartaoDebito -> 0.05
        is Boleto -> 0.02
        is CartaoCredito -> 0.10
        is Pix -> 0.01
        is Dinheiro -> 0.0
    }


}