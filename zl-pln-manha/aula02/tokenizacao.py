texto : str = """rato roeu a roupa do rei de Roma,
O rato roeu a roupa do rei da Rússia,
O rato roeu a roupa do RodovaIho...
O rato a roer roía
E a rosa Rita Ramalho do rato a roer se ria.
O rato roeu a roupa do rei de roma
a rainha com raiva roeu o resto."""

texto = texto.lower()
texto = texto.replace("\n", " ")

tokens = texto.split(" ")

print( "Texto Original ==> ", texto )
print( "Tokens ==> ", tokens )
