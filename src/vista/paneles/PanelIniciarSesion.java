package vista.paneles;

import javax.swing.*;
import java.awt.*;

import controlador.ControladorCatalogo;
import controlador.ControladorUsuario;
import vista.VistaPrincipal;

public class PanelIniciarSesion extends JPanel {
    private JTextField nombreUsuarioField;
    private JPasswordField contraseniaField;
    private JButton botonIniciarSesion;
    private JButton botonAtras;

    public PanelIniciarSesion(ControladorUsuario controladorUsuario, ControladorCatalogo controladorCatalogo, VistaPrincipal vistaPrincipal){
        this.setLayout(new GridLayout(4, 1));

        JLabel etiqueta1 = new JLabel("Usuario:");
        nombreUsuarioField = new JTextField();
        nombreUsuarioField.setPreferredSize(new Dimension(200, 30));

        JLabel etiqueta2 = new JLabel("Contraseña:");
        contraseniaField = new JPasswordField();
        contraseniaField.setPreferredSize(new Dimension(200, 30));

        add(etiqueta1);
        add(nombreUsuarioField);
        add(etiqueta2);
        add(contraseniaField);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        this.botonIniciarSesion = new JButton("Iniciar sesión");
        this.botonAtras = new JButton("Atrás");
        panelBotones.add(botonIniciarSesion);
        panelBotones.add(botonAtras);

        this.add(panelBotones);

        botonAtras.addActionListener(e -> vistaPrincipal.cambiarPanel(new PanelInicio(controladorUsuario, controladorCatalogo, vistaPrincipal)));

        botonIniciarSesion.addActionListener(e -> {
            String usuario = nombreUsuarioField.getText();
            char[] contrasenia = contraseniaField.getPassword();

            if(controladorUsuario.iniciarSesion(usuario, new String(contrasenia))) {
                if(!controladorUsuario.getUsuarioActual().getEsAdmin()){
                    vistaPrincipal.cambiarPanel(new PanelBibliotecaCliente(controladorUsuario, controladorCatalogo, vistaPrincipal)); // Ver si el usuario ingresado es admin o cliente antes de cambiar vista
                }
                else{
                    vistaPrincipal.cambiarPanel(new PanelBibliotecaAdmin(controladorUsuario, controladorCatalogo, vistaPrincipal)); // Ver si el usuario ingresado es admin o cliente antes de cambiar vista
                }
            } else {
                System.out.println("Verifica las credenciales");
            }
        });
    }
}
