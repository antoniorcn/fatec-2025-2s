import Box2D as b2
import pygame

pygame.init()
WIDTH = 800
HEIGHT = 600

PPM = 10  # Pixels por metro

screen = pygame.display.set_mode( (WIDTH, HEIGHT), 0, 32 )

mundo = b2.b2World( (0, -9.8), True )
print( "Mundo ==> ", mundo )

# Define as informações do corpo A
b_def = b2.b2BodyDef()
b_def.angle = 0
b_def.position = (25.0, 100.0)
b_def.type = b2.b2_dynamicBody

corpo_a = mundo.CreateBody( b_def )
shape_a = b2.b2PolygonShape( box=(1, 1) )

fixture_def = b2.b2FixtureDef()
fixture_def.shape = shape_a
fixture_def.restitution = 0.3
fixture_def.friction = 0.4
fixture_def.density = 20
fixture_a = corpo_a.CreateFixture( fixture_def )

# Define as informações do piso
b_def_piso = b2.b2BodyDef()
b_def_piso.angle = - 0.4
b_def_piso.position = (20.0, 10.0)
b_def_piso.type = b2.b2_staticBody

piso = mundo.CreateBody( b_def_piso )
shape_piso = b2.b2PolygonShape( box=(20, 2) )

fixture_piso_def = b2.b2FixtureDef()
fixture_piso_def.shape = shape_piso
fixture_piso_def.restitution = 0.3
fixture_piso_def.friction = 0.4
fixture_piso_def.density = 100
fixture_piso = piso.CreateFixture( fixture_piso_def )


jogando = True
while jogando:
    # Regras do jogo
    mundo.Step( 1/30, 8, 3 )
    print("Posicao do corpo ==> ", corpo_a.position )
    
    # Pintar o corpo
    retangulo_width = 2 * PPM
    retangulo_height = 2 * PPM
    retangulo_size = (retangulo_width, retangulo_height )
    retangulo_x = corpo_a.position[0] * PPM
    retangulo_y = HEIGHT - (corpo_a.position[1] * PPM)
    retangulo_pos = (retangulo_x, retangulo_y)

    # Pintar o piso
    piso_width = 40 * PPM
    piso_height = 4 * PPM
    piso_size = (piso_width, piso_height )
    piso_x = piso.position[0] * PPM
    piso_y = HEIGHT - (piso.position[1] * PPM)
    piso_pos = (piso_x, piso_y)

    screen.fill( (0, 0, 0) )
    # Desenha o corpo na tela
    pygame.draw.rect( screen, (255, 255, 0), (retangulo_pos, retangulo_size), 0)
    # Desenha o piso na tela
    pygame.draw.rect( screen, (0, 255, 0), (piso_pos, piso_size), 0)
    pygame.display.update()
    pygame.time.delay(40)

    # Capturar os eventos
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            jogando = False