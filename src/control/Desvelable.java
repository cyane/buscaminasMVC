package control;

import modelo.Casilla;
import modelo.Coordenada;

public interface Desvelable {
	/**
	 * Devela una casilla velada y sigue el mecanismo de desvelo impuesto
	 * @param casilla
	 * @return
	 */
void desvelarCasilla(Coordenada lugar);
}
