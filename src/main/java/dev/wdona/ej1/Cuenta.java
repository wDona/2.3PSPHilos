package dev.wdona.ej1;

public class Cuenta {
    // Saldo actual de la cuenta
    private int saldo;
    
    // Maximo saldo que puede tener la cuenta
    private int maximo;
    
    // Constructor
    public Cuenta(int saldo, int maximo) {
        this.saldo = saldo;
        this.maximo = maximo;
    }
    
    // Metodo sincronizado para sacar dinero
    public synchronized void sacar(int valor, String nombrePersona) throws Exception { // String nombrePersona???
        // Lanza error si se trata de sacar mas dinero de lo que se tiene
        if (saldo < valor) {
            throw new Exception("ERROR: " + nombrePersona + ": Saldo insuficiente. Has intentado sacar " + valor + " y tienes " + saldo + " para sacar.");
        }
        
        // Lanza error si el saldo es 0 o negativo
        if (saldo <= 0) {
            throw new Exception("ERROR: " + nombrePersona + "Saldo negativo. Tienes " + saldo);
        }
        
        // Lanza error si se intenta sacar un valor negativo
        if (valor <= 0) {
            throw new Exception("ERROR: " + nombrePersona + "Valor debe ser mayor a 0. Has intentado sacar " + valor);
        }
        
        // Se settea el saldo de forma sincronizada al nuevo saldo si no da error
        setSaldo(getSaldo() - valor);
        System.out.println(nombrePersona + " ha sacado " + valor + ". Total en la cuenta: " + saldo);
    } 
    
    public synchronized void ingresar(int valor, String nombrePersona) throws Exception { // String nombrePersona???
        // Lanza error si ya tiene el maximo de su cuenta
        if (saldo == maximo) {
            throw new Exception("ERROR: " + nombrePersona + ": Tienes el maximo permitido en tu cuenta. Tienes " + saldo);
        }
        
        // Lanza error si el dinero que intenta ingresar hace que su cuenta supere el maximo permitido
        if (valor+saldo > maximo) {
            throw new Exception("ERROR: " + nombrePersona + ": no puedes ingresar " + valor + ". Tienes " + saldo + ", se quedaria en " + (saldo + valor) + " y tu maximo es de " + maximo);
        }
        
        // Lanza error si intenta ingresar un numero negativo
        if (valor <= 0) {
            throw new Exception("ERROR: " + nombrePersona + ": el valor a ingresar debe ser mayor a 0. Has intentado ingresar " + valor);
        }
        
        // Settea el saldo de forma sincronizada al nuevo saldo si no da error
        setSaldo(getSaldo() + valor);
        System.out.println(nombrePersona + ": ha ingresado " + valor + ". Total en la cuenta: " + saldo);
    }

    // Getter y setter del saldo sincronizados para evitar accesos simultaneos
    public synchronized int getSaldo() {
        return saldo;
    }

    public synchronized void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}
