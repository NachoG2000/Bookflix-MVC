package vista;
import javax.swing.*;
import java.awt.*;

import controlador.ControladorCatalogo;
import controlador.ControladorUsuario;
import vista.paneles.*;


public class VistaPrincipal extends JFrame {
    private JPanel panelActual;

    public VistaPrincipal(ControladorUsuario controladorUsuario, ControladorCatalogo controladorCatalogo) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900, 600);
        this.setLayout(new BorderLayout());
        this.panelActual = new PanelInicio(controladorUsuario, controladorCatalogo, this);
        this.add(panelActual, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public void cambiarPanel(JPanel nuevoPanel) {
        this.remove(panelActual);
        this.panelActual = nuevoPanel;
        this.add(panelActual, BorderLayout.CENTER);
        this.validate();
        this.repaint();
    }
}