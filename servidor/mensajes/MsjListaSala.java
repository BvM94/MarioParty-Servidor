package mensajes;

import java.io.Serializable;
import java.util.ArrayList;

public class MsjListaSala implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<String> nombreSalas;

	public MsjListaSala(ArrayList<String> nombreSalas) {
		this.nombreSalas = nombreSalas;
	}

	public ArrayList<String> getNombreSalas() {
		return nombreSalas;
	}
}
