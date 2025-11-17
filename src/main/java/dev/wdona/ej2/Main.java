package dev.wdona.ej2;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Crear un proveedor y consumidor que operaran en el mismo almacen, 
        Almacen almacen = new Almacen();
        
        // Para testing, operan el mismo numero de dias y las horas duran lo mismo
        final int nDiasOperados = 45;
        final int duracionHora = 50; // milisegundos/hora
        Proveedor proveedor = new Proveedor(almacen, nDiasOperados, duracionHora);
        Consumidor consumidor = new Consumidor(almacen, nDiasOperados, duracionHora);
        
        // Crear un hilo para cada Runnable
        Thread tProveedor = new Thread(proveedor);
        Thread tConsumidor = new Thread(consumidor);
        
        // Empezar cada hilo
        tProveedor.start();
        tConsumidor.start();
        
        // Hacer que el main no acabe hasta que no terminen los hilos
        tProveedor.join();
        tConsumidor.join();
    }
}
