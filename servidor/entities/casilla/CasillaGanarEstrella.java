package entities.casilla;

import java.io.Serializable;

import entities.Personaje;

public class CasillaGanarEstrella extends Casilla implements Serializable  {

	public CasillaGanarEstrella(int x, int y, boolean[] direcciones) {
		super(x, y, direcciones);
	}

	public void aplicarEfecto(Personaje pj) {
		pj.obtenerEstrella();
	}
}
