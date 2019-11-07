package entities.casilla;

import entities.Personaje;

public class CasillaGanarEstrella extends Casilla {

	public CasillaGanarEstrella(int x, int y, boolean[] direcciones) {
		super(x, y, direcciones);
	}

	public void aplicarEfecto(Personaje pj) {
		pj.obtenerEstrella();
	}
}
