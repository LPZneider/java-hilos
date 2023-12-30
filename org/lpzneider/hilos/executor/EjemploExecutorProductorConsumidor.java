package org.lpzneider.hilos.executor;

import org.lpzneider.hilos.ejemplosync.Panaderia;
import org.lpzneider.hilos.ejemplosync.runnable.Consumidor;
import org.lpzneider.hilos.ejemplosync.runnable.Panadero;

import java.util.concurrent.*;

public class EjemploExecutorProductorConsumidor {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        System.out.println("Tamanio del pool: " + executor.getPoolSize());
        System.out.println("Cantidad de tareas en cola: " + executor.getQueue().size());

        Panaderia p = new Panaderia();
        Runnable productor = new Panadero(p);
        Runnable consumidor = new Consumidor(p);

        Future<?> resultadoFuturo = executor.submit(productor);
        Future<?> resultadoFuturo2 = executor.submit(consumidor);

        System.out.println("Tamanio del pool: " + executor.getPoolSize());
        System.out.println("Cantidad de tareas en cola: " + executor.getQueue().size());

        executor.shutdown();
    }
}
