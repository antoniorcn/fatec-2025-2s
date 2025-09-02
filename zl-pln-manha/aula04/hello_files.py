# arquivo = open("c:\\temp\\arquivo.txt", "r", encoding="utf-8")

# c:\temp\arquivo.txt
# for i in range(10):
#     letra = arquivo.read(1)  # "" 
#     print(letra)

# letra = " "
# texto = ""
# while letra != "":
#     letra = arquivo.read(1)
#     texto = texto + letra

# print("Texto ==> ", texto)

# arquivo = open("c:\\temp\\arquivo.txt", "w", encoding="utf-8")
# arquivo.write("Linha 1\n")
# arquivo.write("Linha 2\n")
# arquivo.write("Linha 3\n")
# arquivo.flush()
# input()
# arquivo.write("Linha 4\n")
# arquivo.write("Linha 5\n")
# arquivo.close()

with open("c:\\temp\\arquivo.txt", "w", encoding="utf-8") as arquivo:
    arquivo.write("Linha 1\n")
    arquivo.write("Linha 2\n")
    arquivo.write("Linha 3\n")
    arquivo.flush()
    arquivo.write("Linha 4\n")
    arquivo.write("Linha 5\n")

print("O arquivo está fechado")
