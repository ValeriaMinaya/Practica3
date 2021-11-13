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
        BuscarUsuario BU = new BuscarUsuario();
        
        ControladorViewPrincipal CVP=new ControladorViewPrincipal(users,principal,RU,RT,RM,BU);
        ControladorRegistroUsuarios CRU=new ControladorRegistroUsuarios(users,RU,principal);
        ControladorBuscarUsuario CBU=new ControladorBuscarUsuario(users,principal,BU);
        CVP.iniciar();
        
    }
}
