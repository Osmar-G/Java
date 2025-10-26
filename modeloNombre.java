public class modeloNombre {
private int edad;
private String nombre;
private float estatura;
public modeloNombre(String nombre,int edad,float estatura) {
	this.edad=edad;
	this.nombre=nombre;
	this.estatura = estatura;
}
public String getNombre() {
    return nombre;
}

@Override
public String toString() {
	return "Nombre: "+nombre+" Edad: "+edad+" Estatura: "+estatura+"\n";
	
}
}
