package dev.wdona.ej2;

import java.util.Random;

public class Consumidor implements Runnable {
    private Almacen almacen;
    private int diasQueTrabajaraElConsumidor;
    private long duracionHoraFicticia;
    
    public Consumidor(Almacen almacen, int diasQueTrabajaraElConsumidor, long horasQueEcha) {
        this.almacen = almacen;
        this.diasQueTrabajaraElConsumidor = diasQueTrabajaraElConsumidor;
        this.duracionHoraFicticia = horasQueEcha;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < diasQueTrabajaraElConsumidor; i++) {
            int numPiezasASacar = new Random().nextInt(2000, 2500);

            try {
                almacen.retirarPieza(numPiezasASacar, Thread.currentThread().getName(), i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(duracionHoraFicticia * 24);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
