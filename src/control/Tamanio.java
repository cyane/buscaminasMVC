package control;

import utiles.Utiles;

public enum Tamanio {
pequenio(Utiles.tamanioFacil),mediano(Utiles.tamanioMedio),grande(Utiles.tamanioDificil);
	private int[] valor;
	private Tamanio(int[] valor) {
		this.valor = valor;
	}

	public int[] getValor() {
		return valor;
	}
	
}
