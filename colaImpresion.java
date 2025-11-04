package ejercicio;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class colaImpresion {
	public static void main(String[] args) {
		colaImpresion();
	}

	public static void colaImpresion() {
		Queue<String> TrabajoImp = new LinkedList<>();// esta declaracion almacena los documentos en cola
		Scanner sc = new Scanner(System.in);
		System.out.println("Comando encolar: Agrega un archivo a la cola de la impresion");
		System.out.println("Comando imprimir: Imprimir un documento de la cola ");
		System.out.println("Comando imprimir-todo: imprimir todos los documentos de la cola de impresion");
		System.out.println("Comando show : Comando para visualizar los documentos en la cola de impresion");
		System.out.println("Comando exit: Comando para salir");
		System.out.println("*".repeat(20));

		while (true) {
			System.out.println("Que desea hacer: ");
			String comando = sc.next();

			switch (comando) {
			case "show":
				System.out.println("_".repeat(30));
				System.out.println(String.format("Documento en cola(%d)", TrabajoImp.size()));
				for (String doc : TrabajoImp) {
					System.out.println("-> " + doc);
				}
				break;
			case "encolar":
				System.out.println("-".repeat(30));
				System.out.println("Ingresa el nombre del documento");
				String nombreDoc = sc.next();
				TrabajoImp.add(nombreDoc);
				break;
			case "imprimir":
				System.out.println("-".repeat(30));
				if (TrabajoImp.isEmpty()) {
					System.out.println("No hay documentos para imprimir");
					break;
				}
				System.out.println("Imprimiendo ->" + TrabajoImp.poll());
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			case "imprimir-todo":
				System.out.println("_".repeat(30));
				System.out.println("Imprimiendo todos los documentos de la cola");
				while(!TrabajoImp.isEmpty()) {
					System.out.println("Imprimiendo-> " + TrabajoImp.poll());
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				
				}
				break;
			case"exit":
				System.out.println("Apagar Impresora");
				sc.close();
				System.exit(0);
				break;
			default:
				System.out.println("!".repeat(30));
				System.out.println("Comando no reconocido");
			

			}

		}
	}

}
