package org.lpzneider.hilos.tasks;


import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class EjemploTarea {
    public static void main(String[] args) {
        AlfanumericoTarea tarea1 = new AlfanumericoTarea(Tipo.LETRA);
        AlfanumericoTarea tarea2 = new AlfanumericoTarea(Tipo.NUMERO);

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        executor.submit(tarea1);

        executor.submit(tarea2);


        executor.shutdown();

    }
}
