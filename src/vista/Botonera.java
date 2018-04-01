package vista;

import javax.swing.JPanel;

import utiles.Utiles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Botonera extends JPanel {

	public JButton botones[][];


	/**
	 * Create the panel.
	 */
	public Botonera(int filas, int columnas) {
		this.setLayout(new GridLayout(filas, columnas, 0, 0));
		iniciarBotonera(filas, columnas);
	}

	private void iniciarBotonera(int filas, int columnas) {
		this.botones = new JButton[filas][columnas];
		for (int i = 0; i < this.botones.length; i++) {
			for (int j = 0; j < this.botones[i].length; j++) {
				this.botones[i][j] = new JButton();
				this.botones[i][j].setName(String.valueOf(i) + "-" + String.valueOf(j));
				this.botones[i][j].setBackground(new Color(83, 160, 57));
				this.botones[i][j].setForeground(Color.ORANGE);
				this.botones[i][j].setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 30));
				this.botones[i][j].setBorder(null);
				ImageIcon bosque= new ImageIcon(getClass().getResource("/assets/bosque.jpg"));
				this.botones[i][j].setIcon(Utiles.createScaledIcon(bosque, this.botones[i][j].getHeight()));
				this.add(this.botones[i][j]);
			}
		}
	}
}