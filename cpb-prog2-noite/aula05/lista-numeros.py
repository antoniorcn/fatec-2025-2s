# numeros = []
# i = 0
# while i < 500:
#     numeros.append( i )
#     i = i + 1

# print( numeros )


# impares = []
# for i in range(39, 78, 2):
#     impares.append( i )
# print(impares)

# impares = list( range(39, 78, 2)  )
# print(impares)

# texto = "Eu gosto de Programacao"
# letras = list( texto )
# print( letras )


# pares = [i for i in range(100, 19, -2)]

# pares = list(range(100, 19, -2))

# pares = []
# for i in range(100, 19, -2):
#     pares.append( i )

pares = []
i = 100
while i >= 20:
    pares.append(i)
    i = i -2   # i -= 2

print(pares)
