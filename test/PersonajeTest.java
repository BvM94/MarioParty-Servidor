

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import entities.Jugador;
import entities.Mapa;
import entities.Personaje;
import entities.casilla.Casilla;
import entities.casilla.CasillaSumarRestarMonedas;

public class PersonajeTest {

	@Test
	public void testSumarRestarMonedas() {
		Personaje pj = new Personaje("Diablo666");

		assertEquals(0, pj.getMonedas());

		pj.sumarRestarMonedas(50);
		assertEquals(50, pj.getMonedas());

		pj.sumarRestarMonedas(-10);
		assertEquals(40, pj.getMonedas());

		pj.sumarRestarMonedas(-45);
		assertEquals(0, pj.getMonedas());
	}

	@Test
	public void testObtenerEstrella() {
		Personaje pj = new Personaje("Diablo666");

		assertEquals(0, pj.getEstrellas());
		pj.obtenerEstrella();
		assertEquals(1, pj.getEstrellas());
		pj.obtenerEstrella();
		assertEquals(2, pj.getEstrellas());
		pj.obtenerEstrella();
		assertEquals(3, pj.getEstrellas());
	}

	@Test
	public void testEsGanador() {
		Personaje pj = new Personaje("Diablo666");
		int estrellasParaGanar = 3;
		pj.obtenerEstrella();
		assertEquals(false, pj.esGanador(estrellasParaGanar));
		pj.obtenerEstrella();
		assertEquals(false, pj.esGanador(estrellasParaGanar));
		pj.obtenerEstrella();
		assertEquals(true, pj.esGanador(estrellasParaGanar));
	}

	@Test
	public void testHayColision() {
		Personaje pj = new Personaje("Diablo666");
		Personaje pjPosicionado = new Personaje("Robin");
		boolean[] dir = { true, true, false, false };
		Casilla casilla = new CasillaSumarRestarMonedas(0, 0, dir, 50);
		pj.setCasillaActual(casilla);
		assertEquals(false, pj.hayColision());

		pjPosicionado.setCasillaActual(casilla);
		casilla.setPersonajePosicionado(pjPosicionado);
		assertEquals(true, pj.hayColision());
	}

	@Test
	public void testParalizado() {
		Personaje pj = new Personaje("Diablo666");
		assertEquals("Normal", pj.getEstado());
		pj.paralizado(5);
		assertEquals("Paralizado", pj.getEstado());
		assertEquals(5, pj.getTurnosParalizados());
	}
	
	@Test
	public void testCurarParalisis() {
		Personaje pj = new Personaje("Diablo666");
		pj.paralizado(3);
		pj.curarParalisis(2);
		assertEquals(1, pj.getTurnosParalizados());
		assertEquals("Paralizado", pj.getEstado());
		pj.curarParalisis(2);
		assertEquals(0, pj.getTurnosParalizados());
		assertEquals("Normal", pj.getEstado());
		pj.paralizado(3);
		pj.curarParalisis(3);
		assertEquals(0, pj.getTurnosParalizados());
		assertEquals("Normal", pj.getEstado());
	}
	
	public void testPuedeMoverse() {
		Personaje pj = new Personaje("Diablo666");
		pj.paralizado(2);
		assertEquals(false, pj.puedeMoverse());
		pj.curarParalisis(2);
		assertEquals(true, pj.puedeMoverse());
	}
	
	@Test
	public void testRetroceder() {
		Personaje pj = new Personaje("Diablo666");
		boolean[] dir = { true, true, false, false };
		Casilla casillaInicial = new CasillaSumarRestarMonedas(0, 0, dir, 50);
		Casilla casillaMedio = new CasillaSumarRestarMonedas(0, 1, dir, 50);
		Casilla CasillaFinal =  new CasillaSumarRestarMonedas(0, 2, dir, 50);
		casillaInicial.setCasillaAnt(casillaMedio);
		casillaMedio.setCasillaAnt(CasillaFinal);
		
		pj.setCasillaActual(casillaInicial);
		assertEquals(casillaInicial, pj.getCasillaActual());
		System.out.println(pj.getCasillaActual().getY());
		pj.retroceder(2,null);
		assertEquals(CasillaFinal, pj.getCasillaActual());
		System.out.println(pj.getCasillaActual().getY());
	}
	
	@Test
	public void testRetrocesoEnCadena() throws FileNotFoundException {
		//test con mapa tablero1.txt
		Personaje pj1 = new Personaje("Batman");
		Personaje pj2 = new Personaje("Bromas");
		Personaje pj3 = new Personaje("CAT");
		
		List<Jugador> listaJug = new ArrayList<Jugador>();
		listaJug.add(new Jugador("Batman"));
		listaJug.add(new Jugador("Bromas"));
		listaJug.add(new Jugador("CAT"));
		Mapa m = new Mapa(listaJug,5);

		Casilla casilla1 = m.obtenerCasilla(3, 4);
		Casilla casilla2 = m.obtenerCasilla(4, 3);
		Casilla casilla3 = m.obtenerCasilla(4, 1);
		
		casilla1.setPersonajePosicionado(pj1);
		casilla2.setPersonajePosicionado(pj2);
		pj1.setCasillaActual(casilla1);
		pj2.setCasillaActual(casilla2);
		pj3.setCasillaActual(casilla1);
		
		pj3.llegar();
		
		assertEquals(pj1,casilla2.getPersonajePosicionado());
		assertEquals(pj2,casilla3.getPersonajePosicionado());
		assertEquals(pj3,casilla1.getPersonajePosicionado());
		
		assertEquals(casilla1,pj3.getCasillaActual());
		assertEquals(casilla2,pj1.getCasillaActual());
		assertEquals(casilla3,pj2.getCasillaActual());
	}
	
	@Test
	public void testLlegarNuevaCasilla() throws FileNotFoundException {
		//test con mapa tablero1.txt
		Personaje pjposicionado = new Personaje("Batman");
		Personaje pjllega = new Personaje("Bromas");
		
		List<Jugador> listaJug = new ArrayList<Jugador>();
		listaJug.add(new Jugador("Batman"));
		listaJug.add(new Jugador("Bromas"));
		Mapa m = new Mapa(listaJug,5);

		Casilla casillaNueva = m.obtenerCasilla(3, 4);
		Casilla casillaRetroceso = m.obtenerCasilla(4, 3);
		
		casillaNueva.setPersonajePosicionado(pjposicionado);
		pjposicionado.setCasillaActual(casillaNueva);
		pjllega.setCasillaActual(casillaNueva);
		
		pjllega.llegar();
		
		assertEquals(pjllega,casillaNueva.getPersonajePosicionado());
		assertEquals(pjposicionado,casillaRetroceso.getPersonajePosicionado());
		assertEquals(casillaRetroceso,pjposicionado.getCasillaActual());
		assertEquals(casillaNueva,pjllega.getCasillaActual());
		assertEquals("Paralizado",pjllega.getEstado());

	}


}
