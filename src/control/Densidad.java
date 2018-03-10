package control;

import utiles.Utiles;

public enum Densidad {
	facil(Utiles.minasFacil), medio(Utiles.minasMedio), dificil(Utiles.minasDificil);
	private int valor;


	private Densidad(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}
	
}
