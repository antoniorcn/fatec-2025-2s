"""
    Este módulo serve para testar o Hello World do Python
"""

def main():
    """ Este função é principal no nosso sistema
    todo este texto é ignorado pelo compilador
    """
    print("Hello World PLN")
    print("Esta é a linha 2 da função main")
    print("Esta é a linha 3 da função main")
    print("Fim da função main")
    # Aqui termina a função main

    a = 10
    b = 120 * a + 150 - a * 2 + 630 - 850 * 4 + 45 -100 / 5 *\
    32 + a * 15 -a * 90 / 100 + 50 - 30
    nomes = ['Joao', 'Marcelo', 'Samara', 'Jessica', 'Alvaro', 
             'Fernando', 'Maria', 'Cleusa'] 
    
    if b > 10:
        print("(b) é maior que (a)")
        print("(a) é menor que (b)")

    print("Integers (int)")
    print("ABS (-20) ->", abs(-20))

    print("Hexa (458) ->", hex(48))
    print("Oct (458) ->", oct(458))
    print("Str (458) ->", str(458))
    print("Float (458) ->", float(458))

    print("Floats")
    x = 3.15149
    print("X ==> ", x)
    print("int(x) ==> ", int(x))
    print("hexa (x) ==> ", x.hex())

    print("Strings")
    nome = "Joao Silva"
    print("Nome ==>", nome)
    print("Nome em maiusculo ==>", nome.upper())
    print("Nome em minusculo ==>", nome.lower())
    print("Nome ==>", nome)
    print("Len(nome) ==> ", len(nome))
    print("Find('a') ==>", nome.find('a'))
    print("Find('a', 3) ==>", nome.find('a', 3))

main()


