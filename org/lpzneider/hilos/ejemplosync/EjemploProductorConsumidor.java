package org.lpzneider.hilos.ejemplosync;

import org.lpzneider.hilos.ejemplosync.runnable.Consumidor;
import org.lpzneider.hilos.ejemplosync.runnable.Panadero;

import java.util.concurrent.ThreadLocalRandom;

public class EjemploProductorConsumidor {
    public static void main(String[] args) {
        Panaderia p = new Panaderia();
        new Thread(() -> {
        for (int i = 0; i < 10; i++) {
            p.honear("Pan numero: " + i);
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(500, 2000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        }).start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                p.consumir();
            }
        }).start();
    }
}
