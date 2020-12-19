package InterfazGrafica;

import Listas.PilaCola.Pila;

import javax.swing.*;
import java.awt.*;

public class PanelPila extends JFrame {
	private final Pila<Double> cola = new Pila<>();
	private final JPanel instrucionesPanel = new JPanel(new GridBagLayout());
	private final JTextArea instruccionesTextArea = new JTextArea();
	private final JPanel operacionesPanel = new JPanel(new GridBagLayout());
	private final JButton pushButton = new JButton();
	private final JButton ejecutarButton = new JButton();
	private final JButton popButton = new JButton();
	private final JButton cimaButton = new JButton();
	private final JTextArea operacionesTextArea = new JTextArea();
	private final JLabel resultadosLabel = new JLabel();
	private final JLabel datoLabel = new JLabel();
	private final JTextPane listaTextPane = new JTextPane();
	private final JScrollPane listaJScrollPane = new JScrollPane();
	private final JScrollPane instruccionesJScrollPane = new JScrollPane();
	private final JTextField datoJTextField = new JTextField();
	private JPanel ventana;
	private final static String INSTRUCCIONES_TEXT = "Aquí podras hacer varias operaciones sobre una cola" +
			"\n de tipo numérico: ";
	private final static String RESULTADOS_TEXT = "Aquí podras ver el contenido de la cola\n";
	private String operacionesTextFinal;
	private final StringBuilder operacionesText = new StringBuilder("Se ");
	private double dato;
	private int bandera=-1;

	public PanelPila() {
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
		JScrollPane operacionesJScrollPane = new JScrollPane();
		operacionesPanel.add(operacionesJScrollPane, gbc);
		operacionesJScrollPane.add(operacionesTextArea, gbc);
		JPanel resultadosPanel = new JPanel(new GridBagLayout());
		resultadosPanel.add(resultadosLabel, gbc);
		listaJScrollPane.add(listaTextPane, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.BOTH;
		ventana.add(operacionesPanel, gbc);
		resultadosPanel.add(listaJScrollPane, gbc);
		instrucionesPanel.add(pushButton, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.BOTH;
		ventana.add(resultadosPanel, gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.BOTH;
		instrucionesPanel.add(popButton, gbc);
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.BOTH;
		instrucionesPanel.add(cimaButton, gbc);
		pack();

		pushButton.addActionListener(actionEvent -> {
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
		popButton.addActionListener(actionEvent -> {
			operacionesPanel.setVisible(true);
			operacionesText.append("elimina el primer valor de la cola\n y muestra el dato sacado. ");
			operacionesText.append("\nEl dato quitado es: ").append(cola.pop().toString());
			operacionesTextFinal = operacionesText.toString();
			operacionesTextArea.setText(operacionesTextFinal);
			listaTextPane.setText(cola.mostrarLista());
			pack();
		});
		cimaButton.addActionListener(actionEvent -> {
			operacionesPanel.setVisible(true);
			operacionesText.append("muestra el número al frente de la cola. ");
			operacionesText.append("\nEl dato al frente es: ").append(cola.cima().toString());
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
		pushButton.setText("Push número a la pila");
		popButton.setText("Pop número de la pila");
		cimaButton.setText("Mostrar cima de la pila");
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

	public JPanel getVentana() {
		return ventana;
	}
}
