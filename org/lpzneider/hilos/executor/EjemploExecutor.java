package org.lpzneider.hilos.executor;

import java.util.concurrent.*;

public class EjemploExecutor {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

       // ExecutorService executor = Executors.newSingleThreadExecutor();
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

        System.out.println("Tamanio del pool: " + executor.getPoolSize());
        System.out.println("Cantidad de tareas en cola: " + executor.getQueue().size());

        Callable<String> tarea = () -> {
            System.out.println("Inicio de la Tarea...");
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println("Nombre del thread: " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            System.out.println("Finaliza la tarea");
            return "Algun resultado importante de la tarea";
        };

        Callable<Integer> tarea2 = () -> {
            System.out.println("Iniciando tarea 3 ...");
            TimeUnit.SECONDS.sleep(3);
            return 10;
        };


        Future<String> resultadoFuturo = executor.submit(tarea);
        Future<String> resultadoFuturo2 = executor.submit(tarea);
        Future<Integer> resultadoFuturo3 = executor.submit(tarea2);

        System.out.println("Tamanio del pool: " + executor.getPoolSize());
        System.out.println("Cantidad de tareas en cola: " + executor.getQueue().size());

        executor.shutdown();    //apaga despues que todo se realice

        System.out.println("Continuando con la ejecuccion del metodo main");
        //executor.awaitTermination(2, TimeUnit.SECONDS);
        //System.out.println("Continuando con la ejecuccion del metodo main 2");

        while (!(resultadoFuturo.isDone() && resultadoFuturo2.isDone() && resultadoFuturo3.isDone())) {
            System.out.println(String.format("resultado1: %s  - resultado2: %s - resultado3: %s ",
                    resultadoFuturo.isDone() ? "Finalizo" : "en proceso",
                    resultadoFuturo2.isDone() ? "Finalizo" : "en proceso",
                    resultadoFuturo3.isDone() ? "Finalizo" : "en proceso"
            ));
            TimeUnit.MILLISECONDS.sleep(1000);
        }
        System.out.println(resultadoFuturo.get());
        System.out.println(resultadoFuturo.isDone());

        System.out.println(resultadoFuturo2.get());
        System.out.println(resultadoFuturo2.isDone());

        System.out.println(resultadoFuturo3.get());
        System.out.println(resultadoFuturo3.isDone());

        System.out.println("Continuando con la ejecuccion...");
    }
}
