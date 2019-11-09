package entities;


import java.awt.Color;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Jugador {
	
	private String nickName;
	private String estado;
	private String clave;
	private Color color;
	private Socket socket;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	
	
	
	public Jugador(String nick, Color color,Socket socket, ObjectInputStream in, ObjectOutputStream out) {
		this.nickName = nick;
		this.color = color;
		this.socket = socket;
		this.in = in;
		this.out = out;
		
		
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