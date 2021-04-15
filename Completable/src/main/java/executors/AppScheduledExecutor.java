package executors;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AppScheduledExecutor {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);
        Runnable task = () -> {
            int t = (int) (1000 + Math.random() * 3000);
            try {
                TimeUnit.MILLISECONDS.sleep(t);
            } catch (InterruptedException e ) {
                Thread.currentThread().interrupt();
            }
            System.out.println(Thread.currentThread().getName() + " sleeped " + t);
        };
//        scheduledExecutorService.schedule(task, 1, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleWithFixedDelay(task, 0, 500, TimeUnit.MILLISECONDS);
//        scheduledExecutorService.shutdown();
    }
}
