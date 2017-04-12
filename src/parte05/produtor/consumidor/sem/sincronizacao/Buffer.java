package parte05.produtor.consumidor.sem.sincronizacao;

public interface Buffer {

	// place integer value into b
	public void set(int value) throws InterruptedException;
	
	// obtain integer value from buffer
	public int get() throws InterruptedException;
}