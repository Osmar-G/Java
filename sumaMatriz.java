   package matriz;

import java.util.*;

public class sumaMatriz {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Escribe el numero de filas");
		int fila = sc.nextInt();
		System.out.println("Escribe el numero de columnas");
		int columna = sc.nextInt();

		int matriz1[][] = new int[fila][columna];
		int matriz2[][] = new int[fila][columna];
		// Llenado de la primera matriz
		for (int i = 0; i < fila; i++) {
			for (int j = 0; j < columna; j++) {
				System.out.println("Ingresa el valor de la matriz 1 en la posicion " + i + " " + j);
				matriz1[i][j] = sc.nextInt();
			}
		}
		// Llenado de la segunda matriz
		for (int i = 0; i < fila; i++) {
			for (int j = 0; j < columna; j++) {
				System.out.println("Ingresa el valor de la matriz 2 en la posicion " + i + " " + j);
				matriz2[i][j] = sc.nextInt();
			}
		}
		// Impresion de la primer matriz
		System.out.println("\nPrimera matriz");
		for (int i = 0; i < fila; i++) {
			for (int j = 0; j < columna; j++) {
				System.out.print(matriz1[i][j] + " ");
			}
			System.out.println("\n");
		}
		

		// Impresion de la segunda matriz
		System.out.println("\nSegunda matriz");
		for (int i = 0; i < fila; i++) {
			for (int j = 0; j < columna; j++) {
				System.out.print(matriz2[i][j] + " ");
			}
			System.out.println("\n");
		}
		//Suma de la primera diagonal 
		System.out.println("\nSuma de la primera diagonal");
		for(int i = 0 ; i<fila;i++) {
			System.out.println(matriz1[i][i] + matriz2[i][i] );
		}
		//Suma de la segunda diagonal
		System.out.println("\nSuma de la ultima diagonal");
		for(int i = 0 ; i<fila;i++) {
			System.out.println(matriz1[i][3-i] + matriz2[i][3-i] );
		}
	}
}