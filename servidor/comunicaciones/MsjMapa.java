package comunicaciones;

import java.io.Serializable;

import entities.Mapa;

public class MsjMapa implements Serializable {
	private static final long serialVersionUID = 1L;
	private Mapa mapa;
	
	public MsjMapa(Mapa mapa) {
		this.mapa = mapa;
	}
	
	public Mapa getMapa() {
		return mapa;
	}
}
