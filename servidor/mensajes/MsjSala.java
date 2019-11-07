package mensajes;

import java.io.Serializable;

public class MsjSala implements Serializable {
	
	private String nombreSala;
	private String passwordSala;
	private boolean crear;
	private boolean loguerase;
	private boolean eliminar;
	
	
	public MsjSala(String nombreSala, String passwordSala, boolean crear, boolean loguerase, boolean eliminar) {
		this.nombreSala = nombreSala;
		this.passwordSala = passwordSala;
		this.crear = crear;
		this.loguerase = loguerase;
		this.eliminar = eliminar;
	}
	public String getNombreSala() {
		return nombreSala;
	}

	public String getPasswordSala() {
		return passwordSala;
	}

	public boolean isCrear() {
		return crear;
	}
	public boolean isLoguerase() {
		return loguerase;
	}
	
	public boolean isEliminar() {
		return eliminar;
	}
}
