package edu.curso

sealed class TipoPagamento(var valor : Double) {
    init {
        println("TipoPagamento instanciado")
    }
}

class Dinheiro(valor : Double) : TipoPagamento(valor)
class CartaoCredito(valor : Double) : TipoPagamento(valor)
class CartaoDebito(valor : Double) : TipoPagamento(valor)


fun testeTipoPagamento() {

    val t1 : TipoPagamento = CartaoCredito( 900.0 )

//    if (t1 is Dinheiro) {
//        println("Pagando com dinheiro")
//    } else if (t1 is CartaoDebito) {
//        println("Pagando com cartao de debito")
//    } else if (t1 is CartaoCredito) {
//        println("Pagando com cartao de credito")
//    }

//    when( t1 ) {
//        is Dinheiro -> println("Pagando com dinheiro")
//        is Boleto -> println("Pagando com boleto")
//        is CartaoCredito -> println("Pagando com cartao de credito")
//        is CartaoDebito -> println("Pagando com cartao de debito")
//        is Paypal -> println("Pagando com Paypal")
//        else -> println("Pagando de outra forma")
//    }

    println (when( t1 ) {
        is Dinheiro -> "Pagando com dinheiro"
        is Boleto -> "Pagando com boleto"
        is CartaoCredito -> "Pagando com cartao de credito"
        is CartaoDebito -> "Pagando com cartao de debito"
        is Paypal -> "Pagando com Paypal"
        else -> "Pagando de outra forma"
    })

}