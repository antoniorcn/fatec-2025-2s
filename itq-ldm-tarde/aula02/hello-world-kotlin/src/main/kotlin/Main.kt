package edu.curso


fun imprimir(nome : String="Desconhecido",
             ra : String="000") {
    println("Nome: $nome")
    println("Ra: $ra")
}

data class Pessoa(
    var nome : String,
    val sobreNome : String
) {
    operator fun plus(outraPessoa : Pessoa) : Pessoa {
        val novoNome = "${this.nome} - ${outraPessoa.nome}"
        val novoSobreNome = "${this.sobreNome} - ${outraPessoa.sobreNome}"
        return Pessoa(nome=novoNome, sobreNome=novoSobreNome)
    }
}

fun String.multiplicar( quantidade : Int ) : String {
    var textoTotal = ""
    for (i in 1 .. quantidade) {
        textoTotal = textoTotal + this
    }
    return textoTotal
}

fun main() {
    println("Comparação de String")
    val s1 = "João"
    var s2 = "João"
    s2 = s2 + ""
    if (s1 == s2) {
        println("(s1) é igual a (s2)")
    } else {
        println("(s1) é diferente de (s2)")
    }

    println("Parametros com valores default")
    imprimir("Joao Silva")
    imprimir(ra="002", nome="Maria Silva")

    println("Classe de Dados")
    val p1 = Pessoa(nome="João", sobreNome="Silva")
    val p2 = Pessoa(nome="Maria", sobreNome="Santos")
    var p3 : Pessoa? = p1.copy(sobreNome="Santos")

    println("P1: $p1")
    println("P2: $p2")
    println("P3: $p3")

    if (p1 == p2) {
        println("(p1) é igual a (p2)")
    } else {
        println("(p1) é diferente de (p2)")
    }

    println("Sobreescrita de operadores (plus)")
    val p4 = p1 + p2
    println("Nova Pessoa p4 ==> $p4")

    println("Operador Elvis")
    p3 = null
    println("""P3 ==> ${p3 ?: "<Não definido>"} """)

    println("Funções de extensão")
    println( "*".multiplicar( 10 ))
    println( "João - ".multiplicar( 3 ))
}