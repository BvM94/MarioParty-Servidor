package entities;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		

//		//prueba ingresar direccion por teclado 
//		boolean [] dir = {true, false, true, false};
//		Casilla casilla = new CasillaParalizar(0,0,dir,3);
//		casilla.mostrarDireccionesPosibles();
//		System.out.println(casilla.ingresarDireccion());
		
		
		List<Jugador> listaJug = new ArrayList<Jugador>();
		listaJug.add(new Jugador("Batman", Color.RED));
		listaJug.add(new Jugador("Robin", Color.BLUE));
		listaJug.add(new Jugador("Superman", Color.BLACK));
		
		Mapa m = new Mapa(listaJug,50);
	}

}
