package InterfazGrafica;

import Listas.ListasLigadas.ListaCircular;

import javax.swing.*;
import java.awt.*;

public class PanelListaCircular extends JFrame{
	private final ListaCircular<Double> lista = new ListaCircular<>();
	private final JTextArea instruccionesTextArea = new JTextArea();
	private final JPanel operacionesPanel = new JPanel(new GridBagLayout());
	private final JButton agregarNodoButton = new JButton();
	private final JButton ejecutarButton = new JButton();
	private final JButton eliminarNodoButton = new JButton();
	private final JButton eliminarNodosButton = new JButton();
	private final JTextArea operacionesTextArea = new JTextArea();
	private final JLabel resultadosLabel = new JLabel();
	private final JLabel datoLabel = new JLabel();
	private final JLabel datoNuevoLabel = new JLabel();
	private final JTextPane listaTextPane = new JTextPane();
	//	private final JButton ordenarButton = new JButton();
//	private final JButton ordenarAscendenteButton = new JButton();
//	private final JButton ordenarDescendenteButton = new JButton();
	private final JButton sustituirDatoButton = new JButton();
	private final JButton sustituirDatosButton = new JButton();
	private final JScrollPane listaJScrollPane = new JScrollPane();
	private final JScrollPane instruccionesJScrollPane = new JScrollPane();
	private final JTextField datoJTextField = new JTextField();
	private final JTextField datoNuevoJTextField = new JTextField();
	private JPanel ventana;
	private final static String INSTRUCCIONES_TEXT = "Aquí podras hacer varias operaciones sobre una lista circular" +
			"\n de tipo numérico: ";
	private final static String RESULTADOS_TEXT = "Aquí podras ver el contenido de la lista\n";
	private String operacionesTextFinal;
	private final static String LISTA_TEXT ="Lista: \n";
	private String listaResultante =LISTA_TEXT;
	private final String operacionesText = "Ingrese el número a ";
	private double dato;
	private int bandera=-1;

