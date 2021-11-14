/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import vistas.RegistrarMovimiento;
import vistas.viewPrincipal;
import modelo.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author viane
 */
public class ControladorRegistrarMovimiento {

    Usuarios users = new Usuarios();
    RegistrarMovimiento RM = new RegistrarMovimiento();
    viewPrincipal principal = new viewPrincipal();
    Movimiento mov;
    Usuario u1;
    Tarjeta tarjeta;
    Estacion estacion;
    String fecha;
    SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
    Date date=new Date();
    public ControladorRegistrarMovimiento(Usuarios users, viewPrincipal principal, RegistrarMovimiento RM) {
        this.users = users;
        this.principal = principal;
        this.RM = RM;

        this.RM.btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    u1 = users.buscarUsuario(Integer.parseInt(RM.codBuscar.getText()));
                    if (u1 != null) {
                        if (u1.getTarjetas().isEmpty()) {
                            RM.mostrarTarjetas.setText("No tienes tarjetas");
                        } else {
                            RM.mostrarTarjetas.setText(u1.mostrarTarjetas());
                            RM.btnRegistrar.setEnabled(true);
                            RM.numTarjeta.setEditable(true);
                            RM.tipoMov.setEnabled(true);
                            RM.monto.setEditable(true);
                            RM.codEstacion.setEditable(true);
                            RM.fecha.setEnabled(true);
                            RM.nombreEstacion.setEditable(true);
                            RM.direccionEstacion.setEditable(true);
                            RM.error.setText("Ingresa un movimiento");
                        }
                    } else {
                        RM.error.setText("Usuario no encontrado");
                    }

                } catch (Exception error) {
                    RM.error.setText(error.getMessage());
                }
            }
        });
        this.RM.btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    tarjeta = users.buscarTarjeta(u1, Integer.parseInt(RM.numTarjeta.getText()));
                    if (tarjeta != null) {
                        //movimiento(int codigo, String tipo, Date fecha, float monto, Estacion estacion)
                        estacion = new Estacion(Integer.parseInt(RM.codEstacion.getText()), RM.nombreEstacion.getText(), RM.direccionEstacion.getText());
                        fecha=f.format(RM.fecha.getCalendar().getTime());
                        
                        mov = new Movimiento(Integer.parseInt(RM.numTarjeta.getText()), RM.tipoMov.getSelectedItem().toString(), fecha, Float.parseFloat(RM.monto.getText()), estacion);
                        if (RM.tipoMov.getSelectedItem().toString().equals("Retiro") && Float.parseFloat(RM.monto.getText()) > 0) {
                            if (users.consumirTarjeta(u1, tarjeta, mov)) {
                                RM.error.setText("Retiro exitoso");
                                borrar();
                                RM.btnRegistrar.setEnabled(false);
                                RM.numTarjeta.setEditable(false);
                                RM.tipoMov.setEnabled(false);
                                RM.monto.setEditable(false);
                                RM.codEstacion.setEditable(false);
                                RM.fecha.setEnabled(false);
                                RM.nombreEstacion.setEditable(false);
                                RM.direccionEstacion.setEditable(false);
                            } else {
                                RM.error.setText("Saldo Insuficiente ");
                            }
                            if (Float.parseFloat(RM.monto.getText()) < 0) {
                                RM.error.setText("Monto negativo");
                            }

                        }
                        if (RM.tipoMov.getSelectedItem().toString().equals("Deposito") && Float.parseFloat(RM.monto.getText())>0) {
                            if(users.recargarTarjeta(u1, tarjeta, mov)){
                                RM.error.setText("Deposito exitoso");
                                borrar();
                                RM.btnRegistrar.setEnabled(false);
                                RM.numTarjeta.setEditable(false);
                                RM.tipoMov.setEnabled(false);
                                RM.monto.setEditable(false);
                                RM.codEstacion.setEditable(false);
                                RM.fecha.setEnabled(false);
                                RM.nombreEstacion.setEditable(false);
                                RM.direccionEstacion.setEditable(false);
                            }
                        }
                        if( Float.parseFloat(RM.monto.getText())<0){
                            RM.error.setText("Monto negativo");
                        }
                    } else {
                        RM.error.setText("Ingresa un código válido");
                    }
                } catch (Exception error) {
                    RM.error.setText("error: " + error.getMessage());
                }
            }
        });

        this.RM.btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    borrar();
                    RM.codBuscar.setText("");
                    RM.btnRegistrar.setEnabled(false);
                    RM.numTarjeta.setEditable(false);
                    RM.tipoMov.setEnabled(false);
                    RM.monto.setEditable(false);
                    RM.codEstacion.setEditable(false);
                    RM.fecha.setEnabled(false);
                    RM.nombreEstacion.setEditable(false);
                    RM.direccionEstacion.setEditable(false);
                    RM.setVisible(false);
                    principal.setLocationRelativeTo(null);
                    principal.setVisible(true);
                } catch (Exception error) {
                    RM.error.setText("error: "+error.getMessage());
                }
            }
        });
    }
    
    public void borrar(){
        RM.mostrarTarjetas.setText("");
        RM.numTarjeta.setText("");
        RM.tipoMov.setSelectedIndex(-1);
        RM.monto.setText("");
        RM.codEstacion.setText("");
        RM.nombreEstacion.setText("");
        RM.direccionEstacion.setText("");
    }
}
