# Ejercicio 2 Practica 2.3 PSP
Almacen

    public class Almacen
        private int nPiezas - 8000 iniciales
        private int maxPiezas - 20 000
        
        public synchronized int getNPiezas()
        
        // Siempre agrega el productor
        public synchronized void agregarPiezas(int cantidad, String quienAgregaPiezas) {
            sout(soy el productor e ingreso <cantidad> piezas)
            while (nPiezas + cantidad > maxPiezas) {
                wait();
            }
            nPiezas += cantidad
            notifyAll()
        }

        // 
        public synchronized void retirarPiezas(int cantidad, String quienRetiraPiezas) {
            sout(soy el consumidor y retiro <cantidad> piezas)
            while (nPiezas - cantidad < 0) {
                wait();
            }
            nPiezas -= cantidad
            notifyAll()
        }

        public synchronized void ()
        
Consumidor

    public class Consumidor implements Runnable
        private Almacen almacen
        private int diasQueTrabajaraElConsumidor
        private long horasQueEcha? // "Cuanto tiempo son las horas"

        run() {
            for (i = 0 ; i < dias ; i++)
                numPiezasASacar aleatorio
                sout("Soy consumidor y he quitado numPiezasASacar)
                almacen.retirarPieza(numPiezasASacar, this.consumidor)
                sleep(24 * horas que tenga el dia?)
                
        }

Proveedor

    public class Consumidor implements Runnable
        private Almacen almacen
        private int diasQueTrabajaraElConsumidor
        private long horasQueEcha? // "Cuanto tiempo son las horas"
    
            run() {
                for (i = 0 ; i < dias ; i++)
                    numPiezasAAnadir aleatorio
                    sout("Soy proveedor y he anadido numPiezasASacar)
                    almacen.retirarPieza(numPiezasAAnadir, this.consumidor)
                    sleep(8 * horas que tenga el dia?)
                    
            }

Main

    public static void main()
        productor.start()
        consumidor.start()

        for 38gpa
            .join()
            .join()