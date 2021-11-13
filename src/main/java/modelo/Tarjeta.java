package modelo;
import java.util.ArrayList;

public class Tarjeta {
    private int numero;
    private float saldo;
    private boolean activa;
    private float precio;
    //arraylist movimiento
    private ArrayList<Movimiento> movimientos;

    //constructor
    public Tarjeta(int numero, float saldo, float precio) {
        this.numero = numero;
        this.saldo = saldo;
        this.activa = true;
        this.precio = precio;
        this.movimientos = new ArrayList<Movimiento>();
    }


    //recargar tarjeta
    public boolean recargar(float cantidad,Movimiento movimiento) {
        if (activa) {
            saldo += cantidad;
            movimientos.add(movimiento);
            return true;
        }else return false;
    }
    //consumir
    public boolean consumir(float cantidad,Movimiento movimiento) {
        if (activa) {
            if (saldo >= cantidad) {
                saldo -= cantidad;
                movimientos.add(movimiento);
                return true;
            } else return false;
        }else return false;
    }
    // getters and setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public ArrayList<Movimiento> getMovimientos() {
        return movimientos;
    }

 
    public void setMovimientos(ArrayList<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    //metodo para añadir movimientos
    public void addMovimiento(Movimiento movimiento) {
        movimientos.add(movimiento);
    }

    //metodo para mostrar movimientos

    public void mostrarMovimientos() {
        for (Movimiento movimiento : movimientos) {
            System.out.println(movimiento.toString());
        }
    }

    //metodo para mostrar tarjeta

    public void mostrarTarjeta() {
        System.out.println("Numero: " + numero);
        System.out.println("Saldo: " + saldo);
        System.out.println("Activa: " + activa);
        System.out.println("Precio: " + precio);
    }

    //metodo para mostrar tarjeta con movimientos
    
    public String toString() {
        String salida="";
        salida+="Numero: " + numero+", ";
        salida+="Saldo: " + saldo+", ";
        salida+="Activa: " + activa+", ";
        salida+="Precio: " + precio+", ";
        salida+="Movimientos: "+", ";
        for (Movimiento movimiento : movimientos) {
            salida+=movimiento.toString()+"\n";
        }
        return salida;
    }


}
