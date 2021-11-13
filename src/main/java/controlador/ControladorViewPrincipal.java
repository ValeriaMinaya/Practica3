/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import modelo.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vistas.*;
/**
 *
 * @author viane
 */
public class ControladorViewPrincipal {
    Usuarios users=new Usuarios();
    viewPrincipal principal=new viewPrincipal();
    RegistroUsuarios RU=new RegistroUsuarios();
    RegistroTarjetas RT=new RegistroTarjetas();
    RegistrarMovimiento RM=new RegistrarMovimiento();
    BuscarUsuario BU=new BuscarUsuario();

    public ControladorViewPrincipal(Usuarios users,viewPrincipal a,RegistroUsuarios b,RegistroTarjetas c, RegistrarMovimiento d,BuscarUsuario e ) {
        this.users=users;
        this.principal=a;
        this.RU=b;
        this.RT=c;
        this.RM=d;
        this.BU=e;
        this.principal.registerUser.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            ocultar();
            RU.setLocationRelativeTo(null);
            RU.setVisible(true);
            }
        });
        this.principal.buscarUser.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            ocultar();
            BU.setLocationRelativeTo(null);
            BU.setVisible(true);
            }
        });
    }
    
    public void iniciar(){
        principal.setLocationRelativeTo(null);
        principal.setVisible(true);
    }
    public void ocultar(){
        principal.setVisible(false);
    }
    
}
