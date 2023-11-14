package vista.paneles;

import javax.swing.*;
import java.awt.*;

import controlador.ControladorCatalogo;
import controlador.ControladorUsuario;
import vista.VistaPrincipal;

public class PanelCrearCuenta extends JPanel {
    private JTextField nombreUsuarioField;
    private JPasswordField contraseniaField;
    private JPasswordField confirmarContraseniaField;
    private JButton botonCrearCuenta;
    private JButton botonAtras;

    public PanelCrearCuenta(ControladorUsuario controladorUsuario, ControladorCatalogo controladorCatalogo, VistaPrincipal vistaPrincipal){
        this.setLayout(new GridLayout(5, 1));

        JLabel etiqueta1 = new JLabel("Usuario:");
        nombreUsuarioField = new JTextField();
        nombreUsuarioField.setPreferredSize(new Dimension(200, 30));

        JLabel etiqueta2 = new JLabel("Contraseña:");
        contraseniaField = new JPasswordField();
        contraseniaField.setPreferredSize(new Dimension(200, 30));

        JLabel etiqueta3 = new JLabel("Confirmar Contraseña:");
        confirmarContraseniaField = new JPasswordField();
        confirmarContraseniaField.setPreferredSize(new Dimension(200, 30));

        add(etiqueta1);
        add(nombreUsuarioField);
        add(etiqueta2);
        add(contraseniaField);
        add(etiqueta3);
        add(confirmarContraseniaField);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        this.botonCrearCuenta = new JButton("Crear cuenta");
        this.botonAtras = new JButton("Atrás");
        panelBotones.add(botonCrearCuenta);
        panelBotones.add(botonAtras);

        this.add(panelBotones);

        botonAtras.addActionListener(e -> vistaPrincipal.cambiarPanel(new PanelInicio(controladorUsuario, controladorCatalogo, vistaPrincipal)));

        botonCrearCuenta.addActionListener(e -> {
            String usuario = nombreUsuarioField.getText();
            char[] contrasenia = contraseniaField.getPassword();
            char[] confirmarContrasenia = confirmarContraseniaField.getPassword();
            
            if(controladorUsuario.crearCuenta(usuario, new String(contrasenia), new String(confirmarContrasenia))) {
                vistaPrincipal.cambiarPanel(new PanelBibliotecaCliente(controladorUsuario, controladorCatalogo, vistaPrincipal)); // Ver si el usuario ingresado es admin o cliente antes de cambiar vista
            } else {
                System.out.println("Verifica las credenciales");
            }
        });
    }
}
