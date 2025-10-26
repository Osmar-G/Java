package listas;

import java.awt.*;
import java.util.*;

import javax.swing.*;

import EstrucutrasBasicas.ListasBasicas;

public class listaDinamicas extends JFrame {
	private JTextField txtNombre,txtEdad,txtEstatura;
	private ArrayList<modeloNombre> lista = new ArrayList<>();
	
	
    private JTextField txtElemento;
    private JTextArea txtSalida;
    public listaDinamicas() {
    	setTitle("Ejemplo de Listas Dinamicas");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new FlowLayout());
        JLabel lblNombre = new JLabel("Nombre : ");
        txtNombre = new JTextField(10);
        JLabel lblEdad = new JLabel("Edad: ");
        txtEdad = new JTextField(10);
        JLabel lblEstatura = new JLabel("Estatura");
        txtEstatura = new JTextField(10);
        JButton btnAgregar = new JButton("Agregar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnMostrar = new JButton("Mostrar");
        JButton btnBuscar = new JButton("Buscar");
        JButton btnBorrarTodo = new JButton("Borrar Todo");
        
        panelSuperior.add(lblNombre);
        panelSuperior.add(txtNombre);
        panelSuperior.add(lblEdad);
        panelSuperior.add(txtEdad);
        panelSuperior.add(lblEstatura);
        panelSuperior.add(txtEstatura);
        panelSuperior.add(btnAgregar);
        panelSuperior.add(btnEliminar);
        panelSuperior.add(btnMostrar);
        panelSuperior.add(btnBuscar);
        panelSuperior.add(btnBorrarTodo);
        add(panelSuperior,BorderLayout.NORTH);
        
        txtSalida = new JTextArea();
        txtSalida.setEditable(false);
        add(new JScrollPane(txtSalida), BorderLayout.CENTER);

        // Eventos
        btnAgregar.addActionListener(e -> agregarElemento());
        btnEliminar.addActionListener(e -> eliminarElemento());
        btnMostrar.addActionListener(e -> mostrarLista());
        btnBuscar.addActionListener(e -> buscarNombre());
        btnBorrarTodo.addActionListener(e -> borrarTodo());
    }
    private void agregarElemento() {
    	String nombre = txtNombre.getText().trim();
    	int edad = Integer.parseInt(txtEdad.getText());
    	float estatura = Float.parseFloat(txtEstatura.getText());
    	if(!nombre.isEmpty() || txtEdad.getText().isEmpty() ||txtEstatura.getText().isEmpty()) {
    		lista.add(new modeloNombre(nombre,edad,estatura));
    		txtSalida.append("Agregado: "+nombre+" Edad: "+edad+" Estatura: "+estatura+"\n");
    		txtNombre.setText("");
    		txtEdad.setText("");
    		txtEstatura.setText("");
    	}else {
    		JOptionPane.showMessageDialog(this, "Llene todos los campos", "Aviso", JOptionPane.WARNING_MESSAGE);
    	}
    }
    private void eliminarElemento() {
    	 String nombre = txtNombre.getText().trim();
    	 boolean eliminado = lista.removeIf(p -> p.getNombre().equalsIgnoreCase(nombre));
    	 if (eliminado) {
             txtSalida.append("Eliminado: " + nombre + "\n");
         } else {
             JOptionPane.showMessageDialog(this, "Nombre no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
         }
         txtNombre.setText("");
     }
    
    private void mostrarLista() {
    	txtSalida.append("\nLista Actual:\n");
    	for (modeloNombre persona : lista) {
            txtSalida.append("- " + persona + "\n");
        }
    }
    private void buscarNombre() {
    	String nombre = txtNombre.getText().trim();
    	if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el nombre a buscar", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
    	boolean encontrado = false;
        for (modeloNombre persona : lista) {
            if (persona.getNombre().equalsIgnoreCase(nombre)) {
                txtSalida.append("Encontrado: " + persona + "\n");
                encontrado = true;
                break; // Detiene la búsqueda al encontrar el primero
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(this, "No se encontró el nombre: " + nombre, "Resultado", JOptionPane.INFORMATION_MESSAGE);
        }

        txtNombre.setText("");
    }
    private void borrarTodo() {
    	lista.clear();
    	txtSalida.setText("");
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 SwingUtilities.invokeLater(() -> new listaDinamicas().setVisible(true));
	}

}
