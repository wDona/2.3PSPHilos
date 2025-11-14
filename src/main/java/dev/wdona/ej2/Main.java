package dev.wdona.ej2;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Almacen almacen = new Almacen();
        Proveedor proveedor = new Proveedor(almacen, 45, 50);
        Consumidor consumidor = new Consumidor(almacen, 45, 50);
        
        Thread t1 = new Thread(proveedor);
        Thread t2 = new Thread(consumidor);
        
        t1.start();
        t2.start();
        
        t1.join();
        t2.join();
    }
}
