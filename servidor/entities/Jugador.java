package entities;

import java.awt.Color;

public class Jugador {
	
	private String nickName;
	private String estado;
	private String clave;
	private Color color;
	
	public Jugador(String nick, Color color) {
		this.nickName = nick;
		//this.clave = clave;
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void estadoListo() {
		this.estado = "Listo";
	}

}