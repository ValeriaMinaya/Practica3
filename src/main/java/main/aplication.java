/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import controlador.*;
import modelo.*;
import vistas.*;
/**
 *
 * @author viane
 */
public class aplication {
    public static void main(String[] args) {
        Usuarios users = new Usuarios();
        viewPrincipal principal = new viewPrincipal();
        RegistroUsuarios RU = new RegistroUsuarios();
        RegistroTarjetas RT = new RegistroTarjetas();
        RegistrarMovimiento RM = new RegistrarMovimiento();
        principal.setTitle("View principal");
        RU.setTitle("Registro de Usuarios");
        RT.setTitle("Registro de Tarjetas");
        RM.setTitle("Registro de Movimientos");
        
        BuscarUsuario BU = new BuscarUsuario();
        TipoDocumento d1=new TipoDocumento(72865650,"DNI");
        TipoDocumento d2=new TipoDocumento(72865651,"DNI");
        Tarjeta t1=new Tarjeta(1,2000,2);
        Tarjeta t2=new Tarjeta(1999242,5000,3);
        Usuario u1=new Usuario("Minaya","Rojas","Valeria Luzmila",d1);
        Usuario u2=new Usuario("Hernandez","Zatta","Diego",d2);
        users.addUsuario(u1);
        users.addUsuario(u2);
        users.addTarjeta(u1, t1);
        users.addTarjeta(u1, t2);
        ControladorViewPrincipal CVP=new ControladorViewPrincipal(users,principal,RU,RT,RM,BU);
        ControladorRegistroUsuarios CRU=new ControladorRegistroUsuarios(users,RU,principal);
        ControladorBuscarUsuario CBU=new ControladorBuscarUsuario(users,principal,BU);
        ControladorRegistroTarjetas CRT=new ControladorRegistroTarjetas(users,principal,RT);
        ControladorRegistrarMovimiento CRM=new ControladorRegistrarMovimiento(users,principal,RM);
        CVP.iniciar();
        
    }
}
