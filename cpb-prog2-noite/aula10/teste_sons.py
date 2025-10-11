import pygame

pygame.mixer.pre_init(frequency=44100, 
         size=-16, channels=2, 
         buffer=128, 
         allowedchanges=pygame.AUDIO_ALLOW_FREQUENCY_CHANGE)
pygame.init()

screen = pygame.display.set_mode( (800, 600), 0, 32 )
sound = pygame.mixer.Sound("./sons/colisao_arvore.mp3")

while True:
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()
        if e.type == pygame.MOUSEBUTTONDOWN:
            sound.set_volume(0.5)   # Now plays at 50% of full volume.
            channel = sound.play()      # Sound plays at full volume by default
            channel.set_volume(0.5) # Now plays at 25% (0.5 * 0.5).
