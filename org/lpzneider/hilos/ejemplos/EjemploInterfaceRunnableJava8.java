package org.lpzneider.hilos.ejemplos;

public class EjemploInterfaceRunnableJava8 {
    public static void main(String[] args) throws InterruptedException {

        Thread main = Thread.currentThread();

        Runnable viaje = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i + 1 + " - " + Thread.currentThread().getName());
                try {
                    Thread.sleep((long) (Math.random() * 1000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Finalmente me voy de viaje a: " + Thread.currentThread().getName());
            System.out.println(main.getState());
        };


        Thread v1 = new Thread(viaje, "Isla de Pascua");
        Thread v2 = new Thread(viaje, "Argentina");
        Thread v3 = new Thread(viaje, "Suecia");
        Thread v4 = new Thread(viaje, "Isla de Galapagos");

        v1.start();
        v2.start();
        v3.start();
        v4.start();
        v1.join();
        v2.join();
        v3.join();
        v4.join();

        System.out.println("continuamos con el hilo del main");


    }
}
