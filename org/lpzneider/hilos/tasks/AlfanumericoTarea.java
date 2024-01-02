package org.lpzneider.hilos.tasks;

import java.util.ArrayList;
import java.util.List;

public class AlfanumericoTarea implements Runnable{

    private Tipo tipo;

    public AlfanumericoTarea(Tipo tipo) {
        this.tipo = tipo;
    }


    @Override
    public void run() {
        if (tipo == Tipo.LETRA){
            for (int i = 1 ; i < 10; i++){
                System.out.print(i + "\t");
            }
            System.out.println();
        }
        if (tipo == Tipo.NUMERO){
           /* String[] abc = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "ñ", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
            for (String s : abc) {
                System.out.print(s + '\t');
            }*/
            for (char c = 'A'; c <= 'Z'; c++) {
                System.out.print(c + "\t");
            }
        }
    }
}
