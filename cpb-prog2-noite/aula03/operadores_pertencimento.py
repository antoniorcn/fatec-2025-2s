mochila_link = ["espada", "ocarina", "escudo", "foto da zelda", 
                #"mascara",  
                "arco", "vaso", "vaso", "vaso"]

pode_ir = "ocarina" in mochila_link

perceptivel = "mascara" not in mochila_link

print("""O link esta em frente a um portal e podera ir para outra
      area do jogo se tiver a ocarina""")
print("O link pode ir para outra area ==> ", pode_ir)
print("O link esta perceptivel ==> ", perceptivel)