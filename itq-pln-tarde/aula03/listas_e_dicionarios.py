#                  0           1           2           3          4
from typing import List


lista_tarefas = ["Estudar", "Dar aula", "Academia", "Almoço", "Descanso",
#                    5          6          7
                 "Trabalhar", "Jantar", "Dormir"]


print( lista_tarefas[-1] )
print( lista_tarefas[1:7:2] )

# Criar uma lista com todos os numeros pares entre 0 e 20 (inclusive)
# numeros_pares = []
# for i in range(21):
#     if i % 2 == 0:
#         numeros_pares.append( i )
# print( "Numeros Pares: ", numeros_pares)

# numeros_pares : List[int] = [i for i in range(0, 21, 2)]
numeros_pares : List[int] = list(range(0, 21, 2))
ultimo_elemento = numeros_pares.pop(-1)
numeros_pares.extend( [22, 24, 26] )
print("Ultimo elemento removido :", ultimo_elemento)
print( "Numeros Pares: ", numeros_pares)
print( "Numeros Pares invertida: ", numeros_pares[::-1])

#     0     1    2      3     4
# ["4.5M", 255, 1600, 15800, 0.3]

dicionario_executivo = { "faturamento_anual" : "4.5M", "dias_trabalhados": 255,
                        "salario_minimo": 1600, "salario_maximo": 15800,
                        "ultimo_bonus": 0.3 }

print("Salario Maximo ==> ", dicionario_executivo["salario_maximo"])
print("Porcentagem Ultimo Bonus ==> ", dicionario_executivo["ultimo_bonus"])

for chave in dicionario_executivo.keys():
    print("Chave: ", chave)


for valor in dicionario_executivo.values():
    print("Valor: ", valor)


for item in dicionario_executivo.items():
    print("Tupla Chave e Valor: ", item)

# print("Buscando media de salarios: ", dicionario_executivo["media"])
# Retorna exception
print("Buscando media de salarios: ", dicionario_executivo.get("media", 0.0))