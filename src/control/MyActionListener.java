package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import modelo.Casilla;
import modelo.Coordenada;
import modelo.Tablero;
import utiles.Utiles;

public class MyActionListener implements ActionListener, MouseListener {
	private ParaBuscaminasUI ParaBuscaminasUI;
	private Marcador marcador;
	private Coordenada lugar;
	private boolean estado = false;
	private ImageIcon icono= new ImageIcon(getClass().getResource("/assets/icono.jpg"));
	private ImageIcon bosque= new ImageIcon(getClass().getResource("/assets/bosque.jpg"));
	public MyActionListener(ParaBuscaminasUI ParaBuscaminasUI, Marcador marcador) {
		super();
		this.ParaBuscaminasUI = ParaBuscaminasUI;
		this.marcador=marcador;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		boolean perdida=false;
		JButton pulsado = (JButton) e.getSource();
		String temp[] = pulsado.getName().split("-");
		lugar=new Coordenada(Integer.valueOf(temp[0]), Integer.valueOf(temp[1]));
		System.out.println(lugar.getPosX()+" "+lugar.getPosY() );
		switch (e.getButton()) {
		case 1:
			if(ParaBuscaminasUI.isMina(lugar)&&!ParaBuscaminasUI.isMarcada(lugar)){
				perdida = true;
			}else if(ParaBuscaminasUI.isMarcada(lugar)){
				// si esta marcada no hace nada
				System.out.println("casilla marcada");
			}else if(!ParaBuscaminasUI.isVelada(lugar)){
				//comprobar alrededor y destapar si eso
				perdida=ParaBuscaminasUI.desvelador.comprobarMarcadas(lugar);
			}else{
				ParaBuscaminasUI.desvelador.desvelarCasilla(lugar);
			}
		
			break;
		case 2:
			System.out.println("soy el boton central");
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
			System.out.println("soy el boton no lo tengo claro");
			break;
		}
		if (ParaBuscaminasUI.actualizar(perdida)) {
			System.out.println("gana");
		}
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
