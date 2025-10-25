import pygame
# from funcoes import calcular_centro

WIDTH = 800
HEIGHT = 600
centro_x = WIDTH // 2
centro_y = HEIGHT // 2

def calcular_centro( retangulo_width, retangulo_height ):
    retangulo_x = centro_x - (retangulo_width // 2)
    retangulo_y = centro_y - (retangulo_height // 2)
    return retangulo_x, retangulo_y

pygame.init()

screen = pygame.display.set_mode( (WIDTH, HEIGHT), 0, 32 )

jogando = True

while jogando:

    canto_esquerdo_retangulo = calcular_centro( 200, 100 )
   
    pygame.draw.rect( screen, (255, 255, 0), ( canto_esquerdo_retangulo, (200, 100) ), 5, 10 )

    canto_esquerdo_retangulo = calcular_centro( 300, 150 )
    pygame.draw.rect( screen, (255, 0, 0), ( canto_esquerdo_retangulo, (300, 150) ), 5, 10 )

    canto_esquerdo_retangulo = calcular_centro( 400, 200 )
    pygame.draw.rect( screen, (0, 0, 255), ( canto_esquerdo_retangulo, (400, 200) ), 5, 10 )
    pygame.display.update()

    for evento in pygame.event.get():
        if evento.type == pygame.QUIT:
            jogando = False

print("Fim do jogo")