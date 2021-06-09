package calculadora;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class calc_Test {
	private double a;
	private double b;
	private NodoPila arriba;
	
	public void pushPila(double nuevo_dato) {
		NodoPila nuevo_nodo = new NodoPila(nuevo_dato, arriba);
		arriba = nuevo_nodo;
	}
	public double popPila( ) {
		double dato_arriba = arriba.dato;
		arriba = arriba.abajo;
		return dato_arriba;
	}
	@Test
	public void poptest( ) {
		a=popPila();
		b=popPila();
		assertNull(a);
	}

}
