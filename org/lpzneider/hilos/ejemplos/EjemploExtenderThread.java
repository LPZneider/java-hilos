package org.lpzneider.hilos.ejemplos;

import org.lpzneider.hilos.ejemplos.threads.NameThread;

public class EjemploExtenderThread {
    public static void main(String[] args) {
        Thread hilo = new NameThread("Neider Lopez");
        hilo.start();
        System.out.println(hilo.getState());

        Thread hilo2 = new NameThread("Angela Lopez");
        hilo2.start();
        System.out.println(hilo2.getState());

        Thread hilo3 = new NameThread("Mara Lopez");
        hilo3.start();
        System.out.println(hilo3.getState());
    }
}
