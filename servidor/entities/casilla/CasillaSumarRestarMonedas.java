package entities.casilla;

import entities.Personaje;

public class CasillaSumarRestarMonedas extends Casilla {
	private int monedas;

	public CasillaSumarRestarMonedas(int x, int y, boolean[] direcciones, int monedas) {
		super(x, y, direcciones);
		this.monedas=monedas;
	}

	public void aplicarEfecto(Personaje pj) {
		pj.sumarRestarMonedas(this.monedas);
	}

}
