/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.Tarjeta;
import Modelo.Usuario;
import Modelo.UsuarioArreglo;
import Programa.frmUsuario;
import Programa.listado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
/**
 *
 * @author viane
 */
public class ControladorUsuarios {
    private frmUsuario vista;
    private listado Users;
    public UsuarioArreglo modelo;
    int opcion;
    String menuOrdenar="Opciones de orden\n1.Por Apellido Paterno\n2.Por Apellido Materno\n3. Por Documento\n4. Salir";
    public ControladorUsuarios(frmUsuario vista,listado Users, UsuarioArreglo modelo) {
        this.Users = Users;
        this.modelo = modelo;
        this.vista=vista;
        //rellenando la tabla
        rellenar();
        this.Users.btnOrdenar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    
                        opcion=Integer.parseInt(JOptionPane.showInputDialog(menuOrdenar));
                    
                    
                }catch(NumberFormatException error){
                    JOptionPane.showMessageDialog(Users, error);
                }
                switch(opcion){
                    case 1:
                        modelo.ordenarPorPaterno();
                        rellenar();
                        break;
                    case 2:
                        modelo.ordenarPorMaterno();
                        rellenar();
                        break;
                        
                    case 3:
                        modelo.ordenarPorDocumento();
                        rellenar();
                        break;
                    case 4:
                    default:
                        JOptionPane.showMessageDialog(Users, "Solo opciones del 1 al 4");
                }

            }
        });
        
       this.Users.btnVolver.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ocultar();
                vista.setVisible(true);
            }
        });
    }
    
    
    
    public void mostrar(){
        Users.setVisible(true);
    }
    public void ocultar(){
        Users.setVisible(false);
    }
    
    public void rellenar(){
                //rellenando la tabla
        if(modelo.getArregloU().length>=1){
           for(int i=0;i<modelo.getArregloU().length;i++){
            Users.jTable1.setValueAt(modelo.getpaterno(i), i, 0);
            Users.jTable1.setValueAt(modelo.getmaterno(i), i, 1);
            Users.jTable1.setValueAt(modelo.getnombres(i), i, 2);
            Users.jTable1.setValueAt(modelo.getdocumento(i), i, 3);
        } 
        }
        
    }
    
}
