package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Tablero;
import vista.Botonera;
import vista.BuscaminasUI;
import vista.BuscaminasUI2;

public class ParaBuscaminasUI extends BuscaminasUI{
	Iniciador iniciador = new Iniciador();
	Marcador marcador= new Marcador();
	MyActionListener listener = new MyActionListener(this, marcador);
	Densidad densidad;
	private Botonera botonera;
	private Tablero tablero; //TODO buff
	
	
	public ParaBuscaminasUI() {
	super();
	btnTest.addActionListener(listener);
	}

	public void crearTablero() {
		setDensidad(Densidad.dificil);//TODO ESTE DATO LO ELIJE EL USUARIO, ESTA ASI PARA IR PROBANDO
		this.tablero=iniciador.iniciarJuego((byte) /*la pilla de algun componente*/20,Densidad.dificil );
		cambiarFrame();
		for (int i = 0; i < this.botonera.botones.length; i++) {
			for (int j = 0; j < this.botonera.botones[i].length; j++) {
				this.botonera.botones[i][j].addActionListener(listener);
				this.botonera.botones[i][j].addMouseListener(listener);
			}
		}

	}

	private void cambiarFrame() {	

			switch (densidad) {
			case facil:
				//TODO RELLENAR
				break;
			case medio:
				//TODO RELLENAR
				break;
			case dificil://TODO BUSCAR FORMULA PARA QUE LAS MEDIDAS NO NECESITEN NUMEROS
				botonera=new Botonera(iniciador.getFilas(), iniciador.getColumnas(), 37);
				panel.add(botonera);
				setBounds(100,50, 1300, 750);
				panel.setBounds(50,50,1155,600);
				break;
			default:
				break;
			}
		}
	public void setDensidad(Densidad densidad) {
		assert densidad!=null;
		this.densidad = densidad;
	}
 
	public void click(String name) {
		System.out.println(name);
		
	}

}

