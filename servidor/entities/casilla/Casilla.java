package entities.casilla;
import entities.Mapa;
import entities.Personaje;
import entities.threads.EsperarThread;

public class Casilla {
	private int x;
	private int y;
	private boolean[] direcciones; // N,S,E,O
	private Casilla casillaAnt;
	private Personaje personajePosicionado;
	private int cantidadDirecciones = 0;
	final static private String[] nombreDireccion = { "Arriba", "Abajo", "Derecha", "Izquierda" };
	
	private boolean estaTitilando = false;

	public Casilla(int x, int y, boolean[] direcciones) {
		this.x = x;
		this.y = y;
		this.direcciones = direcciones;
		calcularTotalDirecciones();
	}

	public void aplicarEfecto(Personaje pj) {
		System.out.println("Se aplico efecto.");
	}

	private void calcularTotalDirecciones() {
		for (int i = 0; i < direcciones.length; i++) {
			if (direcciones[i]) {
				cantidadDirecciones++;
			}
		}
	}

	// N,S,E,O direcciones posibles
	// retorna null si hay mas de una direccion posible
	public Casilla casillaSiguiente(Mapa mapa) {

		if (this.cantidadDirecciones == 1) {
			int i = 0;
			while (i < direcciones.length - 1 && direcciones[i] == false) {
				i++;
			}
			return calcularCasilla(mapa, i);
		}
		return null;
	}

	public Casilla decisionSiguiente(Mapa mapa, Personaje personaje) {
		mostrarDireccionesPosibles();
		int respuesta = ingresarDireccion(mapa, personaje);
		while(!this.direcciones[respuesta]){
			System.out.println("No se puede mover ahi");
			respuesta = ingresarDireccion(mapa, personaje);
		}
		System.out.println("respuesta: " + respuesta);
		
		return calcularCasilla(mapa, respuesta);
	}

	// 0 = norte(arriba) - 1 = sur (abajo) - 2 = este(derecha) - 3 =
	// oeste(izquierda)
	private Casilla calcularCasilla(Mapa mapa, int direccion){
		
		switch (direccion) {
		case 0:
			return mapa.obtenerCasilla(this.x - 1, this.y);
		case 1:
			return mapa.obtenerCasilla(this.x + 1, this.y);
		case 2:
			return mapa.obtenerCasilla(this.x, this.y + 1);
		case 3:
			return mapa.obtenerCasilla(this.x, this.y - 1);
		}
		return null;
	}

	// si la eleccion es true: la direccion que toma es la primera habilitada
	// (recorriendo el vector desde el principio)
	// si la eleccion es false: la direccion que toma es la segunda habilitada
	// (recorriendo el vector desde el principio)

	public void mostrarDireccionesPosibles() {

		System.out.println("Direcciones posibles: ");

		for (int i = 0; i < direcciones.length; i++) {
			if (direcciones[i]) {
				System.out.println(i + " : " + nombreDireccion[i]);
			}
		}
	}

	public void desocuparCasilla(Personaje pj) {
		if (this.personajePosicionado == pj) {
			this.personajePosicionado = null;
		}
	}
	
	public Casilla casillaODesicionSig(Mapa mapa, Personaje personaje) {
		if (getcantidadDirecciones() > 1) {
			return decisionSiguiente(mapa, personaje);
		} else {
			return casillaSiguiente(mapa);
		}
	}

	public int ingresarDireccion(Mapa mapa, Personaje personaje) {
		//comienza a escuchar teclas
		mapa.escucharTeclas();
		
		//setea al personaje en la casilla temporalmente para eliminar bug
		setPersonajePosicionado(personaje);
		while(mapa.getTeclaPresionada() == -1) {
			titilar(mapa, true, personaje);
			new EsperarThread(50).run();
			titilar(mapa, false, personaje);
		}
		desocuparCasilla(personaje);
		int teclaPresionada = mapa.getTeclaPresionada();
		mapa.limpiarTeclaPresionada();
		return teclaPresionada;	
	}

	//Los lugares a donde puede moverse el personaje titilan
	private void titilar(Mapa mapa, boolean estaTitilando, Personaje personaje) {
		for (int i = 0; i < direcciones.length; i++) {
			if(direcciones[i]) {
				calcularCasilla(mapa, i).setEstaTitilando(estaTitilando);
			}
		}
		mapa.redibujar();
	}

//	private void cerrarPrimera() {
//	int i = 0;
//	while (!this.direcciones[i])	i++;
//	this.direcciones[i] = false;
//}
//
//private void cerrarUltima() {
//	int i = this.direcciones.length - 1;
//	while (!this.direcciones[i])	i--;
//	this.direcciones[i] = false;
//}

//public boolean casillaPisada(Personaje pj) {
//	return pj.getCasillaActual().getX() == this.x;
//}

	// getter y setter

	public int getcantidadDirecciones() {
		return this.cantidadDirecciones;
	}

	public boolean[] getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(boolean[] direcciones) {
		this.direcciones = direcciones;
	}

	public Personaje getPersonajePosicionado() {
		return personajePosicionado;
	}

	public void setPersonajePosicionado(Personaje personajePosicionado) {
		this.personajePosicionado = personajePosicionado;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Casilla getCasillaAnt() {
		return casillaAnt;
	}

	public void setCasillaAnt(Casilla casillaAnt) {
		this.casillaAnt = casillaAnt;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	public void setEstaTitilando(boolean estaTitilando) {
		this.estaTitilando = estaTitilando;
	}
	
	public boolean estaTitilando() {
		return estaTitilando;
	}

}