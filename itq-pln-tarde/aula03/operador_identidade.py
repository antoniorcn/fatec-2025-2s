class Aluno:
    nome : str
    def __init__(self, nome : str ):
        self.nome = nome

    def __str__(self):
        return self.nome


n1 = Aluno("Joao")
n2 = Aluno("Maria")

n3 = n2

print(f"(n2) => {n2}")
print(f"(n3) => {n3}")
if n3 is n2:
    print("(n3) e (n2) apontam para a mesma area de memoria")
else:
    print("(n3) e (n2) apontam para areas diferentes")

n2 = Aluno("Jose")
print(f"(n2) => {n2}")
print(f"(n3) => {n3}")
if n3 is n2:
    print("(n3) e (n2) apontam para a mesma area de memoria")
else:
    print("(n3) e (n2) apontam para areas diferentes")

n2 = Aluno("Maria")
print(f"(n2) => {n2}")
print(f"(n3) => {n3}")
if n3 is n2:
    print("(n3) e (n2) apontam para a mesma area de memoria")
else:
    print("(n3) e (n2) apontam para areas diferentes")