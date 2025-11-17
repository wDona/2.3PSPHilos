package dev.wdona.ej2;

public class Almacen {
    // Numero de piezas iniciales
    private int nPiezas = 8000;
    
    // Maximo de piezas posibles en el almacen
    private int maxPiezas = 20000;
    
    // Getter y setter synchronized para evitar problemas de concurrencia
    public synchronized int getnPiezas() {
        return nPiezas;
    }
    
    public synchronized void setnPiezas(int nPiezas) {
        this.nPiezas = nPiezas;
    }
    
    // Agrega pieza
    public synchronized void agregarPieza(int cantidad, String nombre, int dia) throws InterruptedException {
        
        // Evita superar el maximo
        while (nPiezas + cantidad > maxPiezas) {
            wait();
        }

        // Modifica la cantidad
        setnPiezas(getnPiezas() + cantidad);
        System.out.println("------------Soy proveedor, " + nombre + ", dia " + dia + " y he anadido " + cantidad + " piezas. Hay " + getnPiezas() + " piezas.");
        
        // Manda una senial a todos los hilos para que dejen de esperar
        notifyAll();
    }
    
    // Resta piezas del almacen
    public synchronized void retirarPieza(int cantidad, String nombre, int dia) throws InterruptedException {
        
        // Evita tener menos de 0
        while (nPiezas - cantidad < 0) {
            wait();
        }
        
        // Retira las piezas de forma segura
        setnPiezas(getnPiezas() - cantidad);
        System.out.println("Soy consumidor " + nombre +", dia " + dia + " y he quitado " + cantidad + " piezas. Quedan " + getnPiezas() + " piezas.");

        // Manda una senial a todos los hilos para que dejen de esperar
        notifyAll();
    }
}
