package org.lpzneider.hilos.ejemplos;

import org.lpzneider.hilos.ejemplos.runnable.ImprimirFrases;

public class EjemploSincronizacionThread {
    public static void main(String[] args) throws InterruptedException {
        new Thread(new ImprimirFrases("Hola ","Que tal?")).start();
        new Thread(new ImprimirFrases("quien eres ","tu?")).start();
        Thread h3 = new Thread(new ImprimirFrases("Muchas ","gracias amigo?"));

        Thread.sleep(100);
        h3.start();
        Thread.sleep(100);
        System.out.println(h3.getState());

    }

    public synchronized static void imprimirFrases(String frase1, String frase2) {
        System.out.print(frase1);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(frase2);

    }
}
