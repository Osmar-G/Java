package banco;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import banco.modeloNombre;

public class listaEspera extends JFrame {
    private JTextField txtNombre;
    private ArrayList<modeloNombre> lista = new ArrayList<>();
    private JTextArea txtSalida;

    public listaEspera() {
        setTitle("Ejemplo de Lista de Espera (Cola)");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Panel superior con controles
        JPanel panelSuperior = new JPanel(new FlowLayout());
        JLabel lblNombre = new JLabel("Nombre:");
        txtNombre = new JTextField(10);
        JButton btnAgregar = new JButton("Agregar");
        JButton btnAtender = new JButton("Atender");

        panelSuperior.add(lblNombre);
        panelSuperior.add(txtNombre);
        panelSuperior.add(btnAgregar);
        panelSuperior.add(btnAtender);
        add(panelSuperior, BorderLayout.NORTH);

        // Área de salida
        txtSalida = new JTextArea();
        txtSalida.setEditable(false);
        add(new JScrollPane(txtSalida), BorderLayout.CENTER);

        // Eventos de botones
        btnAgregar.addActionListener(e -> agregarElemento());
        btnAtender.addActionListener(e -> atenderElemento());
    }

    // Método para agregar un usuario a la cola
    private void agregarElemento() {
        String nombre = txtNombre.getText().trim();
        if (!nombre.isEmpty()) {
            lista.add(new modeloNombre(nombre)); // se agrega al final
            txtSalida.append("En espera: " + nombre + "\n");
            txtNombre.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Usuario inválido", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Método para atender (eliminar) al primer usuario
    private void atenderElemento() {
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay usuarios en espera", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            modeloNombre atendido = lista.remove(0); // elimina el primero
            txtSalida.append("Atendido: " + atendido.getNombre() + "\n");
        }
    }

    // Método main para probar la ventana
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new listaEspera().setVisible(true);
        });
    }
}
