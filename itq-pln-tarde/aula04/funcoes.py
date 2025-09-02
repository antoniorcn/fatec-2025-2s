

from typing import Tuple


# def somar_elevar( numero1 : int, numero2: int, potencia : int = 1) -> int:
#     soma : int = numero1 ** potencia + numero2 ** potencia
#     return soma

# soma_valores = somar_elevar(10, 20, 2)
# soma_valores : Tuple[int, int] = somar_elevar(10, 20, 2)
# print("Soma do valores: ", soma_valores)


# def somar_elevar( numero1 : int, numero2: int, potencia : int = 1) ->\
#     Tuple[int, int]:
#     """ESta é a documentação da função somar e elevar"""
#     soma : int = numero1 ** potencia + numero2 ** potencia
#     return soma, potencia

# soma, p = somar_elevar(10, 20, 2)

# print("Soma do valores: ", soma)
# print("Potencia: ", p)


# def fatorial( numero : int ) -> int:
#     if numero <= 2:
#         return 2
#     else:
#         return numero * fatorial( numero - 1)


# fat = fatorial( 900 )

# print("Fatorial 800! ==>", fat )
# 4! => 4 * 3!
# 3! => 3 * 2!
# 2! == 2


# def folha_pagamento1(salario : float) -> float:
#     print("Pagando o salario ==> ", salario)

# def folha_pagamento2(salario : float, vr : float) -> float:
#     print("Pagando o salario ==> ", salario + vr)

# folha_pagamento1( 1500.0 )
# folha_pagamento1( 1500.0, 400.0 )

# def folha_pagamento( *beneficios : float ) -> float:
#     soma = 0
#     for b in beneficios:
#         soma += b
#     return soma


# total = folha_pagamento( 1500.0, 300.0 )
# print("Total ==> ", total)

# def imprimir(salario : float, bonus: float, vr: float, vt:float) -> None:
#     print("salario => ", salario)
#     print("bonus => ", bonus)
#     print("vr => ", vr)
#     print("vt => ", vt)

def imprimir( **beneficios : Tuple[str, float]) -> None:
    for chave, valor in beneficios.items():
        print(chave, "==>", valor)


imprimir(salario=2000, bonus=500, vr=400, vt=200, plr=6000)
