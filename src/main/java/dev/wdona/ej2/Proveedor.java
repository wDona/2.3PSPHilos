package dev.wdona.ej2;

import java.util.Random;

public class Proveedor implements Runnable {
    // Almacen del que sacara piezas
    private Almacen almacen;
    
    // Numero de veces que el proveedor va a iterar
    private int nDiasQueTrabajaraElProveedor;
    
    // Duracion ficticia en milisegundos que simula una hora
    private long duracionHoraFicticia;
    
    // Constructor
    public Proveedor(Almacen almacen, int nDiasQueTrabajaraElProveedor, long duracionHoraFicticia) {
        this.almacen = almacen;
        this.nDiasQueTrabajaraElProveedor = nDiasQueTrabajaraElProveedor;
        this.duracionHoraFicticia = duracionHoraFicticia;
    }
    
    @Override
    public void run() {
        // Iteracion de cada dia
        for (int i = 0; i < nDiasQueTrabajaraElProveedor; i++) {
            
            // Como provee cada 8h, un dia tiene 24h, itera 3 veces
            for (int j = 0; j < 24/8; j++) {
                
                // Agrega un numero de piezas aleatorio
                int numPiezasAAnadir = new Random().nextInt(400, 1000);
                
                try {
                    almacen.agregarPieza(numPiezasAAnadir, Thread.currentThread().getName(), i);
                    Thread.sleep(duracionHoraFicticia * 8);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
