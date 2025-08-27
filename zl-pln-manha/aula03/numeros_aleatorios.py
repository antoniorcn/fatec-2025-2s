import random

random.seed(123)
a1 = random.random()
print("Numero aleatorio a1 =>", a1)
a2 = random.random()
print("Numero aleatorio a1 =>", a2)
a3 = random.random()
print("Numero aleatorio a1 =>", a3)

numero = random.random()
# Como transformar um numero que esta em uma escala
# entre 0 e 1 para um numero em uma escala entre 
# 0 e 30

numero_escala_30 = round(numero * 30)
print("Numero ==> ", numero)
print("Numero Escala 0 a 30 ==> ", numero_escala_30)

# Como transformar um numero que esta em uma escala
# entre 0 e 1 para um numero em uma escala entre 
# 5 e 65

# for i in range(30):
#     numero = random.random()
#     inicio = 5
#     termino = 65
#     amplitude = termino - inicio
#     numero_escala_65 = round((numero * amplitude) + inicio)
#     print("Numero ==> ", numero,
#           "  Numero Escala 5 a 65 ==> ", numero_escala_65)


# for i in range(30):
#     numero_escala_65 = random.randint(5, 65)
#     print("Numero Escala 5 a 65 ==> ", numero_escala_65)

# for i in range(30):
#     numero_escala_65 = random.randrange(6, 66, 2)
#     print("Numero Pares Escala 5 a 65 ==> ", numero_escala_65)

random.seed()

lista_frutas = ["maracuja", "uva", "morango", "ameixa",
                "banana", "laranja", "mexerica", 
                "kiwi"]
fruta_aleatoria = random.choice( lista_frutas ) 
print("Fruta Aleatoria ==> ", fruta_aleatoria)