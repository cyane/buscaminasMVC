package control;

import modelo.Tablero;

public class Iniciador implements Iniciable {
	private byte minas;
	private Densidad densidad;
	private byte filas, columnas;
	private Tablero tablero;
	private Tamanio tamanio;

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
		assert minas > 0;
		this.minas = minas;
	}

	public Densidad getDensidad() {
		return densidad;
	}

	public void setDensidad(Densidad densidad) {
		assert densidad != null;
		this.densidad = densidad;
	}

	public void setTamanio(Tamanio tamanio) {
		assert tamanio != null;
		this.tamanio = tamanio;
	}

	@Override
	public void establecerDimensionTablero() {
		switch (densidad) {
		case facil:
			this.minas = (byte) Densidad.facil.getValor();
			break;
		case medio:
			this.minas = (byte) Densidad.medio.getValor();
			break;
		case dificil:
			this.minas = (byte) Densidad.dificil.getValor();
			break;
		default:
			break;
		}
		int[] temp;
		switch (tamanio) {
		case pequenio:
			temp = Tamanio.pequenio.getValor();
			this.filas = (byte) temp[0];
			this.columnas = (byte) temp[1];
			break;
		case mediano:
			temp = Tamanio.mediano.getValor();
			this.filas = (byte) temp[0];
			this.columnas = (byte) temp[1];
			break;
		case grande:
			temp = Tamanio.grande.getValor();
			this.filas = (byte) temp[0];
			this.columnas = (byte) temp[1];
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
		int contador = this.minas;
		do {
			int[] posicion = sortearMina();
			if (!this.tablero.comprobarMinada(posicion)) {
				this.tablero.colocarMina(posicion[0], posicion[1]);
				contador--;
			} else {
			}
		} while (contador > 0);
		// no se debe acceder directamente a las propiedades de otra clase
		// this.tablero.casillas[x][y].mina=true;
	}

	private int[] sortearMina() {
		int[] posicion = { random(0, filas), random(0, columnas) };
		return posicion;
	}

	private int random(int menor, int mayor) {
		return (int) Math.floor(Math.random() * (menor - (mayor)) + (mayor));
	}

	public Tablero iniciarJuego(Densidad densidad, Tamanio tamanio, boolean perso, int[] valores) {
		if (perso) {
			establecerValores(valores);
		} else {
			setDensidad(densidad);
			setTamanio(tamanio);
			establecerDimensionTablero();
		}
		crearTablero();
		colocarMinas();
		this.tablero.calcularMinasAlrededor();
		tablero.pintarMatriz();
		return this.tablero;
	}

	private void establecerValores(int[] valores) {
		if (valores[1] < 2 || valores[2] < 2) {
			valores[1] = 2;
			valores[2] = 2;
		}
		if (valores[0] >= valores[1] * valores[2]) {
			valores[0] = (valores[1] * valores[2]) / 3;
		}

		this.minas = (byte) valores[0];
		this.filas = (byte) valores[1];
		this.columnas = (byte) valores[2];
	}

}
