def somar_numeros( numero1, numero2 ):
    somar = numero1 + numero2
    return somar


def multiplicar_numeros( num1, num2 ):
    multiplicacao = num1 * num2
    print( multiplicacao )
    return multiplicacao


m = multiplicar_numeros( 5, 4 )
print( "A multiplicacao deu ==> ", m )

s = somar_numeros(m, 100)
print( "A soma deu ==> ", s )


