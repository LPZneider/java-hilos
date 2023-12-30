package org.lpzneider.hilos.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class EjemploScheduledExecutorService {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

        System.out.println("Tarea en el main");
        executorService.schedule(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Hola mundo tarea...");
        }, 2000, TimeUnit.MILLISECONDS);

        System.out.println("Alguna otra tarea en el main");
        executorService.shutdown();

    }
}
