import pygame
import random

VERDE = (0, 255, 0)
MARROM = (100, 50, 50)
VERMELHO = (255, 0, 0)

pygame.init()
tela = pygame.display.set_mode( (800, 600), 0, 32 )
jogando = True

arvore = pygame.image.load("arvore.png").convert_alpha()
inimigo = pygame.image.load("inimigo.png").convert_alpha()
piso = pygame.image.load("piso.png").convert_alpha()


fase1 = []
for i in range(10):
    fase1.append(random.randint(0, 2))

# Fazer um laço para colocar 10 numeros sorteados dentro fase1

# fase1 = [2, 0, 1, 1, 0, 0, 1, 0, 2, 0, 2]

while jogando:
    # Calcular as regras

    for i in range( len(fase1) ):
        x = 50 * i
        if fase1[i] == 0:
            # pygame.draw.line(tela, VERDE, 
            #                  (x, 200), (x + 50, 200), 3)
            tela.blit(piso, (x, 200))
        elif fase1[i] == 1:
            # pygame.draw.rect(tela, MARROM, ((x, 100), (50, 100)), 3)            
            tela.blit(arvore, (x, 200 - 80))
        elif fase1[i] == 2:
            # pygame.draw.ellipse(tela, VERMELHO, ((x, 100), (50, 100)), 3)            
            tela.blit(inimigo, (x, 200 - 80))

    # Desenhar na tela 
    pygame.display.update()

    # Capturar os eventos do usuario
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            jogando = False

print("Jogo Encerrado")

