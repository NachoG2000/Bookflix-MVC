package vista.paneles.pestañas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controlador.ControladorCatalogo;
import controlador.ControladorUsuario;
import vista.VistaPrincipal;
import vista.paneles.PanelBibliotecaCliente;
import vista.paneles.PanelInicio;

public class PestanyaConfiguracion extends JPanel{
    public PestanyaConfiguracion(ControladorUsuario controladorUsuario, ControladorCatalogo controladorCatalogo, VistaPrincipal vistaPrincipal) {
        JLabel etiquetaConfig = new JLabel("Panel de configuración");
        add(etiquetaConfig);

        JButton botonCerrarSesion = new JButton("Cerrar sesión");
        add(botonCerrarSesion);

        botonCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(controladorUsuario.cerrarSesion()){
                    vistaPrincipal.cambiarPanel(new PanelInicio(controladorUsuario, controladorCatalogo, vistaPrincipal));
                }
            }
        });
    }
}
