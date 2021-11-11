
package Programa;

import Modelo.Tarjeta;
import Modelo.Usuario;
import Modelo.UsuarioArreglo;
import Controlador.ControladorUsuario;
import Controlador.ControladorIngresar;

import Programa.listado;

public class App {
    public static  void main (String[] args){
        Tarjeta t1, t2,t3;
        Usuario usuario;
        UsuarioArreglo Usuarios=new UsuarioArreglo();
        frmUsuario fUsuario = new frmUsuario();
        frmIngreso1 fIngresar=new frmIngreso1();
        
        
        ControladorUsuario controladoruser = new ControladorUsuario(Usuarios,fUsuario,fIngresar );
        ControladorIngresar controlerIngresar=new ControladorIngresar(Usuarios,fUsuario,fIngresar);
        
                usuario = new Usuario("Díaz", "Perez", "Jose", "9080706050", "DNI");
        usuario.registrarTarjeta( 
                        new Tarjeta( 25.0f,2.5f));
                
        Usuarios.agregar(usuario);
        usuario = new Usuario("Rios", "Casas", "Francisco","1020304050","DNI");
        Usuarios.agregar(usuario);
        usuario = new Usuario("Casas", "Perez", "Carlos","1020304050","DNI");
        Usuarios.agregar(usuario);
        
        System.out.println(Usuarios);
        controladoruser.iniciar();
        
        
      
    }
    
   
}
