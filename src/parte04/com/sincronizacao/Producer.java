package parte04.com.sincronizacao;

import parte05.produtor.consumidor.sem.sincronizacao.Buffer;

import java.util.Random;

public class Producer implements Runnable{
	
	public final static Random generator = new Random();
	public final Buffer sharedLocation;
	
	public Producer(Buffer shared) {
		sharedLocation = shared;
	}
	
	// share value from 1 to 10 in sharedLocation
	public void run() {
		
		int sum = 0;
		
		for (int count = 1; count <= 10; count++) {
			try { // sleep 0 to 3 seconds, then place the value in Buffer
				Thread.sleep(generator.nextInt(3000)); // random sleep
				sharedLocation.set(count);
				sum+=count;
				System.out.printf("\t%2d\n", sum);
			} 
			catch(InterruptedException exception) {
				exception.printStackTrace();
			}
		}
		
		System.out.println("Producer done producing\nterminating producer");		
	}
}
