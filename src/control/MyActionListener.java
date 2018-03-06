package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import modelo.Tablero;

public class MyActionListener implements ActionListener, MouseListener {
	private ParaBuscaminasUI ParaBuscaminasUI;
	private Marcador Marcador;
	private Tablero tablero;

	public MyActionListener(ParaBuscaminasUI ParaBuscaminasUI, Marcador marcador) {
		super();
		this.ParaBuscaminasUI = ParaBuscaminasUI;
		this.Marcador = marcador;
		this.tablero = tablero;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int boton = e.getButton();
		switch (boton) {
		case 1:
			System.out.println("izqui");
			break;
		case 2:
			System.out.println("soy el boton central");
			break;
		case 3:
			System.out.println("soy el boton dcha");
			break;
		default:
			System.out.println("soy el boton no lo tengo claro");
			break;
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (((JButton) e.getSource()).getName() == "btnTest") {
			ParaBuscaminasUI.crearTablero();
		} else {
			ParaBuscaminasUI.click(((JButton) e.getSource()).getName());
		}

	}
}
