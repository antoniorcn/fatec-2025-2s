package edu.curso

fun variaveis() {
    val a : UByte = 10u

    val c : Char = '\u0876'  // Guarda um caractere da tabela unicode
    val valorNumerico = c.code

    val s1 : String = "É muito legal estudar na Fatec Itaquera"

    for (i in 0 .. 8) {
        println("$i - ${s1[i]}")
    }
    var pos = 0
    while (pos != -1) {
        pos = s1.indexOf("a", pos + 1)
        println("(a) encontrado na posicao ==> $pos")
    }
}

fun pertencimento() {
    val lista = listOf(10, 20, 30, 40)

    if (50 !in lista) {
        println("O numero 50 não está na lista")
    } else {
        println("O numero 50 encontra-se na lista")
    }
}

fun identidade() {
//                Construtor Primario
    open class Pessoa(var nome : String, var idade : Int) {
        constructor() : this("",0) {
            println("Criando pessoa sem passar parametros")
        }
    }

    class Aluno(var ra : String, var notas : Double) : Pessoa() {
        constructor() : this("", 0.0)
//        var ra : String = ""
//        var notas : Double = 0.0
//
//        init {
//            this.ra = ra
//            this.notas = notas
//        }
    }

    val a1 = Aluno("2222", 7.0)
    val p1 = Pessoa("Joao Silva", 30)
    val p2 : Pessoa = Aluno("1111", 6.0)
    p2.nome = "Maria Silva"
    p2.idade = 25
    if (p2 is Aluno) {
        println("(p2) é do tipo Aluno")
        println("Nome: ${p2.nome}")
        println("Idade: ${p2.idade}")
        println("Ra: ${p2.ra}")
        println("Notas: ${p2.notas}")
    }
}

@OptIn(ExperimentalStdlibApi::class)
fun classes() {
//    open class Pessoa(var nome : String, var idade : Int) {
//        constructor() : this("",0) {
//            println("Criando pessoa sem passar parametros")
//        }
//
//        override fun hashCode(): Int {
//            return this.nome.hashCode()
//        }
//
//        override fun toString(): String {
//            return "Nome ==> ${this.nome} - Idade ==> ${this.idade}"
//        }
//    }

    data class Pessoa(var nome : String, var idade : Int)

    val p1 = Pessoa("Joao Silva", 30)
    val p2 = Pessoa("Joao Silva", 30)
     val p3 = p1.copy(nome = "Maria Silva")
//    val p3 = Pessoa("Maria Silva", 30)

    val (nome, idade) = p1
    println("Nome do p1 ==> $nome e sua idade é ==> $idade")
    println("Pessoa p1 ==> $p1")
    println("Hash code p1 ==>${p1.hashCode().toHexString()}")
    println("Pessoa p2 ==> $p2")
    println("Hash code p2 ==>${p2.hashCode().toHexString()}")
    println("Pessoa p3 ==> $p3")
    println("Hash code p3 ==>${p3.hashCode().toHexString()}")

    if (p1 == p2) {
        println("(p1) é igual a (p2)")
    } else {
        println("(p1) e (p2) são diferentes")
    }
}

fun main() {
    testeTipoPagamento()
}