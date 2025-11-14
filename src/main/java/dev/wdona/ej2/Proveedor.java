package dev.wdona.ej2;

import java.util.Random;

public class Proveedor implements Runnable {
    private Almacen almacen;
    private int diasQueTrabajaraElProveedor;
    private long duracionHoraFicticia;
    
    public Proveedor(Almacen almacen, int diasQueTrabajaraElProveedor, long horasQueEcha) {
        this.almacen = almacen;
        this.diasQueTrabajaraElProveedor = diasQueTrabajaraElProveedor;
        this.duracionHoraFicticia = horasQueEcha;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < diasQueTrabajaraElProveedor; i++) {
            for (int j = 0; j < 24/8; j++) {
                int numPiezasAAnadir = new Random().nextInt(400, 1000);
                
                try {
                    almacen.agregarPieza(numPiezasAAnadir, Thread.currentThread().getName(), i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                try {
                    Thread.sleep(duracionHoraFicticia * 8);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
