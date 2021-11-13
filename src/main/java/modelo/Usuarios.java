/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.util.ArrayList;
/**
 *
 * @author viane
 */
public class Usuarios {
    //arraylist de Usuario
    private ArrayList<Usuario> usuarios;
    //constructor
    public Usuarios(){
        usuarios = new ArrayList<Usuario>();
    }
    //añadir usuario
    public void addUsuario(Usuario usuario){
        usuarios.add(usuario);
    }
    //eliminar usuario
    public void removeUsuario(Usuario usuario){
        usuarios.remove(usuario);
    }
    //buscar usuario
    public Usuario buscarUsuario(int codigo){
        for(Usuario usuario: usuarios){
            if(usuario.getTipoDocumento().getCodigo()==(codigo)){
                return usuario;
            }
        }
        return null;
    }
    // posicion de usuario
    public int posicionUsuario(Usuario usuario){
        return usuarios.indexOf(usuario);
    }
    
        //eliminar usuario por documento
    public void removeUsuario(int codigo){
        for(Usuario usuario: usuarios){
            if(usuario.getTipoDocumento().getCodigo()==codigo){
                usuarios.remove(usuario);
                break;
            }
        }
    }
    //ver tarjetas
    public ArrayList<Tarjeta> verTarjetas(Usuario usuario){
        return usuario.getTarjetas();
    }
    //ver movimientos
    public ArrayList<Movimiento> verMovimientos(Usuario usuario, Tarjeta tarjeta){
        return usuario.getTarjetas().get(usuario.getTarjetas().indexOf(tarjeta)).getMovimientos();
    }
    //añadir tarjeta
    public void addTarjeta(Usuario usuario, Tarjeta tarjeta){
        usuario.getTarjetas().add(tarjeta);
    }
    //eliminar tarjeta
    public void removeTarjeta(Usuario usuario, Tarjeta tarjeta){
        usuario.getTarjetas().remove(tarjeta);
    }
    //añadir movimiento
    public void addMovimiento(Usuario usuario, Tarjeta tarjeta, Movimiento movimiento){
        usuario.getTarjetas().get(usuario.getTarjetas().indexOf(tarjeta)).getMovimientos().add(movimiento);
    }
    //eliminar movimiento
    public void removeMovimiento(Usuario usuario, Tarjeta tarjeta, Movimiento movimiento){
        usuario.getTarjetas().get(usuario.getTarjetas().indexOf(tarjeta)).getMovimientos().remove(movimiento);
    }
    //ver usuarios
    public ArrayList<Usuario> verUsuarios(){
        return usuarios;
    }
      //editar usuarios
    public void editarUsuario(int cod, String nombre, String apellidoP, String ApellidoM,TipoDocumento d){
        for(Usuario usuario: usuarios){
            if(usuario.getTipoDocumento().getCodigo()==cod){
                usuario.setNombres(nombre);
                usuario.setPaterno(apellidoP);
                usuario.setMaterno(ApellidoM);
                usuario.setTipoDocumento(d);
                break;
            }
        }
    }
}
