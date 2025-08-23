# Atividade crie um jogo de dados, onde o computador ira sortear um numero 
# entre 1 e 6, e em seguida deverá perguntar ao usuário para que digite um numero
# e ira comparar o numero digitado com o numero sorteado, informando para o usuario
# se ele acertou

import random
numero_aleatorio = round((random.random() * 5) + 1)
print("Jogo de dados")
print("""    
    /$$$$$                                           /$$                       /$$                 /$$                    
   |__  $$                                          | $$                      | $$                | $$                    
      | $$  /$$$$$$   /$$$$$$   /$$$$$$         /$$$$$$$  /$$$$$$         /$$$$$$$  /$$$$$$   /$$$$$$$  /$$$$$$   /$$$$$$$
      | $$ /$$__  $$ /$$__  $$ /$$__  $$       /$$__  $$ /$$__  $$       /$$__  $$ |____  $$ /$$__  $$ /$$__  $$ /$$_____/
 /$$  | $$| $$  \ $$| $$  \ $$| $$  \ $$      | $$  | $$| $$$$$$$$      | $$  | $$  /$$$$$$$| $$  | $$| $$  \ $$|  $$$$$$ 
| $$  | $$| $$  | $$| $$  | $$| $$  | $$      | $$  | $$| $$_____/      | $$  | $$ /$$__  $$| $$  | $$| $$  | $$ \____  $$
|  $$$$$$/|  $$$$$$/|  $$$$$$$|  $$$$$$/      |  $$$$$$$|  $$$$$$$      |  $$$$$$$|  $$$$$$$|  $$$$$$$|  $$$$$$/ /$$$$$$$/
 \______/  \______/  \____  $$ \______/        \_______/ \_______/       \_______/ \_______/ \_______/ \______/ |_______/ 
                     /$$  \ $$                                                                                            
                    |  $$$$$$/                      +-------+   +-------+
                     \______/                       | o   o |   | o     |
                                                    |   o   |   |   o   |
                                                    | o   o |   |     o |
                                                    +-------+   +-------+                             
      """)
print("Digite um numero entre 1 e 6: ")
numero_texto = input()
numero = int( numero_texto )
acertou = numero == numero_aleatorio
print("O dado deu o numero -->", numero_aleatorio)
# if acertou:
#     print("Parabens você acertou")

# if not acertou:
#     print("Que pena você errou")

if acertou:
    print("Parabens você acertou")
else:
    print("Que pena você errou")