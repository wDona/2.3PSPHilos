package dev.wdona.ej1;

import java.util.Random;

public class Persona extends Thread {
    // Cuenta personal de la persona
    private Cuenta cuenta;

    // Constructor
    Persona(String nombre, Cuenta cuenta) {
        super(nombre);
        this.cuenta = cuenta;
    }
    
    @Override
    public void run() {
        // Hacer 2 operaciones simultaneas 2 iteraciones
        for (int i = 0; i < 2; i++) {
            try {
                cuenta.ingresar(new Random().nextInt(500), getName());
                cuenta.sacar(new Random().nextInt(500), getName());
                Thread.sleep(500);
            } catch (Exception e) {
                // Coge el mensaje de error de la excepcion personalizada en cada metodo
                System.out.println(e.getMessage());
            }
        }
    }
}
