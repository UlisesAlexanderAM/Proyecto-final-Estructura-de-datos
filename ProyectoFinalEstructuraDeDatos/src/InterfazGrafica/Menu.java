package InterfazGrafica;

import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {
	protected static final JFrame ventana =new JFrame();
	private static final JButton botonCola  = new JButton();
	private static final JButton botonListaSimple = new JButton();
	private static final JButton botonListaCircular = new JButton();
	private static final JButton botonListaDoble = new JButton();
	private static final JButton botonPila = new JButton();
	private static final JPanel panelPila = new PanelPila().getVentana();
	private static final JPanel panelCola = new PanelCola().getVentana();
	private static final JPanel panelListaSimple = new PanelListaSimple().getVentana();
	private static final JPanel panelListaDoble = new PanelListaDoble().getVentana();
	private static final JPanel panelListaCircular = new PanelListaCircular().getVentana();
	private static final JButton botonRegresar = new JButton();

	public static void main(String[] args) {
		JPanel ventanaContenedor = new JPanel();
		JPanel panelBotonesMenu = new JPanel();

		ventana.setTitle("Menu Listas");
		ventana.setContentPane(ventanaContenedor);
		ventana.setLayout(new GridBagLayout());
		ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
		ventana.setVisible(true);
		ventana.pack();

		createUIComponents();

		panelBotonesMenu.setVisible(true);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.BOTH;
		panelBotonesMenu.add(botonListaCircular, gbc);
		ventanaContenedor.add(panelBotonesMenu,gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.WEST;
		panelBotonesMenu.add(botonListaSimple, gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.EAST;
		panelBotonesMenu.add(botonListaDoble, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.WEST;
		panelBotonesMenu.add(botonCola, gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.EAST;
		panelBotonesMenu.add(botonPila, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.BOTH;
		ventanaContenedor.add(panelCola,gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.BOTH;
		ventanaContenedor.add(panelPila,gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.fill = GridBagConstraints.BOTH;
		ventanaContenedor.add(panelListaSimple,gbc);
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.fill = GridBagConstraints.BOTH;
		ventanaContenedor.add(panelListaDoble,gbc);
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.fill = GridBagConstraints.BOTH;
		ventanaContenedor.add(panelListaCircular,gbc);
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.fill = GridBagConstraints.BOTH;
		ventanaContenedor.add(botonRegresar,gbc);

		ventana.pack();

		botonPila.addActionListener(actionEvent -> {
			panelCola.setVisible(false);
			panelListaCircular.setVisible(false);
			panelListaDoble.setVisible(false);
			panelListaSimple.setVisible(false);
			panelPila.setVisible(true);
			panelBotonesMenu.setVisible(false);
		});
		botonCola.addActionListener(actionEvent -> {
			panelCola.setVisible(true);
			panelListaCircular.setVisible(false);
			panelListaDoble.setVisible(false);
			panelListaSimple.setVisible(false);
			panelPila.setVisible(false);
			panelBotonesMenu.setVisible(false);
		});
		botonListaSimple.addActionListener(actionEvent -> {
			panelCola.setVisible(false);
			panelListaCircular.setVisible(false);
			panelListaDoble.setVisible(false);
			panelListaSimple.setVisible(true);
			panelPila.setVisible(false);
			panelBotonesMenu.setVisible(false);
		});
		botonListaDoble.addActionListener(actionEvent -> {
			panelCola.setVisible(false);
			panelListaCircular.setVisible(false);
			panelListaDoble.setVisible(true);
			panelListaSimple.setVisible(false);
			panelPila.setVisible(false);
			panelBotonesMenu.setVisible(false);
		});
		botonListaCircular.addActionListener(actionEvent -> {
			panelCola.setVisible(false);
			panelListaCircular.setVisible(true);
			panelListaDoble.setVisible(false);
			panelListaSimple.setVisible(false);
			panelPila.setVisible(false);
			panelBotonesMenu.setVisible(false);
		});
		botonRegresar.addActionListener(actionEvent -> {
			panelCola.setVisible(false);
			panelListaCircular.setVisible(false);
			panelListaDoble.setVisible(false);
			panelListaSimple.setVisible(false);
			panelPila.setVisible(false);
			panelBotonesMenu.setVisible(true);
		});
	}

	private static void createUIComponents() {
		botonCola.setText("Cola");
		botonListaCircular.setText("Lista Circular");
		botonListaDoble.setText("Lista Doblemente Enlazada");
		botonListaSimple.setText("Lista Enlazada Simple");
		botonPila.setText("Pila");
		botonRegresar.setText("Regresar");
		panelCola.setVisible(false);
		panelListaCircular.setVisible(false);
		panelListaDoble.setVisible(false);
		panelListaSimple.setVisible(false);
		panelPila.setVisible(false);
	}
}
