
import entities.Personaje;
import static org.junit.Assert.*;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import entities.Jugador;
import entities.Mapa;
import entities.Personaje;
import entities.casilla.Casilla;
import entities.casilla.CasillaGanarEstrella;
import entities.casilla.CasillaParalizar;
import entities.casilla.CasillaSumarRestarMonedas;


public class CasillaTest {

	private Casilla casilla;
	

	@Test
	public void testCasillaGanarEstrellas() {
		
		boolean [] dir = {true, true, false, false};
		casilla = new CasillaGanarEstrella(0,0,dir);
		
		Personaje pj  = new Personaje("Batman",Color.RED);
		pj.setCasillaActual(casilla);
		
		assertEquals(0, pj.getEstrellas());
		pj.getCasillaActual().aplicarEfecto(pj);
		assertEquals(1, pj.getEstrellas());
		
	}
	
	@Test
	public void testCasillaSumarRestarMonedas() {
		
		boolean [] dir = {true, true, false, false};
		casilla = new CasillaSumarRestarMonedas(0,0,dir,50);
		
		Personaje pj  = new Personaje("Batman",Color.red);
		pj.setCasillaActual(casilla);

		assertEquals(0, pj.getMonedas());
		pj.getCasillaActual().aplicarEfecto(pj);
		assertEquals(50, pj.getMonedas());

		Casilla casillaResta = new CasillaSumarRestarMonedas(0,0,dir,-10);
		pj.setCasillaActual(casillaResta);
		pj.getCasillaActual().aplicarEfecto(pj);
		assertEquals(40, pj.getMonedas());
		
		casillaResta = new CasillaSumarRestarMonedas(0,0,dir,-45);
		pj.setCasillaActual(casillaResta);
		pj.getCasillaActual().aplicarEfecto(pj);
		assertEquals(0, pj.getMonedas());
		
	}
	
	@Test
	public void testCasillaParalizado() {
		
		boolean [] dir = {true, true, false, false};
		casilla = new CasillaParalizar(0,0,dir,3);
		
		Personaje pj  = new Personaje("Batman",Color.red);
		pj.setCasillaActual(casilla);

		assertEquals("Normal", pj.getEstado());
		pj.getCasillaActual().aplicarEfecto(pj);
		assertEquals(3, pj.getTurnosParalizados());
		assertEquals("Paralizado", pj.getEstado());
		
	}
	
	@Test
	public void testcalcularTotalDirecciones() {
		
		boolean [] dir = {true, false, true, false};
		casilla = new CasillaParalizar(0,0,dir,3);
		assertEquals(2, casilla.getcantidadDirecciones());
		
		boolean [] dir2 = {true, false, false, false};
		casilla = new CasillaParalizar(0,0,dir2,2);
		assertEquals(1, casilla.getcantidadDirecciones());
	}
	
	@Test
	public void testDesocuparCasilla() {
		
		boolean [] dir = {true, false, true, false};
		casilla = new CasillaParalizar(0,0,dir,3);
		
		Personaje pj  = new Personaje("Batman",Color.red);
		pj.setCasillaActual(casilla);
		casilla.setPersonajePosicionado(pj);
		Personaje pj2  = new Personaje("Robin",Color.red);
		pj.setCasillaActual(casilla);
		casilla.desocuparCasilla(pj2);
		assertEquals(pj,casilla.getPersonajePosicionado());
		casilla.desocuparCasilla(pj);
		assertEquals(null,casilla.getPersonajePosicionado());
	}
	
	
	@Test
	public void testCalcularCasillaSiguiente() throws FileNotFoundException {
		//prueba con el tablero1.txt
		List<Jugador> listaJug = new ArrayList<Jugador>();
		listaJug.add(new Jugador("Batman",Color.red));
		listaJug.add(new Jugador("Robin",Color.red));
		listaJug.add(new Jugador("Superma",Color.red));
		listaJug.add(new Jugador("Mujer Maravilla",Color.red));
		
		Mapa m = new Mapa(listaJug,5);
		
		//abajo
		 Casilla casillaActual = m.obtenerCasilla(0, 0);
		 Casilla casillaSig = m.obtenerCasilla(1, 0);
		 assertEquals(casillaSig,casillaActual.casillaSiguiente(m));
		 
		 //izquierda
		 casillaActual = m.obtenerCasilla(0, 1);
		 casillaSig = m.obtenerCasilla(0, 0);
		 assertEquals(casillaSig,casillaActual.casillaSiguiente(m));
		 
		 //derecha
		 casillaActual = m.obtenerCasilla(4, 0);
		 casillaSig = m.obtenerCasilla(4, 1);
		 assertEquals(casillaSig,casillaActual.casillaSiguiente(m));
		 
		 //arriba
		 //casillaActual = m.obtenerCasilla(3, 2);
		 casillaActual = m.obtenerCasilla(4, 4);
		 casillaSig = m.obtenerCasilla(3, 4);
		 assertEquals(casillaSig,casillaActual.casillaSiguiente(m));
		 
		 //caso en el que no puede calcular siguiente con este metodo porque tiene mas de una direccion
		 casillaActual = m.obtenerCasilla(4, 2);
		 assertEquals(null,casillaActual.casillaSiguiente(m));
	}
	
	
}
