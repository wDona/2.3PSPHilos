package dev.wdona.ej1;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Por testing, uso esta variable
        int iteraciones = 5;
        
        // Crear array de hilos para poder gestionarlos en el futuro
        Thread[] threads = new Thread[iteraciones];
        String[] nombrePersonas = new String[] { "Pepe", "Alex", "Isabel", "Sergio", "Manel", "Jesus", "Teresa", "Juana", "Angel", "Fernando" };
        
        
        for (int i = 0; i < iteraciones; i++) {
            // Crear valores aleatorios de saldo y maximos
            int saldoInicial = new Random().nextInt(500);
            int maximoSaldo = new Random().nextInt(501, 700);
            
            // Instanciar las personas y asignarles una cuenta distinta a cada una
            Cuenta cuenta = new Cuenta(saldoInicial, maximoSaldo);
            Persona persona = new Persona(nombrePersonas[i], cuenta);
            System.out.println(nombrePersonas[i] + " empieza con " + saldoInicial + " de saldo y su maximo es de " + maximoSaldo);
            
            // Guardar a la persona en el array
            threads[i] = persona;
        }
        System.out.println();

        // Ejecutar todas las personas
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
        
        // Hacer que el main espere a que todas las personas terminen de hacer sus operaciones
        for (int i = 0; i < iteraciones; i++) {
            threads[i].join();
        }
    }
}