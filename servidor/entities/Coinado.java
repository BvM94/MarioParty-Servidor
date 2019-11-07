package entities;

import java.util.List;

import entities.Personaje;

public class Coinado extends Articulo {

	@Override
	public void usarArticulo(Personaje pj, List<Personaje> listPj) {
		int monedasRobadas=0;
		for(Personaje p:listPj) {
			if(!pj.equals(p)) {
					monedasRobadas+=5;
			p.sumarRestarMonedas(-5);	
			}	
		}
		pj.sumarRestarMonedas(monedasRobadas);
	}

	@Override
	public int getEfecto() {
		return 1;
	}

	@Override
	public String getNombre() {
		return "RobaMonedas";
	}





}