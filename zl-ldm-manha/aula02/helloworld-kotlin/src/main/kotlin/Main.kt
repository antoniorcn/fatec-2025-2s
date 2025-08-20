package edu.curso

fun main() {
    var a = 10
    println("Hello World! pelo Visual Studio Code")

    System.out.println("Hello World feito com System.out.println Java")
    var c4 : Any? = null
    val c1 = Contato("Joao Silva", "1111-1111", "joao@teste.com")
    val c5 = Contato("Joao Silva", "1111-1111", "joao@teste.com")
    // c1.email = "joaosilva@teste.com"
    // c1.teste()
    println("Dados do Contato 1: $c1")
    val c2 = c1.copy(nome="Joao Silva Santos")
    println("Dados do Contato 2: $c2")

    var c3 : Contato? = c1.copy(nome="Jose Almeida")
    c4 = c3

    if (a > 5) {
        c3 = null
    }
    println("Contato c1: $c1")
    println("Contato c5: $c5")
    if (c1 == c5) {
        println("C1 e C5 são modelos iguais")
    } else {
        println("C1 e C5 são modelos diferentes")
    }

    if (c1 === c5) {
        println("C1 e C5 são a mesma instância")
    } else {
        println("C1 e C5 são instâncias diferentes")
    }


    println("""C3: ${c3?:"Nulo"}""")

    if (c3 != null) {
        c3.teste()
    } else {
        println("Objeto C3 é nulo")
    }

    if (c4 is Contato) {
        println("Contato c4: $c4")
        c4.teste(dizimo = 0.1)
        c4.teste("Nova Linha=>")
    }

    val c6 : Contato = c2 + c5
    println("Contato C6 => $c6")

    val c7 : Contato = c5 * 3
    println("Contato C7 => $c7")

    println("*".multiplicar(80))

}


fun String.multiplicar(numero : Int) : String {
    var somaTexto : String = ""
    for (i in 1 .. numero) {
        somaTexto += "$this "
    }
    return somaTexto
}


//class Contato {
//    var nome : String = ""
//    var telefone : String = ""
//    var email : String = ""
//}

data class Contato(
    val nome : String,
    var telefone : String,
    var email : String
) {
    private var teste : String = "Nome Completo:"


    fun teste(texto : String = "Linha=>", numero : Int = 10, dizimo : Double = 0.5) {
        println( "$texto ==> $teste $nome  total=${2+3}")
    }

    operator fun plus( outroContato : Contato ) : Contato {
        return Contato( nome="${this.nome} <-> ${outroContato.nome}",
            telefone="${this.telefone} <-> ${outroContato.telefone}",
            email="${this.email} <-> ${outroContato.email}")
    }

    operator fun times( numero : Int) : Contato {
        return Contato(nome=this.nome.multiplicar(numero),
            telefone=this.telefone.multiplicar(numero),
            email=this.email.multiplicar(numero))
    }
}