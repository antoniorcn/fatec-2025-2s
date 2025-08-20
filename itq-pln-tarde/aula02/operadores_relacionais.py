a = 10
b = 20

# Operadores relacionais resultam em expressões
# retornam True or False

resultado = a > b  # False
print("Resultado (a>b)==> ", resultado)
resultado = a == b  # False
print("Resultado (a==b)==> ", resultado)
resultado = a != b  # True
print("Resultado (a!=b)==> ", resultado)

temperatura = 19
calor = temperatura >= 20 # False
chover = False

tomarCervejaZero = calor and not chover
print("Operador And")
print("Temperatura ==> ", temperatura)
print("Calor ==> ", calor)
print("Chover ==> ", chover)
print("Tomar Cerveja Zero==> ", tomarCervejaZero)

tomarCervejaZero = calor or not chover
print("Operador Or")
print("Temperatura ==> ", temperatura)
print("Calor ==> ", calor)
print("Chover ==> ", chover)
print("Tomar Cerveja Zero==> ", tomarCervejaZero)
