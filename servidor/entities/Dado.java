package entities;

public class Dado {
	
	private int valorMax;
	private int valorMin;
	
	public Dado(int min,int max) {
		this.valorMax = max;
		this.valorMin = min;
	}

	public int getValorMax() {
		return valorMax;
	}

	public int getValorMin() {
		return valorMin;
	}
	
	public int tirarDado() {
		return this.valorMin + (int) (Math.random() * (this.valorMax - this.valorMin +1));
	}

}
