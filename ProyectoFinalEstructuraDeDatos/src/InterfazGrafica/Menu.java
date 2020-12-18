package InterfazGrafica;

import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {
	protected static final JFrame ventana =new JFrame();

	public static void main(String[] args) {
		JPanel ventanaContenedor = new JPanel();


		ventana.setTitle("Menu Listas");
		ventana.setContentPane(ventanaContenedor);
		ventana.setLayout(new GridBagLayout());
		ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
		ventana.setVisible(true);
		ventana.pack();

	}
}
