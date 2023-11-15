import controlador.ControladorCatalogo;
import controlador.ControladorUsuario;
import vista.VistaPrincipal;

public class App {
    public static void main(String[] args) throws Exception {
        ControladorUsuario controladorUsuario = new ControladorUsuario();
        ControladorCatalogo controladorCatalogo = new ControladorCatalogo();
        VistaPrincipal vistaPrincipal = new VistaPrincipal(controladorUsuario, controladorCatalogo);
        System.out.println(vistaPrincipal);
    }
}
