package dev.wdona.ej1;

public class Cuenta {
    private int saldo;
    private int maximo;
    
    public Cuenta(int saldo, int maximo) {
        this.saldo = saldo;
        this.maximo = maximo;
    }
    
    public synchronized void sacar(int valor, String nombrePersona) throws Exception { // String nombrePersona???
        if (saldo < valor) {
            throw new Exception("ERROR: " + nombrePersona + ": Saldo insuficiente. Has intentado sacar " + valor + " y tienes " + saldo + " para sacar.");
        }
        
        if (saldo <= 0) {
            throw new Exception("ERROR: " + nombrePersona + "Saldo negativo. Tienes " + saldo);
        }
        
        if (valor <= 0) {
            throw new Exception("ERROR: " + nombrePersona + "Valor debe ser mayor a 0. Has intentado sacar " + valor);
        }
        
        saldo -= valor;
        System.out.println(nombrePersona + " ha sacado " + valor + ". Total en la cuenta: " + saldo);
    } 
    
    public synchronized void ingresar(int valor, String nombrePersona) throws Exception { // String nombrePersona???
        if (saldo == maximo) {
            throw new Exception("ERROR: " + nombrePersona + ": Tienes el maximo permitido en tu cuenta. Tienes " + saldo);
        }
        
        if (valor+saldo > maximo) {
            throw new Exception("ERROR: " + nombrePersona + ": no puedes ingresar " + valor + ". Tienes " + saldo + ", se quedaria en " + (saldo + valor) + " y tu maximo es de " + maximo);
        }
        
        if (valor <= 0) {
            throw new Exception("ERROR: " + nombrePersona + ": el valor a ingresar debe ser mayor a 0. Has intentado ingresar " + valor);
        }
        
        saldo += valor;
        System.out.println(nombrePersona + ": ha ingresado " + valor + ". Total en la cuenta: " + saldo);
    } 
}
