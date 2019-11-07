package entities;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entities.Articulo;
import entities.casilla.Casilla;

public class Personaje implements Comparable<Personaje> {

	private String nombre;
	private List<Articulo> items;
	private int monedas;
	private int estrellas;
	private String estado;
	private Casilla casillaActual;
	private int casillasExtras;
	private int turnosParalizados;
	
	//para parte visual
	private Color color;

	// Se le pone un nombre al personaje (nickname)
	public Personaje(String nom, Color color) {
		// this.turno = false;
		this.nombre = nom;
		this.monedas = 0;
		this.estrellas = 0;
		this.estado = "Normal";
		// this.numJug = num;
		this.items = new ArrayList<Articulo>();
		this.color = color;
	}
	
	public Color getColor(){
		return color;
	}

	// Funciones del personaje
	
	@Override
	public int compareTo(Personaje otro) {
		if(this.estrellas > otro.estrellas) {
			return -1;
		}
		if(this.estrellas == otro.estrellas && this.monedas > otro.monedas) {
				return -1;
		}
		
		if(this.estrellas == otro.estrellas && this.monedas == otro.monedas) {
			return 0;
		}
		return 1;
	}

	public void sumarRestarMonedas(int cantMonedas) {
		this.monedas += cantMonedas;
		if (this.monedas < 0) {
			this.monedas = 0;
		}
	}

	public void obtenerEstrella() {
		this.estrellas++;
	}

	public boolean esGanador(int estrellasVictoria) {
		return this.estrellas >= estrellasVictoria;
	}

	public void paralizado(int num) {
		this.setEstado("Paralizado");
		this.turnosParalizados += num;
	}
	
	public boolean hayColision() {
		return this.casillaActual.getPersonajePosicionado() != null;
	}

	public void curarParalisis(int num) {
		this.turnosParalizados -= num;

		if (this.turnosParalizados <= 0) {
			this.setEstado("Normal");
			this.turnosParalizados = 0;
		}
	}

	public boolean puedeMoverse() {
		return this.estado != "Paralizado";
	}

public void retroceder(int posiciones, Mapa mapa) {
		Personaje pjAux;
		casillaActual.desocuparCasilla(this);
		
		for (int i = 0; i < posiciones; i++) {
			casillaActual = casillaActual.getCasillaAnt();
			pjAux = this.casillaActual.getPersonajePosicionado();
			this.casillaActual.setPersonajePosicionado(this);
			mapa.redibujar();
			this.casillaActual.setPersonajePosicionado(pjAux);
		}
		
		this.llegar(false,mapa);
	}

	public void avanzar(int posiciones, Mapa mapa) {
		
		if (puedeMoverse()) {
			Personaje pjAux;
			casillaActual.desocuparCasilla(this);
			for (int i = 0; i < casillasExtras ; i++) {
				this.casillaActual = this.casillaActual.casillaODesicionSig(mapa, this);
				pjAux = this.casillaActual.getPersonajePosicionado();
				this.casillaActual.setPersonajePosicionado(this);
				mapa.redibujar();
				this.casillaActual.setPersonajePosicionado(pjAux);
			}
			setCasillasExtras(0);
			for (int i = 0; i < posiciones; i++) {
				this.casillaActual = this.casillaActual.casillaODesicionSig(mapa, this);
				pjAux = this.casillaActual.getPersonajePosicionado();
				this.casillaActual.setPersonajePosicionado(this);
				mapa.redibujar();
				this.casillaActual.setPersonajePosicionado(pjAux);
			}
			this.llegar(true,mapa);
		}
		else {
			// no avanza jugador paralizado
			System.out.println(this.nombre +" no puede avanzar esta PARALIZADO");
			this.curarParalisis(1);
		}
	}

	public void llegar(boolean llegarConEfecto,Mapa mapa) {
		if (hayColision()) {
			Personaje personajePosicionado = casillaActual.getPersonajePosicionado();
			this.casillaActual.setPersonajePosicionado(this);
			System.out.println(personajePosicionado.nombre +" fue PISADO retrocede 2 casillas");
			personajePosicionado.retroceder(2,mapa);
		}else {
			this.casillaActual.setPersonajePosicionado(this);
		}
		if(llegarConEfecto) {
			casillaActual.aplicarEfecto(this);
		}
	}
	
	public void recogerItem(Articulo articulo) {
		this.items.add(articulo);
	}

	public Personaje seleccionarPersonaje(List<Personaje> jugadores) {
		int i = 0;
		String[] pjs = new String[jugadores.size()];
		for (Personaje pj : jugadores) {
			pjs[i] = pj.getNombre();
			i++;
		}
		String resp = (String) JOptionPane.showInputDialog(null, "Seleccione el personaje a aplicar el item", "Items", JOptionPane.DEFAULT_OPTION,null,pjs,pjs[0]);
		for(i = 0;i < jugadores.size() ; i++) {
			if(pjs[i] == resp) {
				return jugadores.get(i);
			}
		}
		return null;
	}

	public int elegirItem() {
		String[] items = new String[getItems().size()];
		for(int i = 0 ; i < getItems().size(); i++) {
			items[i] = getItems().get(i).getNombre();
		}
		String resp = (String) JOptionPane.showInputDialog(null, "Seleccione un item a utilizar", "Items", JOptionPane.DEFAULT_OPTION,null,items,items[0]);
		for(int i = 0; i< getItems().size(); i++) {
			if(resp == items[i]) {
				return i;
			}
		}
		return -1;
	}

	public void usarItem(int itemNumber, List<Personaje> jugadores) {
		Personaje eleccion;
		if (this.items.get(itemNumber).getEfecto() == 1) {
			eleccion = this.seleccionarPersonaje(jugadores);
			this.items.get(itemNumber).usarArticulo(eleccion, jugadores);
		} else {
			this.items.get(itemNumber).usarArticulo(this, jugadores);
		}
		this.items.remove(itemNumber);
	}


	// Setters y Getters

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getMonedas() {
		return monedas;
	}

	public void setMonedas(int monedas) {
		this.monedas = monedas;
	}

	public int getEstrellas() {
		return estrellas;
	}

	public Casilla getCasillaActual() {
		return casillaActual;
	}

	public void setCasillaActual(Casilla casillaActual) {
		this.casillaActual = casillaActual;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getTurnosParalizados() {
		return turnosParalizados;
	}

	public int getCasillasExtras() {
		return this.casillasExtras;
	}
	
	public void setCasillasExtras(int cas) {
		this.casillasExtras = cas;
	}

	public List<Articulo> getItems() {
		return items;
	}

	public void setItems(List<Articulo> items) {
		this.items = items;
	}


}
