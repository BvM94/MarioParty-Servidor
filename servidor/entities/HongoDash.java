package entities;

import java.util.List;

import entities.Personaje;

public class HongoDash extends Articulo{

	@Override
	public void usarArticulo(Personaje pj, List<Personaje> listPj) {
		pj.setCasillasExtras(3);
		
	}

	@Override
	public int getEfecto() {
		return 0;
	}

	@Override
	public String getNombre() {
		return "HongoDash";
	}

}