

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import entities.Personaje;
import minijuegos.encuentraLaBola.EncuentreLaBola;

public class EncuentreLaBolaTest {



	@Test
	public void testSeDanPuntos() {
		List<Personaje> listaJug = new ArrayList<Personaje>();
		listaJug.add(new Personaje("Batman",Color.RED));
		listaJug.add(new Personaje("Robin",Color.RED));
		listaJug.add(new Personaje("Superma",Color.RED));
		listaJug.add(new Personaje("Mujer Maravilla",Color.RED));
		
		EncuentreLaBola juego=new EncuentreLaBola();
		juego.jugar(listaJug);
		
		Personaje ganador=juego.darGanador();
		if(ganador!=null)
			assertEquals(20, ganador.getMonedas());
		else
			assertEquals(3,listaJug.get(0).getMonedas());
		
		
	}

}
