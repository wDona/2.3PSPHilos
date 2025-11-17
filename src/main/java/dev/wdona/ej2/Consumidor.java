package dev.wdona.ej2;

import java.util.Random;

public class Consumidor implements Runnable {
    // Almacen del que se consumen las piezas
    private Almacen almacen;
    
    // Dias en los que el consumidor va a consumir
    private int nDiasQueConsumiraPiezas;
    
    // Duracion de la hora en milisegundos
    private long duracionHoraFicticia;
    
    // Constructor
    public Consumidor(Almacen almacen, int nDiasQueConsumiraPiezas, long duracionHoraFicticia) {
        this.almacen = almacen;
        this.nDiasQueConsumiraPiezas = nDiasQueConsumiraPiezas;
        this.duracionHoraFicticia = duracionHoraFicticia;
    }
    
    @Override
    public void run() {
        // Cada dia consume un numero de piezas aleatorias
        for (int i = 0; i < nDiasQueConsumiraPiezas; i++) {
            int numPiezasASacar = new Random().nextInt(2000, 2500);

            try {
                almacen.retirarPieza(numPiezasASacar, Thread.currentThread().getName(), i);
                Thread.sleep(duracionHoraFicticia * 24);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
