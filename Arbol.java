package arbol;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;

public class arbol extends JFrame {

    private JTree arbol;
    private DefaultTreeModel modelo;
    private JTextField txt;

    public arbol() {
        super("Arbol sencillo");

        // Árbol básico
        DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Raiz");
        modelo = new DefaultTreeModel(raiz);
        arbol = new JTree(modelo);

        // Controles simples
        txt = new JTextField(10);
        JButton btnAgregar = new JButton("Agregar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnBuscar = new JButton("Buscar");

        JPanel panel = new JPanel();
        panel.add(txt);
        panel.add(btnAgregar);
        panel.add(btnEliminar);
        panel.add(btnBuscar);

        // --- Acción: Agregar nodo ---
        btnAgregar.addActionListener(e -> {
            String nombre = txt.getText().trim();
            if (nombre.isEmpty()) return;

            TreePath ruta = arbol.getSelectionPath();
            if (ruta == null) return;

            DefaultMutableTreeNode seleccionado =
                    (DefaultMutableTreeNode) ruta.getLastPathComponent();

            seleccionado.add(new DefaultMutableTreeNode(nombre));
            modelo.reload(seleccionado);
        });

        // --- Acción: Eliminar nodo ---
        btnEliminar.addActionListener(e -> {
            TreePath ruta = arbol.getSelectionPath();
            if (ruta == null) return;

            DefaultMutableTreeNode nodo =
                    (DefaultMutableTreeNode) ruta.getLastPathComponent();

            if (nodo.isRoot()) return;

            modelo.removeNodeFromParent(nodo);
        });

        // --- Acción: Buscar nodo ---
        btnBuscar.addActionListener(e -> {
            String buscar = txt.getText().trim();
            if (buscar.isEmpty()) return;

            DefaultMutableTreeNode root = (DefaultMutableTreeNode) modelo.getRoot();
            DefaultMutableTreeNode encontrado = buscarNodo(root, buscar);

            if (encontrado != null) {
                TreePath p = new TreePath(encontrado.getPath());
                arbol.setSelectionPath(p);
                arbol.scrollPathToVisible(p);
            }
        });

        // Ventana
        add(new JScrollPane(arbol), BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);
        setSize(350, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Buscar nodo (versión muy simple)
    private DefaultMutableTreeNode buscarNodo(DefaultMutableTreeNode nodo, String texto) {
        if (nodo.toString().equalsIgnoreCase(texto)) return nodo;

        for (int i = 0; i < nodo.getChildCount(); i++) {
            DefaultMutableTreeNode found = buscarNodo((DefaultMutableTreeNode) nodo.getChildAt(i), texto);
            if (found != null) return found;
        }
        return null;
    }

    public static void main(String[] args) {
        new arbol();
    }
}
