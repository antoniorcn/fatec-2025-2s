import pygame
from random import randint

pygame.mixer.pre_init(frequency=44100, 
         size=-16, channels=2, 
         buffer=64, 
         allowedchanges=pygame.AUDIO_ALLOW_FREQUENCY_CHANGE)

pygame.init()

fontRavie = pygame.font.Font("./fontes/RAVIE.TTF", 48)

snd_colisao_arvore = pygame.mixer.Sound("./sons/colisao_arvore.mp3")

print("Fontes do sistema: ", pygame.font.get_fonts())

WIDTH = 1280
HEIGHT = 800
LINHAS = 16
COLUNAS = 16
ITEMS = 20

tela = pygame.display.set_mode((WIDTH, HEIGHT), pygame.RESIZABLE, 32)

grama = pygame.image.load(".\\images\\grama.png")
arvore = pygame.image.load(".\\images\\arvore.png")
arbusto = pygame.image.load(".\\images\\arbusto.png")
inimigo = pygame.image.load(".\\images\\inimigo.png")
jorge = pygame.image.load(".\\images\\jorge.png")
image_width = WIDTH // COLUNAS
image_height = HEIGHT // LINHAS

grama_transformada = pygame.transform.scale( grama, (image_width, image_height) )
arvore_transformada = pygame.transform.scale( arvore, (image_width, image_height) )
arbusto_transformada = pygame.transform.scale( arbusto, (image_width, image_height) )
inimigo_transformada = pygame.transform.scale( inimigo, (image_width, image_height) )
jorge_transformado = pygame.transform.scale( jorge, (image_width, image_height) )

img_Titulo = fontRavie.render("Jorge Adventures", True, (255, 255, 0))

# Criando mapa
mapa = []
for lin in range(LINHAS):
    linha = []
    for col in range(COLUNAS):
        linha.append( 0 )
    mapa.append(linha)

for _ in range( ITEMS ):
    arvore_coluna = randint(0, COLUNAS - 1)
    arvore_linha = randint(0, LINHAS - 1)
    mapa[arvore_linha][arvore_coluna] = 1

for _ in range( ITEMS ):
    arbusto_coluna = randint(0, COLUNAS - 1)
    arbusto_linha = randint(0, LINHAS - 1)
    mapa[arbusto_linha][arbusto_coluna] = 2    

# inimigo_coluna = randint(0, COLUNAS - 1)
# inimigo_linha = randint(0, LINHAS - 1)
inimigo_coluna = 0
inimigo_linha = 0

jorge_coluna = COLUNAS - 1
jorge_linha = LINHAS - 1
jorge_coluna_antiga = jorge_coluna
jorge_linha_antiga = jorge_linha

jorge_hp = 5


inimigo_destino_coluna = jorge_coluna
inimigo_destino_linha = jorge_linha


# Loop do jogo
jogando = True
ciclo = 0
while jogando:
    # Calcular as regras
    if ciclo % 50 == 0:
        if inimigo_destino_coluna > inimigo_coluna:
            inimigo_coluna += 1
        
        if inimigo_destino_coluna < inimigo_coluna:
            inimigo_coluna -= 1

        if inimigo_destino_linha > inimigo_linha:
            inimigo_linha += 1

        if inimigo_destino_linha < inimigo_linha:
            inimigo_linha -= 1

    if inimigo_coluna == inimigo_destino_coluna and\
        inimigo_linha == inimigo_destino_linha:
        inimigo_destino_coluna = jorge_coluna
        inimigo_destino_linha = jorge_linha
        # inimigo_destino_coluna = randint(0, COLUNAS - 1)
        # inimigo_destino_linha = randint(0, LINHAS - 1)

    
    celula = mapa[jorge_linha][jorge_coluna]
    if celula == 1:       # Colisao com a arvore
        snd_colisao_arvore.play()
        jorge_coluna = jorge_coluna_antiga
        jorge_linha = jorge_linha_antiga
    elif celula == 2:     # Regra do arbusto
        jorge_hp = jorge_hp + 5
        mapa[jorge_linha][jorge_coluna] = 0

    if jorge_linha == inimigo_linha and jorge_coluna == inimigo_coluna:   # Regra do inimigo
        if jorge_hp > 50:
            jorge_hp -= 40
            print("Jorge matou o monstro")
        else:
            jorge_coluna = COLUNAS - 1
            jorge_linha = LINHAS - 1
            print("Jorge morreu")
        
    ciclo = ciclo + 1

    # Desenha na tela
    # print(f"Jorge HP: {jorge_hp}")

    # Camada 1
    for indice_linha, linha in enumerate(mapa):
        for indice_coluna, coluna in enumerate(linha):
            celula = mapa[indice_linha][indice_coluna]
            x = indice_coluna * image_width
            y = indice_linha * image_height
            tela.blit(grama_transformada, (x, y))
            if celula == 1:                
                tela.blit(arvore_transformada, (x, y))
            elif celula == 2:
                tela.blit(arbusto_transformada, (x, y))

    # Camada 2 ==> Inimigo
    ix = inimigo_coluna * image_width
    iy = inimigo_linha * image_height            
    tela.blit(inimigo_transformada, (ix, iy))

    # Camada 3 ==> Jorge
    jx = jorge_coluna * image_width
    jy = jorge_linha * image_height
    tela.blit(jorge_transformado, (jx, jy))
   
    tela.blit(img_Titulo, 
              ((WIDTH / 2) - img_Titulo.get_width() / 2, 0))

    img_hp = fontRavie.render(f"HP: {jorge_hp}", True, (255, 0, 0))
    tela.blit(img_hp, (WIDTH - img_hp.get_width() - 20, 0))

    pygame.display.update()


    # Capturar os eventos
    for evento in pygame.event.get():
        if evento.type == pygame.QUIT:
            jogando = False
        elif evento.type == pygame.WINDOWRESIZED:
            WIDTH = evento.x
            HEIGHT = evento.y
            image_width = evento.x // COLUNAS
            image_height = evento.y // LINHAS
            grama_transformada = pygame.transform.scale( grama, (image_width, image_height) )
            arvore_transformada = pygame.transform.scale( arvore, (image_width, image_height) )
            arbusto_transformada = pygame.transform.scale( arbusto, (image_width, image_height) )
            inimigo_transformada = pygame.transform.scale( inimigo, (image_width, image_height) )
            jorge_transformado = pygame.transform.scale( jorge, (image_width, image_height) )
        elif evento.type == pygame.KEYDOWN:
            # Constantes do Pygame Key
            # https://www.pygame.org/docs/ref/key.html#module-pygame.key
            if evento.key == pygame.K_d:
                jorge_linha_antiga = jorge_linha
                jorge_coluna_antiga = jorge_coluna
                jorge_coluna += 1
                if jorge_coluna > COLUNAS - 1:
                    jorge_coluna = 0                 
            if evento.key == pygame.K_a:
                jorge_linha_antiga = jorge_linha
                jorge_coluna_antiga = jorge_coluna
                jorge_coluna -= 1
                if jorge_coluna < 0:
                    jorge_coluna = COLUNAS - 1
            if evento.key == pygame.K_w:
                jorge_linha_antiga = jorge_linha
                jorge_coluna_antiga = jorge_coluna
                jorge_linha -= 1
                if jorge_linha < 0:
                    jorge_linha = LINHAS - 1
            if evento.key == pygame.K_s:
                jorge_linha_antiga = jorge_linha
                jorge_coluna_antiga = jorge_coluna
                jorge_linha += 1
                if jorge_linha > LINHAS - 1:
                    jorge_linha = 0                  



