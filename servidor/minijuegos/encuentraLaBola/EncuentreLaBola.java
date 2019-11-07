package minijuegos.encuentraLaBola;



import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import entities.Minijuego;
import entities.Personaje;
import minijuegos.generala.PuntajesAnuncio;

public class EncuentreLaBola extends Minijuego {

	private int elecciones[];
	private List<Personaje> jugadores;
	private int respuesta;
	private JencuentreLaBola frameEnc;
	private int jugAct;

	public EncuentreLaBola() {

	}

	@Override
	public void jugar(List<Personaje> jugadores) {
		this.elecciones = new int[jugadores.size()];
		this.jugadores = jugadores;
		jugAct = 0;

		this.respuesta = (int) (4 * Math.random()) + 1;
		frameEnc = new JencuentreLaBola(this);
		frameEnc.setVisible(true);

	}

	public void setElecciones(int eleccion) {
		elecciones[jugAct] = eleccion;
		jugAct++;
		if (jugAct == elecciones.length) {
			darPuntos();
		}

	}

	public void darPuntos() {
		int i = 0;
		for (Personaje j : jugadores) {
			if (elecciones[i] != respuesta)
				j.sumarRestarMonedas(3);
			else
				j.sumarRestarMonedas(20);
		}
		anunciar();
	}

	public void anunciar() {
		String msg = "<html>";
		int i = 0;
		for (Personaje j : jugadores) {

			if (elecciones[i] == respuesta)
				msg += j.getNombre() + " Obtuvo: 20 Puntos <br>";
			else
				msg += j.getNombre() + " Obtuvo: 3 Puntos <br>";

			i++;
		}
		msg += "</html>";

		PuntajesAnuncio pAnun = new PuntajesAnuncio(msg);
		pAnun.setVisible(true);
	}

	public Personaje darGanador() {
		Personaje ganador = null;
		int i = 0;
		for (Personaje j : jugadores) {
			if (elecciones[i] == respuesta)
				ganador = j;
		}

		return ganador;
	}

	public String getNombre() {
		return jugadores.get(jugAct).getNombre();
	}

	public boolean haySigTurno() {
		return jugAct != elecciones.length;
	}

	public static void main(String[] args) {

		List<Personaje> listaJug = new ArrayList<Personaje>();
		listaJug.add(new Personaje("Batman", Color.RED));
		listaJug.add(new Personaje("Robin", Color.RED));
		listaJug.add(new Personaje("Superma", Color.RED));
		listaJug.add(new Personaje("Mujer Maravilla", Color.RED));

		EncuentreLaBola juegoGen = new EncuentreLaBola();
		juegoGen.jugar(listaJug);

	}

}
