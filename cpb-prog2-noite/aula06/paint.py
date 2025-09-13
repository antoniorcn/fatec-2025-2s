import pygame


def matriz_quadrada( tamanho : int ):
    matriz = [[(col + lin) % 2 for col in range( tamanho )] for lin in range( tamanho)]
    return matriz

def matriz_zeros( tamanho : int ):
    matriz = [[0 for _ in range( tamanho )] for _ in range( tamanho)]
    return matriz


pygame.init()

#        0    1
SIZE = (800, 600)
AMARELA = (255, 255, 0)
PRETO = (0, 0, 0)
TAMANHO = 160 

tela = pygame.display.set_mode( SIZE, pygame.RESIZABLE, 32 )

# matriz = matriz_quadrada( TAMANHO )
matriz = matriz_zeros( TAMANHO )
# matriz[0] = [0, 0, 0, 0, 1, 1, 1, 1]
rodando = True
while rodando:
    # Calculando Regras
    w = SIZE[0] / TAMANHO
    h = SIZE[1] / TAMANHO
    # Desenhar Tela

    for lin in range(TAMANHO):
        y = lin * h
        for col in range(TAMANHO):
            x = col * w
            cor = AMARELA if matriz[lin][col] == 1 else PRETO
            pygame.draw.rect( tela, cor, ( (x, y), (w, h) ), 0)
    pygame.display.update()

    # Capturar Eventos
    for evento in pygame.event.get():
        if evento.type == pygame.QUIT:
            rodando = False
        # elif evento.type == pygame.MOUSEMOTION:
            #print( evento )
        elif evento.type == pygame.MOUSEBUTTONDOWN or\
                (evento.type == pygame.MOUSEMOTION and\
                 evento.buttons[0] == 1):
            px, py = evento.pos
            coluna = int(px // w)
            linha = int(py // h)
            matriz[linha][coluna] = 1 if matriz[linha][coluna] == 0 else 0
            # print(evento)
        elif evento.type == pygame.VIDEORESIZE:
            SIZE = evento.size
        else:
            print(evento)

print("Fim do jogo")
