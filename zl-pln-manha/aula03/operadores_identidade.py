class Aluno:
    def __init__(self, nome : str):
        self.nome = nome
    def __str__(self):
        return self.nome
    def __hash__(self):
        return self.nome.__hash__()

s1 = Aluno("Joao")
s2 = Aluno("Maria")
s3 = s1
s4 = s2

print("(s1) ==> ", s1)
print("(s1).__hash__() ==> ", s1.__hash__())
print("(s2) ==> ", s2)
print("(s2).__hash__() ==> ", s2.__hash__())
print("(s3) ==> ", s3)
print("(s3).__hash__() ==> ", s3.__hash__())

s1_is_s2 = s1 is s2
print("(s1) e (s2) são a mesma instância ? =>", s1_is_s2)

s2_is_s3 = s2 is s3
print("(s2) e (s3) são a mesma instância ? =>", s2_is_s3)

s1_is_s3 = s1 is s3
print("(s1) e (s3) são a mesma instância ? =>", s1_is_s3)