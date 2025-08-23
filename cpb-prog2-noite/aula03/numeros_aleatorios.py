import random
# random.seed(15)
# numero_aleatorio = random.random()
# print("Numero Aleatorio ==> ", numero_aleatorio)
print("Numero Aleatorio 1 ==> ", random.random())
print("Numero Aleatorio 2 ==> ", random.random())
print("Numero Aleatorio 3 ==> ", random.random())
print("Numero Aleatorio 4 ==> ", random.random())
numero = random.random()
print("Numero gerado ==> ", numero)
numero_escala_50 = round(numero * 50)
print("Numero gerado em escala de 0 a 50 ==> ", numero_escala_50)
# Fazer uma rotina para gerar numeros aleatorios em uma escala
# de 1 a 6 e mostrá-los na tela, mostre ao menos 5 números 
# aleatórios gerados

numero = round((random.random() * 5) + 1)
print("Face do dado ==> ", numero)
