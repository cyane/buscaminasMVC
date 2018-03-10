package control;

import modelo.Casilla;
import modelo.Coordenada;

public interface Marcable {

	/**
	 * procede a marcar o desmarcar una casilla velada
	 * @param casilla
	 */
	boolean marcarCasilla(Casilla casilla);
}
