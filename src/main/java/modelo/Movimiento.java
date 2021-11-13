package modelo;

import java.util.Date;

public class Movimiento {
    private int codigo;
    private String tipo;
    private Date fecha;
    private float monto;
    private Estacion estacion;

    //constructor
    public Movimiento(int codigo, String tipo, Date fecha, float monto, Estacion estacion) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.fecha = fecha;
        this.monto = monto;
        this.estacion = estacion;
    }

    //getters
    public int getCodigo() {
        return codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public float getMonto() {
        return monto;
    }

    public Estacion getEstacion() {
        return estacion;
    }

    //setters

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public void setEstacion(Estacion estacion) {
        this.estacion = estacion;
    }

    //toString
    @Override
    public String toString() {
        return "Movimiento{" +
                "codigo=" + codigo +
                ", tipo='" + tipo + '\'' +
                ", fecha=" + fecha +
                ", monto=" + monto +
                ", estacion=" + estacion +
                '}';
    }

}
