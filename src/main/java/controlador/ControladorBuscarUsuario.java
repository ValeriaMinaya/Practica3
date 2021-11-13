/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import vistas.*;
import modelo.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
/**
 *
 * @author viane
 */
public class ControladorBuscarUsuario {

    Usuarios users =new Usuarios();
    viewPrincipal principal=new viewPrincipal();
    BuscarUsuario BU=new BuscarUsuario();
    int cod;
    Usuario u1;
    TipoDocumento d;
    public ControladorBuscarUsuario(Usuarios users, viewPrincipal P, BuscarUsuario BU){
        this.users=users;
        this.principal=P;
        this.BU=BU;
        
        this.BU.buscarBU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    cod=Integer.parseInt(BU.codDoc.getText());
                    u1=users.buscarUsuario(cod);
                    if(u1==null){
                        BU.errorBU.setText("Usuario no encontrado");
                        limpiarcodbuscar();
                        System.out.println("Usuario encontrado: "+u1);
                    }else{
                        BU.apellidoP.setText(u1.getPaterno());
                        BU.apellidoM.setText(u1.getMaterno());
                        BU.nombresBU.setText(u1.getNombres());
                        if(u1.getTipoDocumento().getNombre().equals("DNI")){
                            BU.tipoDOC.setSelectedIndex(0);
                            
                        }else{
                            BU.tipoDOC.setSelectedIndex(1);
                        }
                        BU.codUser.setText(String.valueOf(u1.getTipoDocumento().getCodigo()));
                    }
                    
                }catch(Exception error){
                    BU.errorBU.setText(error.getMessage());
                }
            }
        });
        this.BU.editar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    cod=Integer.parseInt(BU.codDoc.getText());
                    u1=users.buscarUsuario(cod);
                    if(u1==null){
                        BU.errorBU.setText("Usuario no encontrado");
                        limpiarcodbuscar();
                        System.out.println("Usuario encontrado: "+u1);
                    }else{
                        BU.apellidoP.setText(u1.getPaterno());
                        BU.apellidoM.setText(u1.getMaterno());
                        BU.nombresBU.setText(u1.getNombres());
                        if(u1.getTipoDocumento().getNombre().equals("DNI")){
                            BU.tipoDOC.setSelectedIndex(0);
                            
                        }else{
                            BU.tipoDOC.setSelectedIndex(1);
                        }
                        BU.codUser.setText(String.valueOf(u1.getTipoDocumento().getCodigo()));
                        BU.apellidoP.setEditable(true);
                        BU.apellidoM.setEditable(true);
                        BU.codUser.setEditable(true);
                        BU.nombresBU.setEditable(true);
                        BU.tipoDOC.setEnabled(true);
                        BU.guardar.setEnabled(true);
                    }
                    
                }catch(Exception error){
                    
                }
            }
        });
        this.BU.guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    cod=Integer.parseInt(BU.codDoc.getText());
                    u1=users.buscarUsuario(cod);
                    if(u1==null){
                        BU.errorBU.setText("Usuario no encontrado");
                        limpiarcodbuscar();
                        System.out.println("Usuario encontrado: "+u1);
                    }else{
                      
                        if(u1.getTipoDocumento().getNombre().equals("DNI")){
                            BU.tipoDOC.setSelectedIndex(0);
                            
                        }else{
                            BU.tipoDOC.setSelectedIndex(1);
                        }
                        BU.codUser.setText(String.valueOf(u1.getTipoDocumento().getCodigo()));
                        BU.apellidoP.setEditable(true);
                        BU.apellidoM.setEditable(true);
                        BU.codUser.setEditable(true);
                        BU.nombresBU.setEditable(true);
                        BU.tipoDOC.setEnabled(true);
                        BU.guardar.setEnabled(true);
                    }
                    
                }catch(Exception error){
                    
                }
            }
        });
    }
    
    public void ocultar(){
        BU.setVisible(false);
    }
    
    public void mostrar(){
        BU.setLocationRelativeTo(null);
        BU.setVisible(true);
    }
    
    public void limpiarcodbuscar(){
        BU.codDoc.setText("");
    }
    

    }

