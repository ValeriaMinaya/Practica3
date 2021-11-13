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
public class ControladorRegistroUsuarios {
    
    RegistroUsuarios viewRegistroUsuario =new RegistroUsuarios();
    viewPrincipal viewprincipal=new viewPrincipal();
    Usuarios users=new Usuarios();
    int cod;
    TipoDocumento d1;
    Usuario encontrado;
    public ControladorRegistroUsuarios(Usuarios users, RegistroUsuarios a, viewPrincipal b) {
        this.users=users;
        this.viewRegistroUsuario=a;
        this.viewprincipal=b;
        this.viewRegistroUsuario.registroUserRU.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                   cod=Integer.parseInt(viewRegistroUsuario.codigoDocRU.getText());
                   d1=new TipoDocumento(cod,viewRegistroUsuario.tipodocRU.getSelectedItem().toString());
                   encontrado=users.buscarUsuario(cod);
                   if(encontrado!=null){
                    JOptionPane.showMessageDialog(viewRegistroUsuario, "Usuario ya registrado");
                    limpiarcampos();
                   }else{
                   Usuario u1=new Usuario(viewRegistroUsuario.apellidopaternoRU.getText(),viewRegistroUsuario.apellidomaternoRU.getText(),viewRegistroUsuario.nombresRU.getText(),d1);
                   users.addUsuario(u1);
                   limpiarcampos();
                   System.out.println(users.verUsuarios());
                   JOptionPane.showMessageDialog(viewRegistroUsuario, "Registro de Usuario exitoso");
                   }
                }catch(Exception error){
                    limpiarcampos();
                    viewRegistroUsuario.errorRU.setText("Error: "+error.getMessage());
                }
            }
        });
        
        this.viewRegistroUsuario.salirRU.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                ocultar();
                viewprincipal.setLocationRelativeTo(null);
                viewprincipal.setVisible(true);
            }
        });
        
    }
    
    public void limpiarcampos(){
        viewRegistroUsuario.apellidomaternoRU.setText("");
        viewRegistroUsuario.apellidopaternoRU.setText("");
        viewRegistroUsuario.codigoDocRU.setText("");
        viewRegistroUsuario.nombresRU.setText("");
        viewRegistroUsuario.tipodocRU.setSelectedIndex(-1);
        viewRegistroUsuario.errorRU.setText("");
    }
    
    public void ocultar(){
        viewRegistroUsuario.setVisible(false);
    }
    public void mostrar(){
        viewRegistroUsuario.setLocationRelativeTo(null);
        viewRegistroUsuario.setVisible(true);
    }
    
}
