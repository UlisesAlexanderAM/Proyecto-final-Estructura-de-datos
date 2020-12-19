package InterfazGrafica;

import Listas.PilaCola.Cola;

import javax.swing.*;
import java.awt.*;

public class PanelCola extends JFrame {
	private final Cola<Double> cola = new Cola<>();
	private final JPanel instrucionesPanel = new JPanel(new GridBagLayout());
	private final JPanel resultadosPanel = new JPanel(new GridBagLayout());
	private final JTextArea instruccionesTextArea = new JTextArea();
	private final JPanel operacionesPanel = new JPanel(new GridBagLayout());
	private final JButton agregarNodoButton = new JButton();
	private final JButton ejecutarButton = new JButton();
	private final JButton quitarNodoButton = new JButton();
	private final JButton frenteNodoButton = new JButton();
	private final JTextArea operacionesTextArea = new JTextArea();
	private final JLabel resultadosLabel = new JLabel();
	private final JLabel datoLabel = new JLabel();
	private final JTextPane listaTextPane = new JTextPane();
	private final JScrollPane listaJScrollPane = new JScrollPane();
	private final JScrollPane instruccionesJScrollPane = new JScrollPane();
	private final JScrollPane operacionesJScrollPane = new JScrollPane();
	private final JTextField datoJTextField = new JTextField();
	private JPanel ventana;
	private final static String INSTRUCCIONES_TEXT = "Aquí podras hacer varias operaciones sobre una cola" +
			"\n de tipo numérico: ";
	private final static String RESULTADOS_TEXT = "Aquí podras ver el contenido de la cola\n";
	private String operacionesTextFinal;
	private final StringBuilder operacionesText = new StringBuilder("Se ");
	private double dato;
	private int bandera=-1;

	public PanelCola() {
		createUIComponents();
		ventana.setLayout(new GridBagLayout());
		GridBagConstraints gbc;
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.BOTH;
		ventana.add(instrucionesPanel,gbc);
		instrucionesPanel.add(instruccionesJScrollPane, gbc);
		instruccionesJScrollPane.add(instruccionesTextArea, gbc);
		operacionesPanel.add(operacionesJScrollPane, gbc);
		operacionesJScrollPane.add(operacionesTextArea, gbc);
		resultadosPanel.add(resultadosLabel, gbc);
		listaJScrollPane.add(listaTextPane, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.BOTH;
		ventana.add(operacionesPanel, gbc);
		resultadosPanel.add(listaJScrollPane, gbc);
		instrucionesPanel.add(agregarNodoButton, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.BOTH;
		ventana.add(resultadosPanel, gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.BOTH;
		instrucionesPanel.add(quitarNodoButton, gbc);
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.BOTH;
		instrucionesPanel.add(frenteNodoButton, gbc);
		pack();

		agregarNodoButton.addActionListener(actionEvent -> {
			operacionesPanel.setVisible(true);
			gbc.gridx = 0;
			gbc.gridy = 2;
			gbc.fill = GridBagConstraints.BOTH;
			instrucionesPanel.add(ejecutarButton, gbc);
			operacionesText.append("agrega el numero dado a la cola: ");
			operacionesTextFinal = operacionesText.toString();
			operacionesTextArea.setText(operacionesTextFinal);
			bandera = 0;
			pack();
		});
		quitarNodoButton.addActionListener(actionEvent -> {
			operacionesPanel.setVisible(true);
			operacionesText.append("elimina el primer valor de la cola\n y muestra el dato sacado. ");
			operacionesText.append("\nEl dato quitado es: ").append(cola.quitar().toString());
			operacionesTextFinal = operacionesText.toString();
			operacionesTextArea.setText(operacionesTextFinal);
			listaTextPane.setText(cola.mostrarLista());
			pack();
		});
		frenteNodoButton.addActionListener(actionEvent -> {
			operacionesPanel.setVisible(true);
			operacionesText.append("muestra el número al frente de la cola. ");
			operacionesText.append("\nEl dato al frente es: ").append(cola.frente().toString());
			operacionesTextFinal = operacionesText.toString();
			operacionesTextArea.setText(operacionesTextFinal);
			listaTextPane.setText(cola.mostrarLista());
			pack();
		});
		ejecutarButton.addActionListener(actionEvent -> {
			String texto = datoJTextField.getText();
			if (texto.isBlank()){
				JOptionPane.showMessageDialog(ejecutarButton, "No ha ingresado un número.");
			}else {
				dato = Double.parseDouble(texto);
				if (bandera == 0) {
					cola.insertar(dato);
					listaTextPane.setText(cola.mostrarLista());
					pack();
				}
			}

		});
	}

	private void createUIComponents() {
		ventana = new JPanel();
		instruccionesJScrollPane.setWheelScrollingEnabled(true);
		instruccionesTextArea.setText(INSTRUCCIONES_TEXT);
		instruccionesTextArea.setEditable(false);
		operacionesPanel.setVisible(false);
		agregarNodoButton.setText("Agregar número");
		quitarNodoButton.setText("Quitar número");
		frenteNodoButton.setText("Mostrar frente de la cola");
		resultadosLabel.setText(RESULTADOS_TEXT);
		resultadosLabel.setLabelFor(listaJScrollPane);
		listaJScrollPane.setWheelScrollingEnabled(true);
		listaTextPane.setText("Lista: \n");
		listaTextPane.setEditable(false);
		datoLabel.setText("Ingrese el número: ");
		ejecutarButton.setText("Ejecutar");
		datoJTextField.setToolTipText("Ingrese el numero: ");
		pack();
	}
}
