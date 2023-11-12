package vista.paneles;

import javax.swing.*;
import java.awt.*;

import controlador.ControladorCatalogo;
import controlador.ControladorUsuario;
import vista.VistaPrincipal;

public class PanelInicio extends JPanel {
    private JButton botonIniciarSesion;
    private JButton botonCrearCuenta;

    public PanelInicio(ControladorUsuario controladorUsuario, ControladorCatalogo controladorCatalogo, VistaPrincipal vistaPrincipal){
        this.botonIniciarSesion = new JButton("Iniciar sesión");
        this.botonCrearCuenta = new JButton("Crear cuenta");
        JLabel titulo = new JLabel("Bookflix");
        
        // Cambiar el tamaño de la fuente
        Font font = titulo.getFont();
        titulo.setFont(new Font(font.getName(), Font.PLAIN, 36)); // Tamaño de la fuente: 36
        
        // Utilizar un GridLayout para organizar los componentes
        setLayout(new GridLayout(2, 1)); // 2 filas, 1 columna
        
        JPanel panelTitulo = new JPanel();
        panelTitulo.add(titulo);

        // Crear un panel para los botones
        JPanel panelBotones = new JPanel();
        panelBotones.add(botonIniciarSesion);
        panelBotones.add(botonCrearCuenta);


        // Agregar los componentes al panel
        add(panelTitulo);
        add(panelBotones);

        botonIniciarSesion.addActionListener(e -> vistaPrincipal.cambiarPanel(new PanelIniciarSesion(controladorUsuario, controladorCatalogo, vistaPrincipal)));
        botonCrearCuenta.addActionListener(e -> vistaPrincipal.cambiarPanel(new PanelCrearCuenta(controladorUsuario, controladorCatalogo, vistaPrincipal)));
    }
}
