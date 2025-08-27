import random

random.seed(50)

numero_a_1 = random.random()
numero_a_2 = random.random()
numero_a_3 = random.random()
numero_a_4 = random.random()
numero_a_5 = random.random()

print(f"Numero aleatorio (1) => {numero_a_1}")
print(f"Numero aleatorio (2) => {numero_a_2}")
print(f"Numero aleatorio (3) => {numero_a_3}")
print(f"Numero aleatorio (4) => {numero_a_4}")
print(f"Numero aleatorio (5) => {numero_a_5}")


random.seed(0.4975365687586023)
numero_a_6 = random.random() # 0.2661737230725406
print(f"Numero aleatorio (6) => {numero_a_6}")

# Como transformar um numero que esta em uma escala
# entre 0 e 1 para um numero que esta em uma escala
# entre 0 e 50

numero_escala_1 = random.random()
numero_escala_50 = round(numero_escala_1 * 50)
print(f"Numero escala_1 => {numero_escala_1}")
print(f"Numero numero_escala_50 => {numero_escala_50}")

# Como transformar este numero que esta 
# em uma escala entre 0 e 1 para um 
# numero em uma escala entre 2 e 75

numero_escala_75 = round((numero_escala_1 * (75 - 2)) + 2)
print(f"Numero numero_escala_75 => {numero_escala_75}")

numero_aleatorio_inteiro_1 = random.randint(10, 90)
print(f"Numero numero_aleatorio_inteiro_1 => {numero_aleatorio_inteiro_1}")


numero_aleatorio_faixa_1 = random.randrange(1, 100, 5)
print(f"Numero numero_aleatorio_faixa_1 => {numero_aleatorio_faixa_1}")

lista_frutas = ["pera", "maca", "laranja", "banana", "uva", "ameixa"]
fruta_do_dia = random.choice(lista_frutas)
print(f"Fruta do dia => {fruta_do_dia}")