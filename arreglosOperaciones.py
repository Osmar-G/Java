valores1 = []
valores2 = []
valores3 = []
valores4 = []
def arregloOperaciones(rango):
    i = rango
    a = rango
    while a > 0 and i > 0:
        valor = int(input(f"Introduce un valor {i}: "))
        valor1 = int(input(f"Introduce un valor {a}: "))
        valores1.append(valor+valor1)
        valores2.append(valor-valor1)
        valores3.append(valor*valor1)
        valores4.append(valor/valor1)
        i-=1
        a-=1
        
    print("Suma:            ",valores1)
    print("Resta:           ",valores2)
    print("Multiplicacion:  ",valores3)
    print("Division:        ",valores4)

print(arregloOperaciones(5))