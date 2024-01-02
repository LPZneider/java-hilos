package org.lpzneider.hilos.executor;

import java.util.concurrent.*;

public class EjemploScheduledExecutorServicePeriodo {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

        System.out.println("Tarea en el main");

        CountDownLatch lock = new CountDownLatch(5);

        Future<?> future = executorService.scheduleAtFixedRate(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
                lock.countDown();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Hola mundo tarea...");
        }, 1000, 2000,TimeUnit.MILLISECONDS);

        lock.await();
        future.cancel(true);
        // TimeUnit.SECONDS.sleep(10);
        System.out.println("Alguna otra tarea en el main");
        executorService.shutdown();

    }
}
