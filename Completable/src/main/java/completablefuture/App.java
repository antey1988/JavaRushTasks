package completablefuture;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.concurrent.atomic.*;
import java.lang.Runnable;
import java.lang.Long;

public class App {

    public static void main(String []args) throws Exception {

        AtomicLong longValue = new AtomicLong(0);
        Runnable task = () -> longValue.set(new Date().getTime());
        Function<Long, Date> dateConverter = Date::new;
        Consumer<Date> printer = System.out::println;
        // CompletableFuture computation
        CompletableFuture
                .runAsync(task)
//        CompletableFuture<Void> cf =  new CompletableFuture<Long>()
                .thenApplyAsync(v -> longValue.get())
//                .thenApply(v -> longValue.get())
                .thenApply(dateConverter)
                .thenAccept(printer)
                .get();

        // CompletableFuture уже содержащий результат
        CompletableFuture<String> completed;
        completed = CompletableFuture.completedFuture("Просто значение");
        // CompletableFuture, запускающий (run) новый поток с Runnable, поэтому он Void
        CompletableFuture<Void> voidCompletableFuture;
        voidCompletableFuture = CompletableFuture.runAsync(() -> {
            System.out.println("run " + Thread.currentThread().getName());
        });
        // CompletableFuture, запускающий новый поток, результат которого возьмём у Supplier
        CompletableFuture<String> supplier;
        supplier = CompletableFuture.supplyAsync(() -> {
            System.out.println("supply " + Thread.currentThread().getName());
            return "Значение";
        });
        supplier.get();

        Supplier<String> one = () -> "Message";
        CompletableFuture<String> reader = CompletableFuture.supplyAsync(one);
        CompletableFuture.completedFuture("!!")
                .thenCombine(reader, (a, b)->b + a)
                .thenAccept(System.out::println)
                .get();

        CompletableFuture.completedFuture(2)
                .thenCompose((val)->CompletableFuture.completedFuture(val + 2))
                .thenAccept(System.out::println);

        CompletableFuture.runAsync(()->System.out.println("Message1"))
                .thenApply(a->"Message0")
                .thenAcceptBoth(CompletableFuture.completedFuture("Message2"),(a, b)-> System.out.println(a + " " + b))
                .get();
//        Thread.sleep(1000);
    }
}
