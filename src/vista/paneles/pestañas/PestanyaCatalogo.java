package vista.paneles.pestañas;

import javax.swing.*;

import controlador.ControladorCatalogo;
import controlador.ControladorUsuario;
import vista.VistaPrincipal;


public class PestanyaCatalogo extends JPanel{
    public PestanyaCatalogo(ControladorUsuario controladorUsuario, ControladorCatalogo controladorCatalogo, VistaPrincipal vistaPrincipal) {
        JLabel etiquetaCatalogo = new JLabel("Panel de catalogo");
        add(etiquetaCatalogo);
    }
}
