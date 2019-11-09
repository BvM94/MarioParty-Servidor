package comunicaciones;

import java.awt.Color;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

public class AltaJugador implements Serializable {

	private String nick;
	private Color color;
	private Socket socket;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	
	
	public AltaJugador(String nick, Color color) {
		super();
		this.nick = nick;
		this.color = color;

	}


	public String getNick() {
		return nick;
	}


	public void setNick(String nick) {
		this.nick = nick;
	}


	public Color getColor() {
		return color;
	}


	public void setColor(Color color) {
		this.color = color;
	}


	public Socket getSocket() {
		return socket;
	}


	public void setSocket(Socket socket) {
		this.socket = socket;
	}


	public ObjectInputStream getIn() {
		return in;
	}


	public void setIn(ObjectInputStream in) {
		this.in = in;
	}


	public ObjectOutputStream getOut() {
		return out;
	}


	public void setOut(ObjectOutputStream out) {
		this.out = out;
	}
	
	
	
	
}