	public PanelListaCircular() {
		createUIComponents();
		ventana.setLayout(new GridBagLayout());
		GridBagConstraints gbc;
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.BOTH;
		JPanel instrucionesPanel = new JPanel(new GridBagLayout());
		ventana.add(instrucionesPanel,gbc);
//		instrucionesPanel.add(instruccionesJScrollPane, gbc);
//		instruccionesJScrollPane.add(instruccionesTextArea, gbc);
		instrucionesPanel.add(instruccionesTextArea,gbc);
		JScrollPane operacionesJScrollPane = new JScrollPane();
//		operacionesPanel.add(operacionesJScrollPane, gbc);
//		operacionesJScrollPane.add(operacionesTextArea, gbc);
		operacionesPanel.add(operacionesTextArea,gbc);
		JPanel resultadosPanel = new JPanel(new GridBagLayout());
//		resultadosPanel.add(resultadosLabel, gbc);
//		listaJScrollPane.add(listaTextPane, gbc);
		resultadosPanel.add(listaTextPane,gbc);
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
//		instrucionesPanel.add(ordenarButton, gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.BOTH;
		instrucionesPanel.add(eliminarNodoButton, gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.BOTH;
		instrucionesPanel.add(sustituirDatoButton, gbc);
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.BOTH;
		instrucionesPanel.add(eliminarNodosButton, gbc);
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.BOTH;
		instrucionesPanel.add(sustituirDatosButton, gbc);

		agregarNodoButton.addActionListener(actionEvent -> {
			createUIComponents();
			operacionesPanel.setVisible(true);
			operacionesTextFinal = operacionesText + "agregar a la lista: ";
			operacionesTextArea.setText(operacionesTextFinal);
			gbc.gridx = 0;
			gbc.gridy = 1;
			gbc.fill = GridBagConstraints.WEST;
			operacionesPanel.add(datoLabel, gbc);
			gbc.gridx = 1;
			gbc.gridy = 1;
			gbc.fill = GridBagConstraints.EAST;
			operacionesPanel.add(datoJTextField, gbc);
			gbc.gridx = 0;
			gbc.gridy = 2;
			gbc.fill = GridBagConstraints.BOTH;
			operacionesPanel.add(ejecutarButton, gbc);
			bandera = 0;
		});
		eliminarNodoButton.addActionListener(actionEvent -> {
			createUIComponents();
			operacionesPanel.setVisible(true);
			operacionesTextFinal = operacionesText + "eliminar(su primer aparición) de la lista: ";
			operacionesTextArea.setText(operacionesTextFinal);
			gbc.gridx = 0;
			gbc.gridy = 1;
			gbc.fill = GridBagConstraints.WEST;
			operacionesPanel.add(datoLabel, gbc);
			gbc.gridx = 1;
			gbc.gridy = 1;
			gbc.fill = GridBagConstraints.EAST;
			operacionesPanel.add(datoJTextField, gbc);
			gbc.gridx = 0;
			gbc.gridy = 2;
			gbc.fill = GridBagConstraints.BOTH;
			operacionesPanel.add(ejecutarButton, gbc);
			bandera = 1;
		});
		eliminarNodosButton.addActionListener(actionEvent -> {
			createUIComponents();
			operacionesPanel.setVisible(true);
			operacionesTextFinal = operacionesText + "eliminar(todas las apariciones) de la lista: ";
			operacionesTextArea.setText(operacionesTextFinal);
			gbc.gridx = 0;
			gbc.gridy = 1;
			gbc.fill = GridBagConstraints.WEST;
			operacionesPanel.add(datoLabel, gbc);
			gbc.gridx = 1;
			gbc.gridy = 1;
			gbc.fill = GridBagConstraints.EAST;
			operacionesPanel.add(datoJTextField, gbc);
			gbc.gridx = 0;
			gbc.gridy = 2;
			gbc.fill = GridBagConstraints.BOTH;
			operacionesPanel.add(ejecutarButton, gbc);
			bandera = 2;
		});
//		ordenarButton.addActionListener(actionEvent -> {
//			operacionesPanel.setVisible(true);
//
//		});
		sustituirDatoButton.addActionListener(actionEvent -> {
			createUIComponents();
			operacionesPanel.setVisible(true);
			operacionesTextFinal = operacionesText + "sustituir(primer aparición) de la lista: ";
			operacionesTextArea.setText(operacionesTextFinal);
			gbc.gridx = 0;
			gbc.gridy = 1;
			gbc.fill = GridBagConstraints.WEST;
			operacionesPanel.add(datoLabel, gbc);
			gbc.gridx = 1;
			gbc.gridy = 1;
			gbc.fill = GridBagConstraints.EAST;
			operacionesPanel.add(datoJTextField, gbc);
			gbc.gridx = 0;
			gbc.gridy = 2;
			gbc.fill = GridBagConstraints.WEST;
			operacionesPanel.add(datoNuevoLabel, gbc);
			gbc.gridx = 1;
			gbc.gridy = 2;
			gbc.fill = GridBagConstraints.EAST;
			operacionesPanel.add(datoNuevoJTextField, gbc);
			gbc.gridx = 0;
			gbc.gridy = 3;
			gbc.fill = GridBagConstraints.BOTH;
			operacionesPanel.add(ejecutarButton, gbc);
			bandera = 3;
		});
		sustituirDatosButton.addActionListener(actionEvent -> {
			createUIComponents();
			operacionesPanel.setVisible(true);
			operacionesTextFinal = operacionesText + "sustituir(primer aparición) de la lista: ";
			operacionesTextArea.setText(operacionesTextFinal);
			gbc.gridx = 0;
			gbc.gridy = 1;
			gbc.fill = GridBagConstraints.WEST;
			operacionesPanel.add(datoLabel, gbc);
			gbc.gridx = 1;
			gbc.gridy = 1;
			gbc.fill = GridBagConstraints.EAST;
			operacionesPanel.add(datoJTextField, gbc);
			gbc.gridx = 0;
			gbc.gridy = 2;
			gbc.fill = GridBagConstraints.WEST;
			operacionesPanel.add(datoNuevoLabel, gbc);
			gbc.gridx = 1;
			gbc.gridy = 2;
			gbc.fill = GridBagConstraints.EAST;
			operacionesPanel.add(datoNuevoJTextField, gbc);
			gbc.gridx = 0;
			gbc.gridy = 3;
			gbc.fill = GridBagConstraints.BOTH;
			operacionesPanel.add(ejecutarButton, gbc);
			bandera = 4;
		});
		ejecutarButton.addActionListener(actionEvent -> {
			String texto = JOptionPane.showInputDialog("Ingrese un numero: ");
			if (texto.isBlank()){
				JOptionPane.showMessageDialog(ejecutarButton, "No ha ingresado un número.");
			}else {
				dato = Double.parseDouble(texto);
				switch (bandera) {
					case 0 -> {
						lista.insertar(dato);
					}
					case 1 -> {
						lista.eliminar(dato);
					}
					case 2 -> {
						lista.eliminarElementos(dato);
					}
					case 3 -> {
						String texto2 = datoNuevoJTextField.getText();
						if (texto2.isBlank()) {
							JOptionPane.showMessageDialog(ejecutarButton, "No ha ingresado un número.");
						} else {
							double datoNuevo = Double.parseDouble(texto2);
							lista.modificarDatoNodo(dato, datoNuevo);
						}
					}
					case 4 -> {
						String texto2 = datoNuevoJTextField.getText();
						if (texto2.isBlank()) {
							JOptionPane.showMessageDialog(ejecutarButton, "No ha ingresado un número.");
						} else {
							double datoNuevo = Double.parseDouble(texto2);
							lista.modificarDatoNodos(dato, datoNuevo);
						}
					}
				}
				listaResultante=LISTA_TEXT+lista.mostrarLista();
				listaTextPane.setText(listaResultante);
				JOptionPane.showMessageDialog(ejecutarButton, listaResultante);
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
		eliminarNodoButton.setText("Eliminar número");
		eliminarNodosButton.setText("Eliminar números");
//		ordenarButton.setText("Ordenar números");
		sustituirDatoButton.setText("Sustituir número");
		sustituirDatosButton.setText("Sustituir números");
		resultadosLabel.setText(RESULTADOS_TEXT);
		resultadosLabel.setLabelFor(listaJScrollPane);
		listaJScrollPane.setWheelScrollingEnabled(true);
		listaTextPane.setText(listaResultante);
		listaTextPane.setEditable(false);
		datoLabel.setText("Ingrese el número: ");
		ejecutarButton.setText("Ejecutar");
		datoJTextField.setToolTipText("Ingrese el numero: ");
		datoJTextField.setText("Ingrese un numero: ");
		datoNuevoLabel.setText("Ingrese el número nuevo: ");
		datoNuevoJTextField.setToolTipText("Ingrese el número nuevo: ");
		datoNuevoJTextField.setText("Ingrese un numero: ");
		operacionesTextArea.setEditable(false);
	}

	public JPanel getVentana() {
		return ventana;
	}
}
