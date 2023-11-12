package vista.paneles;

import javax.swing.*;
import java.awt.*;

import vista.paneles.pestañas.*;
import controlador.ControladorCatalogo;
import controlador.ControladorUsuario;
import vista.VistaPrincipal;

public class PanelBibliotecaCliente extends JPanel{
    private JTabbedPane pestañas;

    public PanelBibliotecaCliente(ControladorUsuario controladorUsuario, ControladorCatalogo controladorCatalogo, VistaPrincipal vistaPrincipal){
        this.setLayout(new BorderLayout()); // Cambiar el layout a BorderLayout

        this.pestañas = new JTabbedPane();

        // Instancia los paneles y añádelos como pestañas
        PestanyaCatalogo panelCatalogo = new PestanyaCatalogo(controladorUsuario, controladorCatalogo, vistaPrincipal);
        PestanyaConfiguracion panelConfiguracion = new PestanyaConfiguracion(controladorUsuario, controladorCatalogo, vistaPrincipal);

        pestañas.addTab("Catálogo", panelCatalogo);
        pestañas.addTab("Configuración", panelConfiguracion);

        this.add(pestañas, BorderLayout.CENTER); // Añadir el JTabbedPane al centro del BorderLayout
    }
}
