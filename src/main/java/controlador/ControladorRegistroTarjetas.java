/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vistas.viewPrincipal;
import vistas.RegistroTarjetas;
import modelo.*;
/**
 *
 * @author viane
 */
public class ControladorRegistroTarjetas {
    viewPrincipal principal=new viewPrincipal();
    RegistroTarjetas viewRegistroTarjetas=new RegistroTarjetas();
    Usuarios users=new Usuarios();
    Usuario u1;
    Tarjeta tarjeta;
    

    public ControladorRegistroTarjetas(Usuarios users, viewPrincipal principal, RegistroTarjetas view) {
        this.users=users;
        this.principal=principal;
        this.viewRegistroTarjetas=view;
        
        this.viewRegistroTarjetas.buscaruserRT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    u1=users.buscarUsuario(Integer.parseInt(viewRegistroTarjetas.buscarcodigoRT.getText()));
                    if(u1!=null){
                        
                        viewRegistroTarjetas.registrarT.setEnabled(true);
                        viewRegistroTarjetas.numTarjeta.setEditable(true);
                        viewRegistroTarjetas.saldoTarjeta.setEditable(true);
                        viewRegistroTarjetas.precioT.setEditable(true);
                        viewRegistroTarjetas.error.setText("registra una tarjeta");
                    }else{
                        viewRegistroTarjetas.buscarcodigoRT.setText("");
                        viewRegistroTarjetas.error.setText("Usuario no encontrado");
                    }

                }catch(Exception error){
                    viewRegistroTarjetas.error.setText(error.getMessage());
                }
            }
        });
        this.viewRegistroTarjetas.registrarT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    
                    if(u1!=null){
                        tarjeta=new Tarjeta(Integer.parseInt(viewRegistroTarjetas.numTarjeta.getText()),Float.parseFloat(viewRegistroTarjetas.saldoTarjeta.getText()),Float.parseFloat(viewRegistroTarjetas.precioT.getText()));
                        if(users.buscarUsuario(u1).getTarjetas().size()==5){
                            viewRegistroTarjetas.error.setText("Solo puedes tener 5 tarjetas como maximo");
                        }else{
                            users.addTarjeta(u1, tarjeta);
                            viewRegistroTarjetas.error.setText("Registro de Tarjeta exitoso");
                        }
                        //borrar todo
                        viewRegistroTarjetas.registrarT.setEnabled(false);
                        viewRegistroTarjetas.numTarjeta.setEditable(false);
                        viewRegistroTarjetas.saldoTarjeta.setEditable(false);
                        viewRegistroTarjetas.precioT.setEditable(false);
                        borrar();
                    }else{
                        viewRegistroTarjetas.buscarcodigoRT.setText("");
                        viewRegistroTarjetas.error.setText("Usuario no encontrado");
                    }

                }catch(Exception error){
                    viewRegistroTarjetas.error.setText("error: "+error.getMessage());
                }
            }
            
        });
        
        this.viewRegistroTarjetas.salirT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    viewRegistroTarjetas.setVisible(false);
                    principal.setLocationRelativeTo(null);
                    principal.setVisible(true);
                } catch (Exception error) {
                    viewRegistroTarjetas.error.setText("error: "+error.getMessage());
                }
            }
        });
        
    }
    
    public void borrar(){
        viewRegistroTarjetas.buscarcodigoRT.setText("");
        viewRegistroTarjetas.numTarjeta.setText("");
        viewRegistroTarjetas.precioT.setText("");
        viewRegistroTarjetas.saldoTarjeta.setText("");
    }
    
}
