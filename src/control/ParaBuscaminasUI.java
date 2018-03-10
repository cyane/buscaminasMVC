package control;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import org.hamcrest.core.IsNull;

import modelo.Casilla;
import modelo.Coordenada;
import modelo.Tablero;
import utiles.Utiles;
import vista.Botonera;
import vista.BuscaminasUI;

public class ParaBuscaminasUI extends BuscaminasUI{
	Iniciador iniciador = new Iniciador();
	Marcador marcador= new Marcador();
	private Botonera botonera;
	private Tablero tablero; 
	MyActionListener listener = new MyActionListener(this, marcador);
	private Casilla[][] casillas;
	Desvelador desvelador;
	protected ImageIcon bandera = new ImageIcon(getClass().getResource("/assets/banderaPeque.png"));
	private ImageIcon imagenGana= new ImageIcon(getClass().getResource("/assets/gana.png"));
	private ImageIcon imagenPierde= new ImageIcon(getClass().getResource("/assets/pierde.jpg"));
	public ParaBuscaminasUI(String img) {
	super(img);
	btnIniciarGame.addActionListener(listener);

	}

	public void crearTablero() {
		int[] valores={Integer.valueOf(txtMinas.getText()),Integer.valueOf(txtFilas.getText()),Integer.valueOf(txtColumnas.getText())};
		if (rdbtnExperimental.isSelected()) {
			this.tablero=this.iniciador.iniciarJuego(densidad,(Tamanio) comboBox.getSelectedItem(),true,valores);
		}else{
			this.tablero=this.iniciador.iniciarJuego(densidad,(Tamanio) comboBox.getSelectedItem(),false,valores);
		}
		this.casillas=tablero.getCasillas();
		this.desvelador=new Desvelador(tablero,casillas);//probar a meter en MAL y quitar metodos de aqui abajo
		btnGana.addActionListener(listener);
		cambiarFrame();
		for (int i = 0; i < this.botonera.botones.length; i++) {
			for (int j = 0; j < this.botonera.botones[i].length; j++) {
				this.botonera.botones[i][j].addActionListener(listener);
				this.botonera.botones[i][j].addMouseListener(listener);
			}
		}
		
		

	}

	protected boolean actualizar(boolean perdida) {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dimensiones = tk.getScreenSize();
		int contador=0;
		lblCantidadMinas.setText(String.valueOf(iniciador.getMinas()));
		for (int i = 0; i < this.botonera.botones.length; i++) {
			for (int j = 0; j < this.botonera.botones[i].length; j++) {
					JButton pulsado = this.botonera.botones[i][j];
					Casilla casilla= casillas[i][j];
				if (!casilla.isVelada()) {//si la casilla esa desvelada
					contador++;
					if(!perdida){
						pulsado.setText(String.valueOf(casilla.getAlrededor()));
						pulsado.setBackground(Color.blue);
						if (casilla.isVelada()&&!casilla.isMina()) {
						}
					}
				}else if(perdida) {//viene en true si has dado en una minia
					btnGana.setIcon(Utiles.createScaledIcon(bandera, btnGana.getHeight()));//img pierde
					if (casilla.isMina()){
						pulsado.setIcon(Utiles.createScaledIcon(bandera, pulsado.getHeight())); //img de las bombas
					}
					pulsado.setName("s");
					
					btnGana.setIcon(Utiles.createScaledIcon(imagenPierde, btnGana.getHeight()));
					setBounds((int) (dimensiones.getWidth()/3) ,(int)(dimensiones.getHeight()/5),666,559);
					getCurrentPanel("name_panelPostGame");
					
				}else{//si la casilla no esta desvelada
					if(casilla.isMarcada()){
						pulsado.setIcon(Utiles.createScaledIcon(bandera, pulsado.getHeight()));
					}else{
						pulsado.setIcon(null);
					}
				}  
			}
		}
		

		
		//comprueba ganador
		if (contador==iniciador.getColumnas()*iniciador.getFilas()-iniciador.getMinas()) {
			setBounds((int) (dimensiones.getWidth()/3) ,(int)(dimensiones.getHeight()/8),666,738);
			btnGana.setIcon(Utiles.createScaledIcon(imagenGana, btnGana.getHeight()));
			getCurrentPanel("name_panelPostGame");
			return true;
		}else{
			return false;
		}
	}
	 void ponerTableroGame(){
		 medidaTablero();
		getCurrentPanel("name_panelIngame");
	}

	private void cambiarFrame() {	

			botonera=new Botonera(iniciador.getFilas(), iniciador.getColumnas(), 37);
			medidaTablero();
			panel.add(botonera);
		}

	private void medidaTablero() {
		setBounds(100,50, 1400, 750);
	}



	public boolean isMina(Coordenada lugar) {
		return this.casillas[lugar.getPosX()][lugar.getPosY()].isMina();
	}

	public boolean isMarcada(Coordenada lugar) {
		return this.casillas[lugar.getPosX()][lugar.getPosY()].isMarcada();
	}

	public boolean isVelada(Coordenada lugar) {
		return this.casillas[lugar.getPosX()][lugar.getPosY()].isVelada();
	}

	public void marcar( Coordenada lugar) {
		 marcador.marcarCasilla(this.casillas[lugar.getPosX()][lugar.getPosY()]);
	}

}

