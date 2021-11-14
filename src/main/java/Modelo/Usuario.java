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

 //recargar tarjeta
    public boolean recargar(Tarjeta tarjeta, Movimiento monto){
        return tarjeta.recargar(monto);
    }

   //consumir tarjeta
    public boolean consumir(Tarjeta tarjeta, Movimiento monto){
        return tarjeta.consumir(monto);
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
     //mostrar tarjetas
    public String mostrarTarjetas(){
        String tarjetas="";
        int i=1;
        for(Tarjeta tarjeta:this.tarjetas){
            tarjetas+="Tarjeta ["+i+"] "+tarjeta.toString()+"\n";
            i++;
        }
        return tarjetas;
    }
    //toString
    @Override
    public String toString() {
        return "Usuario{" + "paterno=" + paterno + ", materno=" + materno + ", nombres=" + nombres + ", tipoDocumento=" + tipoDocumento + ",\n tarjetas=" + tarjetas + '}';
    }


 



}
