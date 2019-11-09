package entities;

import java.io.Serializable;
import java.util.List;

public abstract class Minijuego implements Serializable  {

	protected List<Personaje> jugadores;
	private boolean inicio;
	
	public abstract void jugar(List<Personaje> jugadores);

}