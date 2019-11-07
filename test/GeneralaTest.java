

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import entities.Personaje;
import minijuegos.generala.Generala;

public class GeneralaTest {

	

	@Test
	public void testSeDanMonedas() {

		List<Personaje> listaJug = new ArrayList<Personaje>();
		listaJug.add(new Personaje("Batman"));
		listaJug.add(new Personaje("Robin"));
		listaJug.add(new Personaje("Superma"));
		listaJug.add(new Personaje("Mujer Maravilla"));
		
		Generala juegoGen=new Generala();
		juegoGen.jugar(listaJug);
		
		Personaje ganador=juegoGen.darGanador();
		if(ganador!=null)
			assertEquals(20, ganador.getMonedas());
		else
			assertEquals(3,listaJug.get(0).getMonedas());
		
		
		
	}

}
