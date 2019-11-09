package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Juego implements Serializable {
	
	private Mapa mapa;
	private List<Personaje> jugadores;
	private List<Integer> dados;
	private Tiempo tiempo;
	private Dado dado;
	
	
	public Juego(List<Personaje> jugadores, Dado dado) {
		this.jugadores = jugadores;
		this.dado = dado;
		this.tiempo = new Tiempo();
	    dados = new ArrayList<Integer>();
		for(int i=0; i<jugadores.size(); i++) {
			dados.add(dado.tirarDado());
		}
		this.reordenar(dados);
			
	}
	
	private void reordenar(List<Integer> dados) {
		List<Personaje> nuevoOrden = new ArrayList<Personaje>();
		for(int i=dado.getValorMin() ; i <= dado.getValorMax(); i++) {
			for(int j=0; j<dados.size(); j++) {
				if(dados.get(j) == i) {
					nuevoOrden.add(this.jugadores.get(j));
				}
			}
		}
	}

	public void cargarMapa(Mapa mapa) {
		this.mapa = mapa;
	}
	
	public void cargarJugadores(List<Personaje> jugadores) {
		this.jugadores = jugadores;
	}

	public void iniciarJuego() {
		tiempo.iniciar();
	}

	public void reiniciarJuego() {
		tiempo.reiniciar();
	}

	public void pausarJuego() {
		tiempo.pausar();
	}
	
	public void reanudarJuego() {
		tiempo.reanudar();
	}

	public void detenerJuego() {
		tiempo.detener();
	}
}
