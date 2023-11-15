package vista.paneles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import controlador.ControladorCatalogo;
import controlador.ControladorUsuario;
import vista.VistaPrincipal;

public class PanelBibliotecaAdmin extends JPanel{

    public PanelBibliotecaAdmin(ControladorUsuario controladorUsuario, ControladorCatalogo controladorCatalogo, VistaPrincipal vistaPrincipal){
        setLayout(new BorderLayout());

        // Parte superior
        JLabel mensajeBienvenida = new JLabel("Bienvenido, " + controladorUsuario.getUsuarioActual().getNombreUsuario());
        add(mensajeBienvenida, BorderLayout.NORTH);

        // Parte central
        JPanel panelCentral = new JPanel(new GridLayout(1, 2));

        // Formulario para agregar libro
        JPanel panelAgregarLibro = new JPanel(new GridLayout(10, 1));
        panelAgregarLibro.add(new JLabel("Nombre del libro a agregar:"));
        JTextField nombreLibro = new JTextField();
        panelAgregarLibro.add(nombreLibro);

        panelAgregarLibro.add(new JLabel("Autor del libro:"));
        JTextField autorLibro = new JTextField();
        panelAgregarLibro.add(autorLibro);

        panelAgregarLibro.add(new JLabel("Género del libro:"));
        JTextField generoLibro = new JTextField();
        panelAgregarLibro.add(generoLibro);

        panelAgregarLibro.add(new JLabel("Descripción del libro:"));
        JTextField descripcionLibro = new JTextField();
        panelAgregarLibro.add(descripcionLibro);

        JButton botonAgregarLibro = new JButton("Agregar libro");
        panelAgregarLibro.add(botonAgregarLibro);

        // Añade un borde vacío al panel para agregar un libro
        panelAgregarLibro.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10)); // 10 pixels de padding a la derecha

        // Formulario para eliminar libro
        JPanel panelEliminarLibro = new JPanel(new GridLayout(4, 1));
        panelEliminarLibro.add(new JLabel("Nombre del libro a eliminar:"));
        JTextField nombreLibroEliminar = new JTextField();
        panelEliminarLibro.add(nombreLibroEliminar);
        JButton botonEliminarLibro = new JButton("Eliminar libro");
        panelEliminarLibro.add(botonEliminarLibro);

        // Añade un borde vacío al panel para eliminar un libro
        panelEliminarLibro.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0)); // 10 pixels de padding a la izquierda

        panelCentral.add(panelAgregarLibro);
        panelCentral.add(panelEliminarLibro);

        add(panelCentral, BorderLayout.CENTER);

        // Parte inferior
        JButton botonCerrarSesion = new JButton("Cerrar sesión");
        add(botonCerrarSesion, BorderLayout.SOUTH);

        botonAgregarLibro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreLibro.getText();
                String autor = autorLibro.getText();
                String genero = generoLibro.getText();
                String descripcion = descripcionLibro.getText();
        
                if (controladorCatalogo.agregarLibro(nombre, autor, genero, descripcion)) {
                    System.out.println("Exito: Libro agregado correctamente");
                    // Dejar vacíos los campos de texto
                    nombreLibro.setText("");
                    autorLibro.setText("");
                    generoLibro.setText("");
                    descripcionLibro.setText("");
                }
                else{
                    System.out.println("Error: No se pudo agregar el libro");
                }
            }      
        });
        
        botonEliminarLibro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreLibroEliminar.getText();
        
                if (controladorCatalogo.eliminarLibro(nombre)) {
                    System.out.println("Exito: Libro eliminado correctamente");
                    // Dejar vacío el campo de texto
                    nombreLibroEliminar.setText("");
                }
                else{
                    System.out.println("Error: No se pudo eliminar el libro");
                }
            }      
        });

        botonCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (controladorUsuario.cerrarSesion()) {
                    vistaPrincipal.cambiarPanel(new PanelInicio(controladorUsuario, controladorCatalogo, vistaPrincipal));
                }
            }
        });
    }
}
