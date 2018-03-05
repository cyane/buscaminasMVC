package utiles;

import modelo.Coordenada;

public class Utiles {
	public static Coordenada damePosicionAlrededor(int lugar) {
		int[][] posicion = { { -1, -1 }, { -1, 0 }, { -1, +1 },
				{ 0, -1 }, { 0, +1 }, { +1, -1 }, { +1, 0 },
				{ +1, +1 } };
		return new Coordenada(posicion[lugar][0], posicion[lugar][1]);
	}
}
