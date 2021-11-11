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
import Programa.frmIngreso1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
/**
 *
 * @author viane
 */
public class ControladorIngresar {

    private UsuarioArreglo modelo;
    private frmUsuario vista;
    private frmIngreso1 ingreso;
    private String apellido = "";
    private Tarjeta tarjeta = new Tarjeta();
    private float saldo, precio;
    int pos;

    public ControladorIngresar(UsuarioArreglo modelo, frmUsuario vista, frmIngreso1 ingreso) {
        
        this.modelo = modelo;
        this.vista = vista;
        this.ingreso = ingreso;
        this.ingreso.btnIngresarTarjeta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apellido = ingreso.apellidoPaterno.getText();

                pos = buscar();
                if (pos >=0) {
                    if (modelo.getUser(pos).getIndice()<5) {
                        try {
                            saldo = Float.parseFloat(ingreso.saldoTarjeta.getText());
                            precio = Float.parseFloat(ingreso.precioTarjeta.getText());
                            tarjeta.setPrecio(precio);
                            tarjeta.setSaldo(saldo);
                            modelo.getUser(pos).registrarTarjeta(tarjeta);
                            
                        } catch (NumberFormatException error) {
                            ingreso.labelError.setText(error.getMessage());
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Máximo 5 tarjetas");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Usuario no encontrado");
                }
                limpiar();
                ingreso.labelError.setText("Tarjeta agregada");
            }
        });
        this.ingreso.btnvolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiar();
                ocultar();
                vista.setVisible(true);
                
            }
        });
        
    }

    public void limpiar() {
        this.ingreso.precioTarjeta.setText("");
        this.ingreso.saldoTarjeta.setText("");
        this.ingreso.apellidoPaterno.setText("");
        this.ingreso.labelError.setText("");
    }

    public int buscar() {
        for (int i = 0; i < modelo.getTamaño(); i++) {
            if(modelo.getpaterno(i)!=null)
            if (modelo.getpaterno(i).equals(apellido)) {
                return i;
            }
        }
        return -1;
    }

    public void mostrar() {
        ingreso.setVisible(true);
    }

    public void ocultar() {
        ingreso.setVisible(false);
    }

}