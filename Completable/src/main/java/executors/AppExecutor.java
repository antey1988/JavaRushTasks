package executors;

import java.util.concurrent.*;

public class AppExecutor {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> task = () -> Thread.currentThread().getName();
        ExecutorService service = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 5; i++) {
            Future<String> result = service.submit(task);
            System.out.println(result.get() + " step: " + i);
        }
        service.shutdown();
    }
}
