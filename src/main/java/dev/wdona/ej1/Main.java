package dev.wdona.ej1;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Por testing, uso esta variable
        int iteraciones = 5;
        Thread[] threads = new Thread[iteraciones];
        String[] nombrePersonas = new String[] { "Pepe", "Alex", "Isabel", "Sergio", "Manel", "Jesus", "Teresa", "Juana", "Angel", "Fernando" };
        
        
        for (int i = 0; i < iteraciones; i++) {
            int saldoInicial = new Random().nextInt(500);
            int maximoSaldo = new Random().nextInt(501, 700);
            
            Cuenta cuenta = new Cuenta(saldoInicial, maximoSaldo);
            Persona persona = new Persona(nombrePersonas[i], cuenta);
            System.out.println(nombrePersonas[i] + " empieza con " + saldoInicial + " de saldo y su maximo es de " + maximoSaldo);

            threads[i] = persona;
        }
        System.out.println();

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
        
        
        for (int i = 0; i < iteraciones; i++) {
            threads[i].join();
        }
    }
}