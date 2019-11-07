

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import entities.Dado;

public class DadoTest {
	
	Dado dado;
	
	@Before
	public void setUp() {
		dado = new Dado(1,6);
	}
	
	@Test
	public void tirarDadoTest(){
		
		for (int i = 0; i < 300; i++) {
			int valor=dado.tirarDado();
			assertTrue(valor<=dado.getValorMax() && valor>=dado.getValorMin());
			System.out.println(valor);
		}
		
	}
	
	@Test
	public void tirarNuevoDadoTest(){
		int valorMin=8;
		int valorMax=15;
		
		dado = new Dado(valorMin, valorMax);
		for (int i = 0; i < 300; i++) {
			int valor=dado.tirarDado();
			assertTrue(valor<=valorMax && valor>=valorMin);
		}
	}

}