package control;

import javax.print.attribute.standard.NumberOfDocuments;

import modelo.Tablero;

public class Iniciador implements Iniciable {
	private byte minas;
	private Densidad densidad;
	private byte filas, columnas;
	private Tablero tablero;
	
	
	public byte getFilas() {
		return filas;
	}

	public byte getColumnas() {
		return columnas;
	}

	public byte getMinas() {
		return minas;
	}

	public void setMinas(byte minas) {
		assert minas>0;
		this.minas = minas;
	}

	public Densidad getDensidad() {
		return densidad;
	}

	public void setDensidad(Densidad densidad) {
		assert densidad!=null;
		this.densidad = densidad;
	}


	@Override
	public void establecerDimensionTablero() {
//		int valorDensidad=this.densidad.getValor();
		switch (densidad) {
		case facil:
			this.minas=15;
			this.filas=10;
			this.columnas=filas;
			break;
		case medio:
			this.minas=40;
			this.filas=16;
			this.columnas=filas;
			break;
		case dificil:
			this.minas=99;
			this.filas=16;
			this.columnas=31;
			break;
		default:
			break;
		}
		
	}

	@Override
	public void crearTablero() {
		assert this.filas > 0 && this.columnas > 0 : "numero no valido de filas/columnas";
		this.tablero = new Tablero(filas, columnas);
	}

	@Override
	public void colocarMinas() {

		assert this.tablero != null && minas > 0 : "fallo al definir el tablero y/o el numero de minas";
		// TODO hay que hacer un sorteo y pedirle al tablero que la coloque
		int contador=this.minas;
		do{
		int[] posicion=sortearMina();
		if (!this.tablero.comprobarMinada(posicion)) {
			boolean retorno = this.tablero.colocarMina(posicion[0], posicion[1]);
			contador--;
		}else{
		}
		}while(contador>0);
		// no se debe acceder directamente a las propiedades de otra clase
		// this.tablero.casillas[x][y].mina=true;
	}

	private int[] sortearMina() {
		int[] posicion={random(0,filas-1),random(0,columnas-1)};
		return posicion;
	}

	private int random(int menor, int mayor) {
		return (int)Math.floor(Math.random()*(menor-(mayor))+(mayor));
	}

	public Tablero iniciarJuego(Byte minas, Densidad densidad) {
		setMinas(minas);
		setDensidad(densidad);
		establecerDimensionTablero();
		crearTablero();
		colocarMinas();
		this.tablero.calcularMinasAlrededor();
		tablero.pintarMatriz();
		return this.tablero;
	}

}
