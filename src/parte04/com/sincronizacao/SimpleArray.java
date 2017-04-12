package parte04.com.sincronizacao;


// Class that manages a integer array to be shared with multiple threads
import java.util.Arrays;
import java.util.Random;

public class SimpleArray { // Caution! Not Thread Safe

	private final int[] array; // the shared integer array
	private int writeIndex = 0;
	private final static Random generator = new Random();
	
	
	// construct a simple array with given size
	public SimpleArray(int size) {
		array = new int[size];
	} // end constructor
	
	// add a value to the shared array
	public synchronized void add(int value) {
		int position = writeIndex;
		
		try {
			// put thread to sleep for 0-499 milliseconds
			Thread.sleep(generator.nextInt(500));
		} catch(InterruptedException ex) {
			ex.printStackTrace();
		}
		
		array[ position ] = value;
		System.out.printf("%s wrote %2d to element %d\n",
				Thread.currentThread().getName(), value, position);
		
		++writeIndex;
		System.out.printf("Next write index: %d\n", writeIndex);
	}
	
	public String toString() {
		return "\nContents of SimpleArray:\n" + Arrays.toString(array);
	}	
}
