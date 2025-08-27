#                     0       1   2      3      4
# lista_executiva = [6459873, 900, 2000, 25000, 540000]
# print("Faturamento => ", lista_executiva[0])
# print("Impostos => ", lista_executiva[4])

#                            chave       valor
dicionario_executivo = {"faturamento": 6459873,
                        "funcionarios": 900,
                        "salario_minimo": 2000,
                        "salario_maximo": 25000,
                        "impostos": 540000,
                        "presidencia": ["Alberto", "Marta"] } 

# print("Salario Minimo na empresa ==>")
# print(dicionario_executivo["salario"])

print("Salario Minimo na empresa ==>")
print(dicionario_executivo.get("salario_minimo", 0.0))

print("Dicionario executivo  ==> ", dicionario_executivo)

print("Chaves Dicionario executivo  ==> ",
      dicionario_executivo.keys())

print("Valores Dicionario executivo  ==> ",
      dicionario_executivo.values())

print("Tuplas com Chave e Valor Dicionario executivo  ==> ",
      dicionario_executivo.items())