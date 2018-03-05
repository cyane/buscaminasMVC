package modelo;

import control.AccionesTablero;

public class Tablero implements AccionesTablero {
	private Casilla[][] casillas;

	public Tablero(byte filas,byte columnas) {
		super();
		assert filas>0&&columnas>0:"parametros incorrectos";
		// TODO Auto-generated constructor stub
		casillas=new Casilla[filas][columnas];
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				casillas[i][j]=new Casilla();
			}
		}
	}

	
	@Override
	public void calcularMinasAlrededor() {
		// TODO recorrer el panel donde hay mina y colocar un incremento
		//de una mina alrededor de ella
		
	}


	public boolean colocarMina(int x, int y) {
		//no se debe acceder directamente a las propiedades de otra clase
//		casilla[x][y].mina=true;
		
		return casillas[x][y].colocaMina();
	}


	public boolean desvelarCasilla(Casilla casilla) {
		// TODO metodo reecursivo que a partir de un casilla desvelada (hay que saber
		//cual es dentro del tablero) develada todas las de alrededor y sucesivas que tengan
		//un valor de 0 minas alrededor
		return false;
	}
	
	
	
	
	
}
