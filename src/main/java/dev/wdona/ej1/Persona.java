package dev.wdona.ej1;

import java.util.Random;

public class Persona extends Thread {
    private Cuenta cuenta;

    Persona(String nombre, Cuenta cuenta) {
        super(nombre);
        this.cuenta = cuenta;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            try {
                cuenta.ingresar(new Random().nextInt(500), getName());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            
            try {
                cuenta.sacar(new Random().nextInt(500), getName());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
