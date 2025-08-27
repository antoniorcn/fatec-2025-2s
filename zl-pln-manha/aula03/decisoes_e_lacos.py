i = 0  # Inicialização
print("Inicio do laço WHILE")
while i < 20:  # Condição
    print("I=> ", i)
    i = i + 1  # Incremento

    if i == 10:
        i = 11
        continue
    if i == 18:
        break
else:
    print("fim do laço while")

print("executa esta linha")
print("Fim do laço WHILE")


print("Inicio do laço FOR")
for i in range(0, 20, 1):
     print("I=> ", i)
else:
    print("else do laço FOR")

print("Fim do laço FOR")