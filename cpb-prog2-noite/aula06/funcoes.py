#   { nome: "Mario", vidas: 5, pontos: 50, fase: 1 }
#
#
#
#
#



def criar_personagem():
    personagem = {}
    personagem["nome"] = input("Digite o nome do personagem: ")
    personagem["vidas"] = int(input("Digite a quantidade de vidas: "))
    personagem["pontos"] = int(input("Digite quantos pontos ele já possui: "))
    personagem["fase"] = int(input("Digite o numero da fase que ele se encontra: "))
    print( personagem )


criar_personagem()

criar_personagem()