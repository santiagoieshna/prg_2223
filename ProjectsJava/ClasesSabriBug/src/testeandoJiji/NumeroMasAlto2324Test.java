package testeandoJiji;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NumeroMasAlto2324Test {

	@Test
	void testComprobarLimiteFallos() {
		
		
	}

	
	@Test
	void testIncrementarFallos() {
		// Caso 1
		int input = 0;
		int valueExpected = 1;
		int valueActual = NumeroMasAlto2324.incrementarFallos(input);
		
		assertEquals(valueExpected, valueActual);
		
		//Caso 4
		input = -1;
		valueExpected = -1;
		valueActual = NumeroMasAlto2324.incrementarFallos(input);
		boolean sonIguales = valueExpected == valueActual;
		
		assertTrue(sonIguales);
		
		//Case 6
		input = -1;
		valueExpected = 0;
		valueActual = NumeroMasAlto2324.incrementarFallos(input);
		sonIguales = valueExpected == valueActual;
		
		assertFalse(sonIguales);
		
		
	}

	@Test
	void testCompararValores() {
		
	}

	@Test
	void testGenerarAleatorio() {
		
	}

	@Test
	void testPedirNumero() {
		
	}

}
