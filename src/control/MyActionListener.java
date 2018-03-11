package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import modelo.Coordenada;

public class MyActionListener implements ActionListener, MouseListener {
	private ParaBuscaminasUI ParaBuscaminasUI;
	private Coordenada lugar;
	private boolean estado = false;

	public MyActionListener(ParaBuscaminasUI ParaBuscaminasUI) {
		super();
		this.ParaBuscaminasUI = ParaBuscaminasUI;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		boolean perdida = false;
		JButton pulsado = (JButton) e.getSource();
		String temp[] = pulsado.getName().split("-");
		lugar = new Coordenada(Integer.valueOf(temp[0]), Integer.valueOf(temp[1]));
		switch (e.getButton()) {
		case 1:
			if (ParaBuscaminasUI.isMina(lugar) && !ParaBuscaminasUI.isMarcada(lugar)) {
				perdida = true;
			} else if (ParaBuscaminasUI.isMarcada(lugar)) {
				// si esta marcada no hace nada
			} else if (!ParaBuscaminasUI.isVelada(lugar)) {
				// comprobar alrededor y destapar si eso
				perdida = ParaBuscaminasUI.desvelador.comprobarMarcadas(lugar);
			} else {
				ParaBuscaminasUI.desvelador.desvelarCasilla(lugar);
			}

			break;
		case 2:
			break;
		case 3:
			if (estado) {
				ParaBuscaminasUI.marcar(lugar);
			} else {
				ParaBuscaminasUI.marcar(lugar);
			}
			estado = !estado;
			break;
		default:
			break;
		}
		ParaBuscaminasUI.actualizar(perdida);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent arg0) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (((JButton) e.getSource()).getName() == "btnIniciarGame") {
			ParaBuscaminasUI.crearTablero();
		} else if (((JButton) e.getSource()).getName() == "btnGana") {
			ParaBuscaminasUI.ponerTableroGame();
		}

	}
}
