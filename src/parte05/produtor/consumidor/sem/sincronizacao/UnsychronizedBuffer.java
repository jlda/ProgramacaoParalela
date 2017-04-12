package parte05.produtor.consumidor.sem.sincronizacao;

public class UnsychronizedBuffer implements Buffer {
	
	private int buffer = -1;
	
	public void set(int value) throws InterruptedException {
		System.out.printf("Producer writers\t%2d", value);
		buffer = value;
	}
	
	public int get() throws InterruptedException {
		System.out.printf("Consumer reads\t%2d", buffer);
		return buffer;
	}

}
