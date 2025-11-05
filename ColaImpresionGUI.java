package ejercicio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.Queue;

public class ColaImpresionGUI extends JFrame {

	private Queue<String> colaImpresion = new LinkedList<>();
	private JTextArea areaCola;
	private JTextField txtDocumento;

	public ColaImpresionGUI() {
		setTitle("Cola de Impresión");
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); // Centra la ventana

		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BorderLayout(10, 10));
		panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		JPanel panelSuperior = new JPanel(new FlowLayout());
		JLabel lblDoc = new JLabel("Documento:");
		txtDocumento = new JTextField(20);
		JButton btnEncolar = new JButton("Encolar");
		panelSuperior.add(lblDoc);
		panelSuperior.add(txtDocumento);
		panelSuperior.add(btnEncolar);

		areaCola = new JTextArea();
		areaCola.setEditable(false);
		JScrollPane scroll = new JScrollPane(areaCola);

		JPanel panelBotones = new JPanel(new FlowLayout());
		JButton btnImprimir = new JButton("Imprimir");
		JButton btnImprimirTodo = new JButton("Imprimir Todo");
		JButton btnMostrar = new JButton("Mostrar Cola");
		JButton btnSalir = new JButton("Salir");

		panelBotones.add(btnImprimir);
		panelBotones.add(btnImprimirTodo);
		panelBotones.add(btnMostrar);
		panelBotones.add(btnSalir);

		panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
		panelPrincipal.add(scroll, BorderLayout.CENTER);
		panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

		btnEncolar.addActionListener(e -> {
			String doc = txtDocumento.getText().trim();
			if (!doc.isEmpty()) {
				colaImpresion.add(doc);
				txtDocumento.setText("");
				actualizarCola();
			} else {
				JOptionPane.showMessageDialog(this, "Ingrese un nombre de documento", "Error",
						JOptionPane.WARNING_MESSAGE);
			}
		});

		btnImprimir.addActionListener(e -> {
			if (colaImpresion.isEmpty()) {
				JOptionPane.showMessageDialog(this, "No hay documentos para imprimir", "Cola vacía",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				String doc = colaImpresion.poll();
				JOptionPane.showMessageDialog(this, "Imprimiendo -> " + doc);
				actualizarCola();
			}
		});

		btnImprimirTodo.addActionListener(e -> {
			if (colaImpresion.isEmpty()) {
				JOptionPane.showMessageDialog(this, "No hay documentos en la cola");
			} else {
				while (!colaImpresion.isEmpty()) {
					String doc = colaImpresion.poll();
					JOptionPane.showMessageDialog(this, "Imprimiendo -> " + doc);
					try {
						Thread.sleep(1000); // pausa de 1 segundo entre documentos
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
				}
				actualizarCola();
			}
		});

		btnMostrar.addActionListener(e -> actualizarCola());

		// Acción botón Salir
		btnSalir.addActionListener(e -> {
			int respuesta = JOptionPane.showConfirmDialog(this, "¿Desea salir?", "Confirmar salida",
					JOptionPane.YES_NO_OPTION);
			if (respuesta == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		});

		// Mostrar la ventana
		add(panelPrincipal);
		setVisible(true);
	}

	private void actualizarCola() {
		areaCola.setText("");
		areaCola.append("Documentos en cola (" + colaImpresion.size() + "):\n");
		for (String doc : colaImpresion) {
			areaCola.append("-> " + doc + "\n");
		}
	}

	// Método principal
	public static void main(String[] args) {
		SwingUtilities.invokeLater(ColaImpresionGUI::new);
	}
}
