from random import randint

def matriz_10():
    matriz =  [ # [randint(0, 100), randint(0, 100), ...],
                # [...],
                # [randint(0, 100), randint(0, 100), ...],
            ]
    
    for j in range(10):
        linha = []
        for l in range(10):
            linha.append( randint(0, 100) )
        matriz.append(linha)

    for lin in matriz:
        print(lin)


def matriz_n( tam ):
    matriz =  [ # [randint(0, 100), randint(0, 100), ...],
                # [...],
                # [randint(0, 100), randint(0, 100), ...],
            ]   
    for j in range(tam):
        linha = []
        for l in range(tam):
            linha.append( randint(0, 100) )
        matriz.append(linha)

    for lin in matriz:
        print(lin)

# tamanho = int(input("Digite o tamanho da matriz: "))
# matriz_n( tamanho )


# def matriz_linhas_colunas( linhas, colunas ):
#     matriz =  [ # [randint(0, 100), randint(0, 100), ...],
#                 # [...],
#                 # [randint(0, 100), randint(0, 100), ...],
#             ]   
#     for j in range(linhas):
#         linha = []
#         for l in range(colunas):
#             linha.append( randint(0, 100) )
#         matriz.append(linha)
#     return matriz

# linhas = int(input("Digite a quantidade linhas: "))
# colunas = int(input("Digite a quantidade colunas: "))
# minha_matriz = matriz_linhas_colunas( linhas, colunas )
# for lin in minha_matriz:
#     print(lin)


# Atividade: 
# Modifique a função para criar matrizes quadradas de 
# qualquer tamanho


# Atividade:
# Crie uma função para gerar matrizes quadradas, 
# que deve receber o tamanho e deve gerar as celulas com 
# valores 0 e 1 alternadamente
# Exemplo:
# Matriz tamanho 5
# [  
#      0  1  2  3  4
# 0   [0, 1, 0, 1, 0],
# 1   [1, 0, 1, 0, 1],
# 2   [0, 1, 0, 1, 0],
# 3   [1, 0, 1, 0, 1],
# 4   [0, 1, 0, 1, 0],
# ]

def matriz_quadrada( tamanho : int ):
    matriz = [[(col + lin) % 2 for col in range( tamanho )] for lin in range( tamanho)]
    return matriz


# def matriz_quadrada( tamanho : int ):
#     matriz = []
#     valor = 0
#     for _ in range(tamanho):
#         linha = []
#         for _ in range(tamanho):
#             linha.append( valor )
#             valor = 1 if valor == 0 else 0
#             # if valor == 0:
#             #     valor = 1
#             # else:
#             #     valor = 0
#         matriz.append(linha)
#     return matriz



matriz_7 = matriz_quadrada( 8)

for linha in matriz_7:
    print( linha )