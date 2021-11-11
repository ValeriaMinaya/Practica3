
package Controlador;

import Modelo.Tarjeta;
import Modelo.Usuario;
import Modelo.UsuarioArreglo;
import Programa.frmUsuario;
import Programa.frmIngreso1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;



public class ControladorUsuario {
    private UsuarioArreglo modelo;
    private frmUsuario vista;
    private frmIngreso1 ingresarTarjeta;
    private String nbuscar="",nombres="",paterno="",materno="",documento="";
    private int opcion,pos;
    public ControladorUsuario(UsuarioArreglo modelo, frmUsuario vista,frmIngreso1 ingresar){
        
        this.modelo = modelo;
        this.ingresarTarjeta=ingresar;
        this.vista = vista;
        limpiar();
        this.vista.btnSalir.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }
        });
        
        this.vista.btnAgregar.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
                
            if (!modelo.documentoRegistrado(
                    vista.cboTipoDocumento.getSelectedItem().toString(),
                    vista.txtDocumento.getText())) {
                Usuario  usuario = new Usuario(
                           vista.txtPaterno.getText(), 
                           vista.txtMaterno.getText(), 
                           vista.txtNombres.getText(), 
                           vista.txtDocumento.getText(), 
                           vista.cboTipoDocumento.getSelectedItem().toString() );
                
                usuario.registrarTarjeta( 
                        new Tarjeta( Float.parseFloat( vista.txtMonto.getText()),
                            Float.parseFloat(vista.txtPasaje.getText() ) ) );
               
                modelo.agregar(usuario);
               limpiar();               
            } else{
                 JOptionPane.showMessageDialog(vista,"Error:Documento ya se encuentra registrado");
            }   

            }
        });
        
        this.vista.btnImprimir.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                JOptionPane.showMessageDialog(vista, modelo, "Usuarios", 1);

            }
        });
        this.vista.btnAgregarTarjeta.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                ocultar();
                ingresarTarjeta.setVisible(true);

            }
        });
        this.vista.editarEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                do{
                    opcion=Integer.parseInt(JOptionPane.showInputDialog(vista, "Elige una opcion:\n1.Editar\n2.Eliminar\n3.Salir"));
                    if(opcion==1){
                        nbuscar=JOptionPane.showInputDialog(vista,"Apellido Paterno de usuario a editar: ");
                        if(buscarUsuario(nbuscar)!=-1){
                            do{
                                opcion=Integer.parseInt(JOptionPane.showInputDialog(vista, "Campo a editar:\n1.Apellido Paterno\n2.Apellido Materno\n3.Nombres\n4.Documento\n5.Salir"));
                                switch(opcion){
                                    case 1:
                                        modelo.setPaterno(JOptionPane.showInputDialog(vista,"Nuevo Apellido Paterno: "), pos);
                                        break;
                                    case 2:
                                        modelo.setMaterno(JOptionPane.showInputDialog(vista,"Nuevo Apellido Materno: "), pos);
                                        break;
                                    case 3:
                                        modelo.setNombres(JOptionPane.showInputDialog(vista,"Nuevos Nombres: "), pos);
                                        break;
                                    case 4:
                                        modelo.setDocumento(JOptionPane.showInputDialog(vista,"Nuevos Documento: "), pos);
                                        break;
                                }
                            }while(opcion!=5);
                        }else{
                            vista.mensajeError.setText("Usuario no encontrado");
                        }
                    }
                    if(opcion==2){
                        nbuscar=JOptionPane.showInputDialog(vista,"Apellido Paterno de usuario a eliminar: ");
                        if(modelo.eliminar(nbuscar)){
                            
                            vista.mensajeError.setText("Eliminado exitosamente");
                        }else{
                            vista.mensajeError.setText("Usuario no encontrado");
                        }
                    }
                }while(opcion!=3);

            }
        });
    }
    
    public void iniciar(){
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
    
    public void mostrar(){
        vista.setVisible(true);
    }
    public void ocultar(){
        vista.setVisible(false);
    }
    private void limpiar(){
        this.vista.txtPaterno.setText(""); 
        this.vista.txtMaterno.setText("");
        this.vista.txtNombres.setText("");
        this.vista.txtDocumento.setText("");
        this.vista.txtMonto.setText("");
        this.vista.txtPasaje.setText("");
        this.vista.cboTipoDocumento.setSelectedIndex(-1);
        
    }
    
    private int buscarUsuario(String paterno){
        int i=0,pos=-1;
        boolean encontrado=false;
        while (i < modelo.getTamaño() && encontrado == false) {
            if (modelo.getpaterno(i).equals(paterno)) {
                pos = i;
                encontrado = true;
            }
            i++;
        }
        return pos;
    }
    
}
