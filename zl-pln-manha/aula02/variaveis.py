from typing import Union


a : int = -20

print("Numeros inteiros")
print("a ==>", a )
print("abs(a) ==>", abs(a) )
print("hex(a) ==>", hex(a) )
print("oct(a) ==>", oct(a) )
print("str(a) ==>", str(a) )
print("float(a) ==>", float(a) )

print("Teste de comportamento")
def relatorio( valor : int ):
    print("Relatorio")
    print("valor final ==> " + str(valor * 3))
relatorio( "4" )

print("Numeros float")
c : float = -4.5
print("c ==> ", c)
print("str(c) ==> ", str(c))
print("int(c) ==> ", int(c))
print("abs(c) ==> ", abs(c))
print("hex(c) ==> ", c.hex())

print("Strings")
# indices  0123456789
d : str = "João Silva"
print("d ==> " + d)
print("len(d) ==> ", len(d))
print("d.upper() ==> " + d.upper())
print("d.lower() ==> " + d.lower())
print("d.find('s') ==> ", d.find("s"))
print("d.find('S') ==> ", d.find("S"))
print("d.find('o', 2) ==> ", d.find("o", 2))
