package entities.casilla;

import entities.Articulo;
import entities.Coinado;
import entities.HongoDash;
import entities.Personaje;

public class CasillaSumarItem extends Casilla {

	public CasillaSumarItem(int x, int y, boolean[] direcciones) {
		super(x, y, direcciones);
	}

	public void aplicarEfecto(Personaje pj) {
		System.out.println("Gano un item aleatorio");
		pj.recogerItem(aleatorio());
	}
	
	public Articulo aleatorio() {
		Articulo[] articulos = new Articulo[] {new Coinado(),
				new HongoDash() };
		int val = (int) (Math.random() * (articulos.length +1));
		return articulos[val];
	}
}
