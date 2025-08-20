calor = True
chovendo = False

# Se estiver calor e não estiver chovendo

# calor e não chovendo

# tomar_cerveja = calor e não chovendo
# tomar_cerveja = calor and not chovendo

tomar_cerveja = calor and not chovendo

# Tabela verdade (operador and)
#     | Entrada 1  | Entrada 2 | Saida
# 1   |    True    |    True   | True
# 2   |    True    |    False  | False
# 3   |    False   |    True   | False
# 4   |    False   |    False  | False


tomar_cerveja = calor or not chovendo

# Tabela verdade (operador or)
#     | Entrada 1  | Entrada 2 | Saida
# 1   |    True    |    True   | True
# 2   |    True    |    False  | True
# 3   |    False   |    True   | True
# 4   |    False   |    False  | False


tomar_cerveja = calor ^ (not chovendo)

# Tabela verdade (operador exclusive or)
#     | Entrada 1  | Entrada 2 | Saida
# 1   |    True    |    True   | False
# 2   |    True    |    False  | True
# 3   |    False   |    True   | True
# 4   |    False   |    False  | False