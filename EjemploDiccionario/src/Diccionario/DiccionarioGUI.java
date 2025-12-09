package Diccionario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class DiccionarioGUI extends JFrame {

    private Map<String, String> diccionarioEsplng;
    private JTextField campoPalabra;
    private JTextArea areaDiccionario;

    public DiccionarioGUI() {
        // Diccionario base
        diccionarioEsplng = new HashMap<>();
        diccionarioEsplng.put("hola", "hello");
        diccionarioEsplng.put("adios", "goodbye");
        diccionarioEsplng.put("gracias", "thank you");
        diccionarioEsplng.put("por favor", "please");

        // Configuración del Frame
        setTitle("Diccionario Español - Inglés");
        setSize(550, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel superior
        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new FlowLayout());
        

        panelSuperior.add(new JLabel("Palabra en español:"));
        campoPalabra = new JTextField(15);
        panelSuperior.add(campoPalabra);

        JButton btnTraducir = new JButton("Traducir");
        JButton btnEliminar = new JButton("Eliminar");
        panelSuperior.add(btnTraducir);
        panelSuperior.add(btnEliminar);

        add(panelSuperior, BorderLayout.NORTH);

        // Área de diccionario
        areaDiccionario = new JTextArea();
        areaDiccionario.setEditable(false);
        actualizarAreaDiccionario();

        add(new JScrollPane(areaDiccionario), BorderLayout.CENTER);

        // Acción Traducir
        btnTraducir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String palabra = campoPalabra.getText().toLowerCase();
                if (diccionarioEsplng.containsKey(palabra)) {
                    String traduccion = diccionarioEsplng.get(palabra);
                    JOptionPane.showMessageDialog(null,
                            "Traducción: " + traduccion,
                            "Resultado",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null,
                            "La palabra no está en el diccionario",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
                campoPalabra.setText("");
            }
        });

        // Acción Eliminar
        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String palabra = campoPalabra.getText().toLowerCase();
                if (diccionarioEsplng.remove(palabra) != null) {
                    JOptionPane.showMessageDialog(null,
                            "Se eliminó: " + palabra,
                            "Eliminado",
                            JOptionPane.INFORMATION_MESSAGE);
                    actualizarAreaDiccionario();
                } else {
                    JOptionPane.showMessageDialog(null,
                            "La palabra no existe",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
                campoPalabra.setText("");
            }
        });
    }

    private void actualizarAreaDiccionario() {
        areaDiccionario.setText("Diccionario :\n\n");
        for (Map.Entry<String, String> entry : diccionarioEsplng.entrySet()) {
            areaDiccionario.append(entry.getKey()+"\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DiccionarioGUI().setVisible(true);
        });
    }
}

