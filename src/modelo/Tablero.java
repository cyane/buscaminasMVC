package modelo;

import control.AccionesTablero;
import vista.Botonera;

public class Tablero implements AccionesTablero {
	private Casilla[][] casillas;


	public Tablero(byte filas,byte columnas) {
		super();
		assert filas>0&&columnas>0:"parametros incorrectos";
		this.casillas=new Casilla[filas][columnas];
		for (int i = 0; i < this.casillas.length; i++) {
			for (int j = 0; j < this.casillas[i].length; j++) {
				this.casillas[i][j]=new Casilla();
			}
		}
	}

	@Override
	public void calcularMinasAlrededor() {
		for (int i = 0; i < this.casillas.length; i++) {
			for (int j = 0; j < this.casillas[i].length; j++) {
				if(this.casillas[i][j].isMina()){
					for (int x = i-1; x < i+2; x++) {
						for (int y = j-1; y < j+2; y++) {
							if (comprobacion(i,j,x,y)) {
								if(!this.casillas[x][y].isMina()){
								this.casillas[x][y].incrementar();
								}
							}
						}
					}
				}
			}
		}	
	}


	public boolean comprobacion(int i, int j, int x, int y) {
		if ((i!=x||j!=y)&&x>=0&&x<this.casillas.length&&y>=0&&y<this.casillas[x].length) {
			return true;
		}
		return false;
	}


	public boolean colocarMina(int x, int y) {
		//no se debe acceder directamente a las propiedades de otra clase
//		casilla[x][y].mina=true;
		
		return casillas[x][y].colocaMina();
	}


	public Casilla[][] getCasillas() {
		return casillas;
	}


	public boolean desvelarCasilla(Casilla casilla) {
		casilla.setVelada(false);
		return true;
	}


	public boolean comprobarMinada(int[] posicion) {
		return casillas[posicion[0]][posicion[1]].isMina();
	}


	public void pintarMatriz() {
		System.out.println("entra en pintar matriz");
		for (int i = 0; i < this.casillas.length; i++) {
			for (int j = 0; j < this.casillas[i].length; j++) {
				if (this.casillas[i][j].isMina()) {
					System.out.print(" M");
				}else{
					System.out.print(" "+this.casillas[i][j].getAlrededor());
				}
					
				}
			System.out.println();
		}
		
	}
	
	
	
	
	
}
