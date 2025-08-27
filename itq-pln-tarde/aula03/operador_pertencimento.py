lista_convidados = ["Joao", "Maria", "Jose", "Paula", "Pedro", "Camila"]

print("Lista de Convidados")
nome = input("Informe seu nome:")

# if nome in lista_convidados:
#     print("Você pode entrar, encontrei seu nome na lista")
# else:
#     print("Opa temos um problema, seu nome não está na lista")

if nome not in lista_convidados:
    print("Opa temos um problema, seu nome não está na lista")
else:
    print("Você pode entrar, encontrei seu nome na lista")
    
