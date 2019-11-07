package entities.threads;

public class EsperarThread extends Thread{
	long tiempo;
	
	public EsperarThread(long tiempo) {
		this.tiempo = tiempo;
	}
	
	@Override
	public void run() {
		try {
			sleep(tiempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
