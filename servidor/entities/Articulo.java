package entities;

import java.util.List;

import entities.Personaje;

public abstract class Articulo {
	public String nombre; //nombre de articulo
	public int efecto; //uno mismo o jugador rival

	abstract public void usarArticulo(Personaje pj,List<Personaje> listPj);
	abstract public int getEfecto();
	abstract public String getNombre();

}