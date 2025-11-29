# matriz_real = [
#     ["", "", "", "", "", "", "", ""],
#     ["", "", "", "", "", "", "", ""],
#     ["", "", "", "", "", "", "", ""],
#     ["", "", "", "", "", "", "", ""],
#     ["", "", "", "", "", "", "", ""],
#     ["", "", "", "", "", "", "", ""],
#     ["", "", "", "", "", "", "", ""],
#     ["", "", "", "", "", "", "", ""]
# ] 
import pygame
from random import randint

pygame.init()

matriz_real = [["" for i in range(8)] for _ in range(8)]
matriz_visivel = [["" for i in range(8)] for _ in range(8)]

LARGURA = 640
ALTURA = 480
pontos = 0
tentativas = 0
tela = pygame.display.set_mode( (LARGURA, ALTURA), 0, 32)
naves = [
    ("SUB", 1),
    ("DES", 3),
    ("POA", 5),
    ("CRU", 4),
    ("DES", 3)
]

def espalhar_naves():
    indice_nave = 0
    while indice_nave < len(naves): 
        nave = naves[indice_nave]
            # ("SUB", 1)
        linha = randint(0, 7)
        coluna = randint(0, 7)
        texto = nave[0]
        qtd = nave[1]
        if coluna + qtd < 8:
            for i in range(qtd):
                matriz_real[linha][coluna + i] = texto
            indice_nave += 1

def pinta_background():
    width = LARGURA / 8
    height = ALTURA / 8
    for lin in range(8):
        for col in range(8):
            x = width * col
            y = height * lin
            pygame.draw.rect( tela, (255, 255, 0), ((x, y), (width, height)), 2)

def pinta_visivel():
    renderizador = pygame.font.SysFont("arial", 16, False, False)
    width = LARGURA / 8
    height = ALTURA / 8
    for lin in range(8):
        for col in range(8):
            x = width * col
            y = height * lin
            texto = matriz_visivel[lin][col]
            img_texto = renderizador.render( texto, True, (255, 255, 0) )
            tela.blit(img_texto, (x, y))


def main():
    renderizador = pygame.font.SysFont("arial", 32, False, False)
    global matriz_visivel, pontos, tentativas
    jogando = True
    espalhar_naves()
    # matriz_visivel = matriz_real
    while jogando:
        tela.fill( (0, 0, 0) )
        pinta_background()
        pinta_visivel()
        texto = f"Tentativas: {tentativas}            Pontos: {pontos}"
        placar = renderizador.render(texto, True, (255, 255, 0))
        tela.blit( placar, (0, 0) )
        pygame.display.update()

        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                jogando = False
            if event.type == pygame.MOUSEBUTTONDOWN:
                print( event )
                x, y = event.pos
                width = LARGURA // 8
                height = ALTURA // 8
                col = x // width
                lin = y // height
                print(x, y, lin, col)
                if matriz_real[lin][col] != "":
                    pontos += 10
                    matriz_visivel[lin][col] = matriz_real[lin][col]
                else:
                    tentativas += 1



if __name__ == "__main__":
    main()

# def pinta_background():
#     distancia_hor = LARGURA / 8
#     distancia_ver = ALTURA / 8
#     for lin in range(8):
#         x = distancia_hor * lin
#         y1 = 0
#         y2 = ALTURA
#         pygame.draw.line(tela, (255, 255, 0) (x, y1), (x, y2), 2)
#     for col in range(8):
#         x1 = 0
#         x2 = LARGURA
#         y = distancia_ver * col
#         pygame.draw.line(tela, (255, 255, 0) (x1, y), (x2, y), 2)        

# matriz_real = [
#     ["", "CRU", "CRU", "CRU", "CRU", "", "", ""],
#     ["", "", "", "", "", "", "", ""],
#     ["", "DES", "DE", "DES", "", "SUB", "", ""],
#     ["", "", "", "", "", "", "", ""],
#     ["", "", "", "", "", "", "", ""],
#     ["", "", "DES", "DES", "DES", "", "", ""],
#     ["", "", "", "", "", "", "", ""],
#     ["POA", "POA", "POA", "POA", "POA", "", "", ""]
# ] 



# matriz_real = []
# for j in range(8):
#     matriz_real.append(["" for i in range(8)]) #  ["", "", "", "", "", "", "", ""]


# matriz_real = []
# for i in range(8):
#     vetor_linha = []
#     for coluna in range(8):
#         vetor_linha.append( "" )
#     matriz_real.append( vetor_linha )


# matriz_visivel = []
# for i in range(8):
#     vetor_linha = []
#     for coluna in range(8):
#         vetor_linha.append( "" )
#     matriz_visivel.append( vetor_linha )


