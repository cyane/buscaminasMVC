package control.test;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Tablero;

public class TableroTest {

	Tablero tablero;
	@Test
	public void testDesvelarCasilla() {
		tablero=new  Tablero((byte)5, (byte)5);
		
	}

}
