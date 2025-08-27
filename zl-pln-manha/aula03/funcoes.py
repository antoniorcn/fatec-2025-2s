def imprimir_lista_numeros(inicio : int=0,
                           termino: int=10) -> int:
    """Função para imprimir uma lista de numeros na tela"""
    print("Inicio da lista")
    for i in range(inicio , termino):
        print("I -> ", i)
    print("Termino da lista")
    return True, (termino - inicio)



sucesso1, qtd1 = imprimir_lista_numeros(termino=20, inicio=14)
sucesso1, qtd2 = imprimir_lista_numeros(termino=40)
sucesso1, qtd3 = imprimir_lista_numeros()

print(f"Foram impressos por ultimo {qtd3} valores")
