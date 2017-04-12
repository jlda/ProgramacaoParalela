package parte02.framework.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class TaskExecutor {

    public static void main(String[] args) {

        Thread thread1 = new Thread(new PrintTask("task1"));
        Thread thread2 = new Thread(new PrintTask("task2"));
        Thread thread3 = new Thread(new PrintTask("task3"));

        System.out.println("Starting executor.");

        // create ExecutorService to manage the threads
        ExecutorService threadExecutor = Executors.newCachedThreadPool();

        // start threads and place in runnable state
        threadExecutor.execute(thread1); // start task 1
        threadExecutor.execute(thread2); // start task 2
        threadExecutor.execute(thread3); // start task 3

        // shut down worker threads when their tasks complete
        threadExecutor.shutdown();

        System.out.println("Tasks started, main ends.");

    }

}
