import random 
text1 = "Processamento de Linguagem Natural"
lista1 = list( text1 )
print("Lista de Letras ==>", lista1)

print("Lista de numeros")
lista2 = list(range(5, 66))
print("Lista de Numeros ==>", lista2)



print("Lista de numeros aleatorios gerados com for")
lista3 = [random.randint(10, 20) for i in range(20)]
print("Lista de Numeros aleatorios ==>", lista3)

print("3 primeiros numeros da lista3 ==> ", lista3[0:3])
print("3 ultimos numeros da lista3 ==> ", lista3[17:20])
print("numeros da lista3 em indices pares ==> ", 
      lista3[0:20:2])

print("numeros da lista3 em indices pares na ordem inversa ==> ", 
      lista3[19:0:-2])

print("numeros da lista3 em ordem inversa ==> ",
      lista3[::-1])

lista_frutas = ["maca", "abacaxi", "laranja"]
print("Lista de frutas => ", lista_frutas)
lista_frutas.append("goiaba")
print("Lista de frutas => ", lista_frutas)
lista_frutas.extend(["uva", "pera", "laranja", "morango"])
print("Lista de frutas => ", lista_frutas)

print("Removido o elemento=>", lista_frutas.pop())
print("Lista de frutas => ", lista_frutas)
print("Count 'goiaba' na lista de frutas => ", 
      lista_frutas.count("goiaba"))
print("Count 'laranja' na lista de frutas => ", 
      lista_frutas.count("laranja"))

print("lista[2] e a mesma instancia de lista[6]=>", 
      lista_frutas[2] is lista_frutas[6])
