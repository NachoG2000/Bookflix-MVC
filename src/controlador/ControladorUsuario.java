package controlador;

import vista.VistaPrincipal;

public class ControladorUsuario {
    private VistaPrincipal vistaPrincipal;

    public void setVistaPrincipal(VistaPrincipal vistaPrincipal){
        this.vistaPrincipal = vistaPrincipal;
    }

    public boolean iniciarSesion(String usuario, String contrasenia){
        if(usuario.equals("a") && contrasenia.equals("a")){ // En este if verificar si existe el usuario en base de datos
            System.out.println("Iniciar sesion: Exitoso");
            return true;
        }
        System.out.println("Iniciar sesion: Error al iniciar sesion");
        return false;
    }

    public boolean cerrarSesion(){
        System.out.println("Cerrar sesion: Exitoso"); // Manejar el cerrado de sesion
        return true;
    }
}
