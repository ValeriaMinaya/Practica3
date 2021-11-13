package modelo;
import java.util.ArrayList;

public class Usuario {
    private String paterno;
    private String materno;
    private String nombres;
    
    private TipoDocumento tipoDocumento;
    //array de Tarjeta
    private ArrayList<Tarjeta> tarjetas;

    //constructor
    public Usuario(String paterno, String materno, String nombres, TipoDocumento tipoDocumento) {
        this.paterno = paterno;
        this.materno = materno;
        this.nombres = nombres;
        this.tipoDocumento = tipoDocumento;
        this.tarjetas = new ArrayList<Tarjeta>();
    }

    //recargar tarjetas
    public float recargar( Tarjeta tarjeta,Movimiento movimiento) {
        int pos=this.tarjetas.indexOf(tarjeta);
        if(pos>=0){
            this.tarjetas.get(pos).recargar(movimiento.getMonto(),movimiento);
            return this.tarjetas.get(pos).getSaldo();
        }
        return 0;
    }
    //consumir tarjetas boolean
    public boolean consumir(Tarjeta tarjeta,Movimiento movimiento){
        int pos=this.tarjetas.indexOf(tarjeta);
        if(pos>=0){
            this.tarjetas.get(pos).consumir(movimiento.getMonto(),movimiento);
            return true;
        }
        return false;
    }
    
    //metodos get y set
    public String getPaterno() {
        return paterno;
    }
    
    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }



    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public ArrayList<Tarjeta> getTarjetas() {
        return tarjetas;
    }

    public void setTarjetas(ArrayList<Tarjeta> tarjetas) {
        this.tarjetas = tarjetas;
    }

    public void addTarjeta(Tarjeta tarjeta) {
        this.tarjetas.add(tarjeta);
    }

    public void removeTarjeta(Tarjeta tarjeta) {
        this.tarjetas.remove(tarjeta);
    }

    //toString
    @Override
    public String toString() {
        return "Usuario{" + "paterno=" + paterno + ", materno=" + materno + ", nombres=" + nombres + ", tipoDocumento=" + tipoDocumento + ",\n tarjetas=" + tarjetas + '}';
    }


 



}
