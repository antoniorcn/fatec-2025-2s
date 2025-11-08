import math
import Box2D as b2
import pygame

pygame.init()
WIDTH = 800
HEIGHT = 600
PPM = 10  # Pixels por metro


def desenhar_corpo_geometrico(surface, corpo):
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

def desenhar_corpo_imagem( surface, corpo, imagem ):
    corpo_fixtures = corpo.fixtures
    for corpo_fixture in corpo_fixtures:
        # print("Vertices: ", corpo_fixture.shape.vertices)
        y1 = corpo_fixture.shape.vertices[0][1]
        yultimo = corpo_fixture.shape.vertices[3][1]
        altura_imagem = yultimo - y1
        x2 = corpo_fixture.shape.vertices[1][0]
        x1 = corpo_fixture.shape.vertices[0][0]
        largura_imagem = x2 - x1
        altura_imagem_px = altura_imagem * PPM
        largura_imagem_px = largura_imagem * PPM
        imagem_scaled = pygame.transform.scale( imagem, (largura_imagem_px, altura_imagem_px) )
        corpo_rotation_degres = 180 * corpo.angle / math.pi
        imagem_rot = pygame.transform.rotate( imagem_scaled, corpo_rotation_degres)

        centro = corpo.position
        centro_corpo = (centro[0] * PPM, HEIGHT - (centro[1] * PPM))
        top_left_imagem = ( (centro_corpo[0] - imagem_rot.get_width() // 2), (centro_corpo[1] - imagem_rot.get_height() // 2) )
        surface.blit(imagem_rot, top_left_imagem)

screen = pygame.display.set_mode( (WIDTH, HEIGHT), 0, 32 )
cofre = pygame.image.load("./images/cofre.png").convert_alpha()

mundo = b2.b2World( (0, -9.8), True )

# Define as informações do corpo A
b_def = b2.b2BodyDef()
b_def.angle = 0
b_def.position = (5.0, 100.0)
b_def.type = b2.b2_dynamicBody

corpo_a = mundo.CreateBody( b_def )
shape_a = b2.b2PolygonShape( box=(3, 3) )

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
    # Largura = X do 2º vértice – X do 1º vertice
    # Altura = Y do ultimo vértice – Y do 1º vertice

    #        0            1            2           3
    # [(-1.0, -1.0), (1.0, -1.0), (1.0, 1.0), (-1.0, 1.0)]
    #
    #     0    1
    #  (-1.0, 1.0)

    # corpo_fixtures = corpo_a.fixtures
    # for corpo_fixture in corpo_fixtures:
    #     # print("Vertices: ", corpo_fixture.shape.vertices)
    #     y1 = corpo_fixture.shape.vertices[0][1]
    #     yultimo = corpo_fixture.shape.vertices[3][1]
    #     altura_imagem = yultimo - y1
    #     x2 = corpo_fixture.shape.vertices[1][0]
    #     x1 = corpo_fixture.shape.vertices[0][0]
    #     largura_imagem = x2 - x1
    #     altura_imagem_px = altura_imagem * PPM
    #     largura_imagem_px = largura_imagem * PPM
    #     cofre_image = pygame.transform.scale( cofre, (largura_imagem_px, altura_imagem_px) )
    #     corpo_rotation_degres = 180 * corpo_a.angle / math.pi
    #     cofre_image_rot = pygame.transform.rotate( cofre_image, corpo_rotation_degres)

    #     centro = corpo_a.position
    #     centro_corpo = (centro[0] * PPM, HEIGHT - (centro[1] * PPM))
    #     top_left_imagem = ( (centro_corpo[0] - cofre_image_rot.get_width() // 2), (centro_corpo[1] - cofre_image_rot.get_height() // 2) )
    #     screen.blit(cofre_image_rot, top_left_imagem)
        # for vertice in corpo_fixture.shape.vertices:
        #     vertice_transformado = corpo_a.transform * vertice
        #     vertice_tela = (vertice_transformado[0] * PPM,
        #                     HEIGHT - (vertice_transformado[1] * PPM))
        # tela_vertices.append( vertice_tela )

    desenhar_corpo_imagem( screen, corpo_a, cofre )

    # desenhar_corpo_geometrico( screen, corpo_a )
    desenhar_corpo_geometrico( screen, piso )
    desenhar_corpo_geometrico( screen, piso2 )

    pygame.display.update()
    pygame.time.delay(50)

    # Capturar os eventos
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            jogando = False