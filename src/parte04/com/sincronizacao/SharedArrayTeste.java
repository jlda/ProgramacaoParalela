package parte04.com.sincronizacao;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class SharedArrayTeste {

	public static void main(String[] args) {

		SimpleArray sharedSimpleArray = new SimpleArray(6);
		
		// create two tasks to write to the sharedSimpleArray
		ArrayWriter writer1 = new ArrayWriter(1, sharedSimpleArray);
		ArrayWriter writer2 = new ArrayWriter(11, sharedSimpleArray);
	
		// execute the tasks with an ExecutorService
		ExecutorService executor = Executors.newCachedThreadPool();
		executor.execute(writer1);
		executor.execute(writer2);
		
		executor.shutdown();
		
		try {
			boolean tasksEnded = executor.awaitTermination(1, TimeUnit.MINUTES);
		
			if (tasksEnded) {
				System.out.println(sharedSimpleArray);
			} else {
				System.out.println("Timed out while waiting for tasks to finish");
			}
		} catch (Exception ex) {
			System.out.println("Interrupted while waiting fot the taks to finish");
		}		
		
	}

}
