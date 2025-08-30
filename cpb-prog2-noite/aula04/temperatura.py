temperatura = 15   # 15 graus

if temperatura > 25:
    print("Esta calor")
else:
    if temperatura > 10:
        print("Esta agradável")
    else:
        print("Esta frio")

# Atividade, fazer um programa que mostre se a está:
# Frio quando a temperatura for menor igual a 10
# Calor quando a temperatura for maior que 25
# Agradável quando não for nenhuma das outras duas situações
#           Frio      |   Agradavel  |    Calor
# --------|-----------|---------|---------|----------|---------
#         0           10        20        30         40 
    
# calor = temperatura > 25
# frio = temperatura <= 25

# if temperatura <= 25:
#     print("Esta frio")
# else:
#     print("Esta calor")

# if temperatura > 25:
#     print("Esta calor")
# else:
#     if temperatura > 10:
#         print("Esta agradável")
#     else:
#         print("Esta frio")

# if temperatura > 25:
#     print("Esta calor")
# elif temperatura > 10:
#     print("Esta agradável")
# else:
#     print("Esta frio")

temperatura = 28

# Atividade fazer um programa para mostrar a situação térmica
# De acordo com as faixas abaixo:
# Temperatura maior que 33   ==> Muito Calor
# Temperatura entre 20 e 33  ==> Calor
# Temperatura entre 15 e 20  ==> Agradavel
# Temperatura entre 5 e 15   ==> Frio
# Temperatura abaixo de 5    ==> Muito

# if temperatura > 20 and temperatura <= 33:
# if 20 < temperatura <= 33:

# if temperatura > 33:
#     print("Esta muito calor")
# elif temperatura > 10:
#     print("Esta agradável")
# else:
#     print("Esta frio")

# Temperatura maior que 33   ==> Muito Calor
# Temperatura entre 20 e 33  ==> Calor
# Temperatura entre 15 e 20  ==> Agradavel
# Temperatura entre 5 e 15   ==> Frio
# Temperatura abaixo de 5    ==> Muito Frio


# if temperatura > 33:    # Maior que 33 até o inifinito positivo 
#     print("Muito Calor")
# else:  # Menor igual a 33 até o infinito negativo
#     if temperatura > 20:   # Entre 21 e 33
#         print("Calor")
#     else: # Menor igual a 20 até o infinito negativo
#         if temperatura > 15:  # Entre 16 e 20
#             print("Agradavel")
#         else: # Menor igual a 15 até o infinito negativo
#             if temperatura > 5: # Entre 6 e 15
#                 print("Frio")
#             else: # Menor igual a 5 até o infinito negativo
#                 print("Muito Frio")


if temperatura > 33:    # Maior que 33 até o inifinito positivo 
    print("Muito Calor")
elif temperatura > 20:   # Entre 21 e 33
    print("Calor")
elif temperatura > 15:  # Entre 16 e 20
    print("Agradavel")
elif temperatura > 5: # Entre 6 e 15
    print("Frio")
else: # Menor igual a 5 até o infinito negativo
    print("Muito Frio")
print("Fim")
print("do Programa")
