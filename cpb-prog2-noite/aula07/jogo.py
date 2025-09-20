import pygame
from random import randint

pygame.init()

WIDTH = 800
HEIGHT = 600

tela = pygame.display.set_mode((WIDTH, HEIGHT), pygame.RESIZABLE, 32)

grama = pygame.image.load(".\\images\\grama.png")
arvore = pygame.image.load(".\\images\\arvore.png")
arbusto = pygame.image.load(".\\images\\arbusto.png")
inimigo = pygame.image.load(".\\images\\inimigo.png")
jorge = pygame.image.load(".\\images\\jorge.png")
image_width = WIDTH // 16
image_height = HEIGHT // 16

grama_transformada = pygame.transform.scale( grama, (image_width, image_height) )
arvore_transformada = pygame.transform.scale( arvore, (image_width, image_height) )
arbusto_transformada = pygame.transform.scale( arbusto, (image_width, image_height) )
inimigo_transformada = pygame.transform.scale( inimigo, (image_width, image_height) )
jorge_transformado = pygame.transform.scale( jorge, (image_width, image_height) )

# Criar lista do mapa do jogo
# mapa = [
#     [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
#     [0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
#     [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1],
#     [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1],
#     [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0],
#     [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
#     [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
#     [0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
#     [0, 2, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
#     [0, 2, 0, 3, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
#     [0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
#     [0, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
#     [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
#     [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
#     [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
#     [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
# ] 


# Criando mapa
mapa = []
for lin in range(16):
    linha = []
    for col in range(16):
        linha.append( 0 )
    mapa.append(linha)

for _ in range( 15 ):
    arvore_coluna = randint(0, 15)
    arvore_linha = randint(0, 15)
    mapa[arvore_linha][arvore_coluna] = 1

for _ in range( 15 ):
    arbusto_coluna = randint(0, 15)
    arbusto_linha = randint(0, 15)
    mapa[arbusto_linha][arbusto_coluna] = 2    

inimigo_coluna = randint(0, 15)
inimigo_linha = randint(0, 15)
mapa[inimigo_linha][inimigo_coluna] = 3

jorge_coluna = randint(0, 15)
jorge_linha = randint(0, 15)

jorge_hp = 5


# Loop do jogo
jogando = True
while jogando:
    # Calcular as regras

    
    celula = mapa[jorge_linha][jorge_coluna]
    if celula == 2:     # Regra do arbusto
        jorge_hp = jorge_hp + 5
        mapa[jorge_linha][jorge_coluna] = 0
    elif celula == 3:   # Regra do inimigo
        if jorge_hp > 50:
            jorge_hp -= 40
            mapa[jorge_linha][jorge_coluna] = 0
            print("Jorge matou o monstro")
        else:
            jorge_coluna = 20
            jorge_linha = 20
            print("Jorge morreu")
        

    # Desenha na tela
    print(f"Jorge HP: {jorge_hp}")

    # Camada 1
    for indice_linha, linha in enumerate(mapa):
        for indice_coluna, coluna in enumerate(linha):
            celula = mapa[indice_linha][indice_coluna]
            x = indice_coluna * image_width
            y = indice_linha * image_height
            if celula == 0:
                tela.blit(grama_transformada, (x, y))
            elif celula == 1:                
                tela.blit(grama_transformada, (x, y))
                tela.blit(arvore_transformada, (x, y))
            elif celula == 2:
                tela.blit(grama_transformada, (x, y))
                tela.blit(arbusto_transformada, (x, y))
            elif celula == 3:
                tela.blit(grama_transformada, (x, y))
                tela.blit(inimigo_transformada, (x, y))

    # Camada 2
    jx = jorge_coluna * image_width
    jy = jorge_linha * image_height
    tela.blit(jorge_transformado, (jx, jy))


    
    pygame.display.update()



    # Capturar os eventos
    for evento in pygame.event.get():
        if evento.type == pygame.QUIT:
            jogando = False
        elif evento.type == pygame.WINDOWRESIZED:
            image_width = evento.x // 16
            image_height = evento.y // 16
            grama_transformada = pygame.transform.scale( grama, (image_width, image_height) )
            arvore_transformada = pygame.transform.scale( arvore, (image_width, image_height) )
            arbusto_transformada = pygame.transform.scale( arbusto, (image_width, image_height) )
            inimigo_transformada = pygame.transform.scale( inimigo, (image_width, image_height) )
            jorge_transformado = pygame.transform.scale( jorge, (image_width, image_height) )
        elif evento.type == pygame.KEYDOWN:
            # Constantes do Pygame Key
            # https://www.pygame.org/docs/ref/key.html#module-pygame.key
            if evento.key == pygame.K_d:
                jorge_coluna += 1
            if evento.key == pygame.K_a:
                jorge_coluna -= 1
            if evento.key == pygame.K_w:
                jorge_linha -= 1
            if evento.key == pygame.K_s:
                jorge_linha += 1


