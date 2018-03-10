package control;

import modelo.Casilla;
import modelo.Coordenada;
import modelo.Tablero;
import utiles.Utiles;

public class Desvelador implements Desvelable{
	Tablero tablero;
	Casilla[][] casillas;
	public Desvelador(Tablero tablero, Casilla[][] casillas) {
		super();
		this.tablero = tablero;
		this.casillas=casillas;
	}
	
	@Override
	public void desvelarCasilla(Coordenada lugar) {
		// lo que hay que hacer siempre
		// es velar una casilla
		setVelada(lugar);

		// comprobar si las casillas marcadas alrededor coincide con el
		// numero de minas alrededor de la casilla
//		if (comprobarMarcadas(lugar)) {
			for (int i = 0; i < Utiles.OCHO; i++) {
				Coordenada posicion = crearCoordenadaAlrededor(lugar.getPosX(), lugar.getPosY(), i);
				if (isInToLimits(posicion)){
					if( isVelada(posicion)){	
						if (!isMarcada(posicion)) {
					setVelada(lugar);
					if (getAlrededor(lugar) == 0){
						desvelarCasilla(posicion);}
				}}}
			}
	}
	/**
	 * Crear la coordenada exacta con un posicion alrededor segun defina el
	 * lugar
	 * 
	 */
	public Coordenada crearCoordenadaAlrededor(int i, int j, int lugar) {
		Coordenada desplazamiento = Utiles.damePosicionAlrededor(lugar);
		// ¿Que nos estamos preguntando?
		int posX = i + desplazamiento.getPosX();
		int posY = j + desplazamiento.getPosY();
		return new Coordenada(posX, posY);
	}

	public boolean isInToLimits(Coordenada pos) {
		return isInside(pos, casillas.length) && isInsideY(pos, casillas[0].length);
	}

	public boolean isInside(Coordenada pos, int upperLimitRow) {
		return pos.getPosX() >= 0 && pos.getPosX() < upperLimitRow;
	}
	public boolean isInsideY(Coordenada pos, int upperLimitRow) {
		return pos.getPosY() >= 0 && pos.getPosY() < upperLimitRow;
	}

	public byte getAlrededor(Coordenada lugar) {
		return casillas[lugar.getPosX()][lugar.getPosY()].getAlrededor();
	}

	public boolean isMarcada(Coordenada posicion) {
		return casillas[posicion.getPosX()][posicion.getPosY()].isMarcada();
	}
	public boolean isMina(Coordenada posicion) {
		return casillas[posicion.getPosX()][posicion.getPosY()].isMina();
	}

	public boolean isVelada(Coordenada posicion) {
		return casillas[posicion.getPosX()][posicion.getPosY()].isVelada();
	}

	public void setVelada(Coordenada lugar) {
		casillas[lugar.getPosX()][lugar.getPosY()].setVelada(false);
	}
	/**
	 * Comporbar si el numero de casillas marcadas alrededor de una casilla
	 * coincide con el numero de minas alrededor de una casilla
	 * 
	 * @param lugar
	 * @return 
	 */
	boolean comprobarMarcadas(Coordenada lugar) {
		int contador = 0;
		int contadorMinas=0;
		// es contar cuantas casilla marcadas rodean a la actual
		for (int i = 0; i < Utiles.OCHO; i++) {
			Coordenada posicion = crearCoordenadaAlrededor(lugar.getPosX(), lugar.getPosY(), i);
			if (isInToLimits(posicion)) {
				if (isMarcada(posicion)) {
					contador++;
				}
				if (isMina(posicion)) {
					contadorMinas++;
				}
			}
		}		
		System.out.println(contador);
		System.out.println(contadorMinas);
		if (contador==contadorMinas) {
			System.out.println("entra");
			return desvelarCasillaAlrededorBandera(lugar);
		}
		return false;
	}

	private boolean desvelarCasillaAlrededorBandera(Coordenada lugar) {
		for (int i = 0; i < Utiles.OCHO; i++) {
			Coordenada posicion = crearCoordenadaAlrededor(lugar.getPosX(), lugar.getPosY(), i);
			if (isInToLimits(posicion)){
			if (isMina(posicion)&&!isMarcada(posicion)) {
				return true;
			}else{
				if (!isMarcada(posicion)) {
					if (getAlrededor(posicion)==0) {
						desvelarCasilla(posicion);
					}
					setVelada(posicion);
				}
				}
			}
		}return false;
	}

}
