package modelo;

import java.util.Date;
public class App {
    public static void main(String[] args) throws Exception {
        TipoDocumento d1=new TipoDocumento(1,"DNI");
        Usuario u1=new Usuario("Lara","Zatta","Jonathan Brain",d1);
        Tarjeta t1=new Tarjeta(0,5000.f,3.f);
        Movimiento m1= new Movimiento(10,"Recarga",new Date(),3500,new Estacion(19200, "Interbank", "Los Olivos"));
        Movimiento m2= new Movimiento(99,"Retiro",new Date(),1500,new Estacion(1500, "Interbank", "Los Olivos"));
        u1.addTarjeta(t1);
        
        u1.recargar(t1, m1);
        u1.consumir(t1, m2);
        u1.addTarjeta(new Tarjeta(1,3000,2));
        System.out.println(u1.toString());
        
        
    }
}
