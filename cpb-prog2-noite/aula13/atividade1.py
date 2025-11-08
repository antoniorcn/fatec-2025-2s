import Box2D as b2
import pygame

pygame.init()
WIDTH = 800
HEIGHT = 600
PPM = 10  # Pixels por metro


def desenhar_corpo(surface, corpo):
    for fixture in corpo.fixtures:
        if isinstance(fixture.shape, b2.b2CircleShape):
            raio = fixture.shape.radius * PPM
            centro = corpo.transform * fixture.shape.pos
            centro_tela = (centro[0] * PPM, HEIGHT - (centro[1] * PPM))
            pygame.draw.circle(surface, (255, 255, 0), centro_tela, raio)
        if isinstance(fixture.shape, b2.b2PolygonShape):
            tela_vertices = []
            for vertice in fixture.shape.vertices:
                vertice_transformado = corpo.transform * vertice
                vertice_tela = (vertice_transformado[0] * PPM,
                                HEIGHT - (vertice_transformado[1] * PPM))
                tela_vertices.append( vertice_tela )
            pygame.draw.polygon(surface, (255, 255, 0), tela_vertices, 0)

screen = pygame.display.set_mode( (WIDTH, HEIGHT), 0, 32 )

mundo = b2.b2World( (0, -9.8), True )

# Define as informações do corpo A
b_def = b2.b2BodyDef()
b_def.angle = 0
b_def.position = (1.0, 100.0)
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
b_def_piso.angle = -0.1
b_def_piso.position = (10.0, 30.0)
b_def_piso.type = b2.b2_staticBody

piso = mundo.CreateBody( b_def_piso )
shape_piso = b2.b2PolygonShape( box=(20, 0.5) )

fixture_piso_def = b2.b2FixtureDef()
fixture_piso_def.shape = shape_piso
fixture_piso_def.restitution = 0.3
fixture_piso_def.friction = 0.4
fixture_piso_def.density = 100
fixture_piso = piso.CreateFixture( fixture_piso_def )


# Define as informações do piso
b_def_piso2 = b2.b2BodyDef()
b_def_piso2.angle = 0.3
b_def_piso2.position = (50.0, 10.0)
b_def_piso2.type = b2.b2_staticBody

piso2 = mundo.CreateBody( b_def_piso2 )
shape_piso2 = b2.b2PolygonShape( box=(20, 0.5) )

fixture_piso_def2 = b2.b2FixtureDef()
fixture_piso_def2.shape = shape_piso2
fixture_piso_def2.restitution = 0.3
fixture_piso_def2.friction = 0.4
fixture_piso_def2.density = 100
fixture_piso2 = piso2.CreateFixture( fixture_piso_def2 )


jogando = True
while jogando:
    # Regras do jogo
    mundo.Step( 1/30, 8, 3 )
    # print("Posicao do corpo ==> ", corpo_a.position )
    # pygame.draw.polygon(screen, (255, 255, 0), [(600, 30), (550, 60), (650, 60)], 0)

    screen.fill( (0, 0, 0) )

    desenhar_corpo( screen, corpo_a )
    desenhar_corpo( screen, piso )
    desenhar_corpo( screen, piso2 )

    pygame.display.update()
    pygame.time.delay(5)

    # Capturar os eventos
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            jogando = False