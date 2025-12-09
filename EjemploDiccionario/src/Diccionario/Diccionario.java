package Diccionario;
import java.util.HashMap;
import java.util.Map;

public class Diccionario {
  public static void main(String[]args) {
	  Map<String,String>diccionarioEsplng = new HashMap<>();
	  diccionarioEsplng.put("hola","hello");
	  diccionarioEsplng.put("adios","goodbye");
	  diccionarioEsplng.put("gracias","thank you");
	  diccionarioEsplng.put("por favor","please");
	  
	  String traduccion = diccionarioEsplng.get("por favor");
	  System.out.println("La traduccion es: "+traduccion);
	  //Iterar todo el diccionario
	  for(Map.Entry<String,String> entrada : diccionarioEsplng.entrySet()) {
		  String palabraEsp = entrada.getKey();
          String traduccionLng = entrada.getValue();
          System.out.println(palabraEsp + "->"+ traduccionLng);
	  }
	  if(diccionarioEsplng.containsKey("por favor")) {
		  System.out.println("\n'por favor' esta en el diccionario");
	  }
	  //Eliminar por medio de la clave
	  diccionarioEsplng.remove("adios");
	  System.out.println("\nDiccionario despues de eliminar adios");
	  System.out.println(diccionarioEsplng);
	  
  }
}
