arreglo1 = []
arreglo2 = []
def cargarArreglos(longitud):
    for i in range(longitud):
        valor = int(input(f"Ingresa el valor {i} : "))
        arreglo1.append(valor)
        arreglo2.append(valor)
        print(f"Suma :   {arreglo1[i] + arreglo2[i]}")
        print(f"Resta :   {arreglo1[i] - arreglo2[i]}")
        print(f"Multiplicacion :   {arreglo1[i] * arreglo2[i]}")
        print(f"Division :  {arreglo1[i] / arreglo2[i]}")

        i += 1
    
longitud = int(input("Ingresa la longitud del arreglo : "))
cargarArreglos(longitud)