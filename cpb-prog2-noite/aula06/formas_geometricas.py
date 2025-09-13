# Crie uma função que mostre dados sobre formas geométricas
#   A função deve perguntar qual forma geometrica deve ser criada
#      (R)etangulo    (E)lipse    (L)inha
#   Para cada forma geométrica a função deve perguntar os dados
# necessários para desenhar a forma
#   (R) -> (x) e (y)  iniciais  (largura) e (altura)
#   (E) -> (x) e (y)  iniciais  (largura) e (altura)
#   (L) -> (x) e (y)  iniciais e (x) e (y) finais


def formas_geometricas(): 
    forma = input("""Qual tipo de forma geometrica você deseja
                  (R)etangulo
                  (E)lipse
                  (L)inha
                  Opção ==> """)
    if forma == "R":
        x = input("digite o valor de x inicial")
        y = input("digite o valor de y inicial")
        largura = input("digite o valor da largura")
        altura = input("digite o valor da altura")
        print(f"Retangulo( ({x}, {y}), ({largura}, {altura}) )")
    elif forma == "E":
        x = input("digite o valor de x inicial")
        y = input("digite o valor de y inicial")
        largura = input("digite o valor da largura")
        altura = input("digite o valor da altura")
        print(f"Elipse( ({x}, {y}), ({largura}, {altura}) )")
    elif forma == "L":
        x1 = input("digite o valor de x inicial")
        y1 = input("digite o valor de y inicial")
        x2 = input("digite o valor de x final")
        y2 = input("digite o valor de y final")
        print(f"Linha( ({x1}, {y1}), ({x2}, {y2}) )")



formas_geometricas()