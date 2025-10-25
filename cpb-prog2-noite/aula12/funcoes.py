# Funções :
# São trechos de codigos reaproveitaveis
#
#
# Em uma de tela 800 x 600
# centro da tela 400, 300
# ao desenhar um retangulo de 200x100 centralizado
# na tela era preciso recalcular a posicao de inicio do
# retangulo

WIDTH = 800
HEIGHT = 600

centro_x = WIDTH // 2   # 800 // 2 ==> 400
centro_y = HEIGHT //2   # 600 // 2 ==> 300

def calcular_centro( retangulo_width, retangulo_height ):
    retangulo_x = centro_x - (retangulo_width // 2)
    retangulo_y = centro_y - (retangulo_height // 2)
    return retangulo_x, retangulo_y

print("Inicio do codigo")
print("Calculando a posicao X e Y do retangulo (A)")
ponto_retangulo_a = calcular_centro( 200, 100 )   # invocar a funcao
print("Valor retornado do x ==>", ponto_retangulo_a)

print("Calculando a posicao X e Y do retangulo (B)")
ponto_retangulo_b = calcular_centro( 300, 200 )
print("Valor retornado do x ==>", ponto_retangulo_b)

ponto_x, ponto_y = calcular_centro( 300, 200 )
print("Ponto X => ", ponto_x)
print("Ponto Y => ", ponto_y)
print("Fim do programa")

# retangulo_b_width = 300
# retangulo_b_height = 200
# retangulo_b_x = centro_x - (retangulo_b_width // 2)
# retangulo_b_y = centro_y - (retangulo_b_height // 2)