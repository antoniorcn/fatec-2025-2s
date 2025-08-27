#                  0           1           2           3          4
lista_tarefas = ["Estudar", "Dar aula", "Academia", "Almoço", "Descanso",
#                    5          6          7           
                 "Trabalhar", "Jantar", "Dormir"]

for tarefa in lista_tarefas:
    if tarefa == "Almoço":
        continue
    print( tarefa )
    if tarefa == "Trabalhar":
        break
else:
    print("Acabaram as tarefas")


print("Trabalhando com numeros:")

lista_numeros = range(1, 21, 3)
for numero in lista_numeros:
    print(numero)

print("Fim do programa")


