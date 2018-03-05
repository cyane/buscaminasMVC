package vista;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;

public class Botonera extends JPanel {

	public JButton botones[][];
	int ladoBoton = 15;
	int anchoPanel = 450, altoPanel = 450;

	/**
	 * Create the panel.
	 */
	public Botonera(int filas, int columnas,int ladoBoton) {
		int x=5,y=5;
		this.ladoBoton=ladoBoton;
		this.anchoPanel=ladoBoton*columnas;
		this.altoPanel=ladoBoton*filas;
		setLayout(null);
		this.setBounds(x, y, this.anchoPanel, this.altoPanel);
		iniciarBotonera(filas, columnas);
	}

	private void iniciarBotonera(int filas, int columnas) {
		this.botones = new JButton[filas][columnas];
		int x = 0, y = 0;
		for (int i = 0; i < this.botones.length; i++) {
			for (int j = 0; j < this.botones[i].length; j++) {
				this.botones[i][j] = new JButton();
				this.botones[i][j].setName(String.valueOf(i) + String.valueOf(j));
				this.botones[i][j].setBounds(x, y, this.ladoBoton, this.ladoBoton);
				this.botones[i][j].setBackground(Color.DARK_GRAY);
				this.botones[i][j].setForeground(Color.ORANGE);
				this.botones[i][j].setFont(new Font("Comic Sans MS", Font.BOLD, 30));
				this.add(this.botones[i][j]);
				x += this.ladoBoton;
			}
			x = 0;
			y += this.ladoBoton;
		}
	}
}