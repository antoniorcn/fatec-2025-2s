import pygame
import random

pygame.init()

tela = pygame.display.set_mode((1280, 800), 0, 32)

jogando = True
yellow = (255, 255, 0)

while jogando:
    # Calcular Regras
    x = random.randint(10, 1000)
    y = random.randint(10, 700)
    w = random.randint(10, 400)
    h = random.randint(10, 300)
    r = random.randint(0, 255)
    g = random.randint(0, 255)
    b = random.randint(0, 255)

    # Pintando na tela
    #              X   Y    Red  Green  Blue
    # tela.set_at( (50, 30), (255,  255,    0)  )

    #               Onde sera           Coordenadas     Coordenadas
    #               desenhado   cor      ponto 1         ponto 2    espessura
    # pygame.draw.line(tela,      yellow, (100, 300),     (500, 100),    3)
    

    #               Onde sera           Tupla de coordenadas
    #               desenhado   cor      Tupla pos (X, Y)  Tupla size (W, H)   espessura
    # pygame.draw.rect(tela,     yellow, (   (100, 100),       (500, 300)      ), 3 )
    pygame.draw.rect(tela, (r, g, b), ((x, y),(w, h)), 0 )
    pygame.display.update()

    # Capturando os eventos do usuário
    for evento in pygame.event.get():
        if evento.type == pygame.QUIT:
            jogando = False

print("Fim do jogo")



# input("Tecle <ENTER> para continuar")