# tabuleiro = [
#     [0, 1, 0, 1, 0, 1, 0, 1],
#     [1, 0, 1, 0, 1, 0, 1, 0],
#     [0, 1, 0, 1, 0, 1, 0, 1],
#     [1, 0, 1, 0, 1, 0, 1, 0],
#     [0, 1, 0, 1, 0, 1, 0, 1],
#     [1, 0, 1, 0, 1, 0, 1, 0],
#     [0, 1, 0, 1, 0, 1, 0, 1],
#     [1, 0, 1, 0, 1, 0, 1, 0]
# ]


tabuleiro = []
numero = 0
for j in range(8):
    linha = []
    for i in range(8):
        linha.append( numero )
        if numero == 0:
            numero = 1
        else:
            numero = 0
    if numero == 0:
        numero = 1
    else:
        numero = 0
    tabuleiro.append(linha)


for i in range(8):
    print( tabuleiro[i] )