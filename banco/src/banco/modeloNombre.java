package banco;

public class modeloNombre {
private String nombre;
public modeloNombre(String nombre) {
	this.nombre=nombre;
}
public String getNombre() {
    return nombre;
}
@Override
public String toString() {
	return "Cliente: "+nombre;
	
}
}
