temperatura = 21
calor = temperatura > 28    # False
print("Calor:", calor)
chovendo = False
print("Chovendo:", chovendo)
print("Irei para a aula na terça-feira se estiver calor")
print("ou não estiver chovendo")
ir_aula = calor or not chovendo 
print("Ir para a aula =>", ir_aula)

# Irei para a aula na terça-feira se estiver calor
# ou não estiver chovendo

# Tabela verdade AND
# Situação  |  Entrada 1  |  Entrada 2  |  Saida
#     0     |    True     |    True     |   True
#     1     |    True     |    False    |   False
#     2     |    False    |    True     |   False
#     3     |    False    |    False    |   False


# Tabela verdade OR
# Situação  |  Entrada 1  |  Entrada 2  |  Saida
#     0     |    True     |    True     |   True
#     1     |    True     |    False    |   True
#     2     |    False    |    True     |   True
#     3     |    False    |    False    |   False

# Tabela verdade XOR (eXclusive OR)
# Situação  |  Entrada 1  |  Entrada 2  |  Saida
#     0     |    True     |    True     |   False
#     1     |    True     |    False    |   True
#     2     |    False    |    True     |   True
#     3     |    False    |    False    |   False

# Atividade:

# No jogo MineCraft, digamos que o personagem principal, 
# poderá produzir espada se ele tiver mais que 5 unidades de ferro
# E se tiver 5 unidades de madeira OU 5 unidades de arvore
# E se não estiver chovendo

print("Situação no jogo do MineCraft")
chovendo = False
ferro = 5
madeira = 20
arvore = 19

pode_produzir_espada = ferro >= 5 and (madeira >= 5 or\
    arvore >= 5) and not chovendo

print("""No jogo MineCraft, digamos que o personagem principal, 
poderá produzir espada se ele tiver mais que 5 unidades de ferro
E se tiver 5 unidades de madeira OU 5 unidades de arvore
E se não estiver chovendo""")
print("Arvore: ", arvore)
print("Madeira: ", madeira)
print("Ferro: ", ferro)
print("Chovendo: ", chovendo)
print("Pode produzir espada: ", pode_produzir_espada)