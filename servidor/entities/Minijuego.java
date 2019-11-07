package entities;

import java.util.List;

public abstract class Minijuego {

	protected List<Personaje> jugadores;
	private boolean inicio;
	
	public abstract void jugar(List<Personaje> jugadores);

}