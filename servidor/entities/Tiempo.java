package entities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

import javax.swing.Timer;

public class Tiempo {

	private Instant tiempo;
	private Timer contador;
	
	public Tiempo() {
		this.contador = new Timer(1000, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					tiempo.plusSeconds(1);
				}
			}
		);
	}


	public void iniciar() {
		if(!contador.isRunning()) {
			this.tiempo = Instant.ofEpochMilli(0);
			contador.start();
		}
	}

	public void pausar() {
		if(contador.isRunning())
			contador.stop();
	}

	public void reanudar() {
		if(!contador.isRunning())
			contador.start();
	}
	
	public void detener() {
		if(contador.isRunning()) {
			this.tiempo = Instant.ofEpochMilli(0);
			contador.stop();
		}
	}
	
	public void reiniciar() {
		this.tiempo = Instant.ofEpochMilli(0);
		contador.restart();
	}
	
}
