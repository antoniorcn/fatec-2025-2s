a = "texto1"
b = "texto2"

c = b
print("(c) e (b) são a mesma coisa=>", c is b)
print("(a) e (b) são a mesma coisa=>", a is b)

b = a 
print("(c) e (b) são a mesma coisa=>", c is b)
print("(a) e (b) são a mesma coisa=>", a is b)