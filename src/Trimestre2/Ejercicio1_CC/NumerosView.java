package Trimestre2.Ejercicio1_CC;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class NumerosView {
    private NumerosController controlador;
    private JFrame frame;
    private JTextField inputNumero;
    private JTextArea outputNumeros;

    public NumerosView(NumerosController controlador) {
        this.controlador = controlador;
        crearVentana();
    }

    /**
     * Crea la ventana de la aplicación con todos los componentes.
     */
    private void crearVentana() {
        // Crear la ventana principal
        frame = new JFrame("NumerosApp");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Crear el panel principal
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);

        // Crear los componentes y agregarlos al panel
        JLabel labelNumero = new JLabel("Número:");
        c.gridx = 0;
        c.gridy = 0;
        panelPrincipal.add(labelNumero, c);

        inputNumero = new JTextField(10);
        c.gridx = 1;
        c.gridy = 0;
        panelPrincipal.add(inputNumero, c);

        JButton botonCargarSinBorrar = new JButton("Cargar sin borrar");
        botonCargarSinBorrar.addActionListener(e -> cargarNumero(false));
        c.gridx = 0;
        c.gridy = 1;
        panelPrincipal.add(botonCargarSinBorrar, c);

        JButton botonCargarYBorrar = new JButton("Cargar y borrar");
        botonCargarYBorrar.addActionListener(e -> cargarNumero(true));
        c.gridx = 1;
        c.gridy = 1;
        panelPrincipal.add(botonCargarYBorrar, c);

        JButton botonBorrar = new JButton("Borrar");
        botonBorrar.addActionListener(e -> borrarNumeros());
        c.gridx = 2;
        c.gridy = 1;
        panelPrincipal.add(botonBorrar, c);

        outputNumeros = new JTextArea(10, 20);
        outputNumeros.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputNumeros);
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 3;
        panelPrincipal.add(scrollPane, c);

        JButton botonImprimirTodos = new JButton("Imprimir todos");
        botonImprimirTodos.addActionListener(e -> imprimirNumeros());
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 1;
        panelPrincipal.add(botonImprimirTodos, c);

        JButton botonImprimirUno = new JButton("Imprimir uno");
        botonImprimirUno.addActionListener(e -> imprimirNumero());
        c.gridx = 1;
        c.gridy = 3;
        panelPrincipal.add(botonImprimirUno, c);

        JButton botonCambiarOrden = new JButton("Cambiar de orden");
        botonCambiarOrden.addActionListener(e -> cambiarOrden());
        c.gridx = 2;
        c.gridy = 3;
        panelPrincipal.add(botonCambiarOrden, c);

        JButton botonBorrarUltimo = new JButton("Borrar el último de la fila");
        botonBorrarUltimo.addActionListener(e -> borrarUltimoNumero());
        c.gridx = 0;
        c.gridy = 4;
        panelPrincipal.add(botonBorrarUltimo, c);
        JButton botonBorrarPrimero = new JButton("Borrar el primero de la fila");
        botonBorrarPrimero.addActionListener(e -> borrarPrimerNumero());
        c.gridx = 1;
        c.gridy = 4;
        panelPrincipal.add(botonBorrarPrimero, c);

        JButton botonQuitarMenor = new JButton("Quitar el número menor");
        botonQuitarMenor.addActionListener(e -> quitarNumeroMenor());
        c.gridx = 2;
        c.gridy = 4;
        panelPrincipal.add(botonQuitarMenor, c);

        JButton botonQuitarMayor = new JButton("Quitar el número mayor");
        botonQuitarMayor.addActionListener(e -> quitarNumeroMayor());
        c.gridx = 0;
        c.gridy = 5;
        panelPrincipal.add(botonQuitarMayor, c);

        frame.add(panelPrincipal);
        frame.setVisible(true);
    }

    /**
     * Carga un número en el modelo y actualiza la vista.
     * borrarAnteriores indica si se deben borrar los números anteriores
     */
    private void cargarNumero(boolean borrarAnteriores) {
        try {
            int numero = Integer.parseInt(inputNumero.getText());
            controlador.cargarNumero(numero, borrarAnteriores);
            actualizarOutputNumeros();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Debe ingresar un número entero válido");
        }
    }

    /**
     * Borra todos los números del modelo y actualiza la vista.
     */
    private void borrarNumeros() {
        controlador.borrarNumeros();
        actualizarOutputNumeros();
    }

    /**
     * Imprime todos los números del modelo en la consola y en un cuadro de diálogo.
     */
    private void imprimirNumeros() {
        controlador.imprimirNumeros();
    }

    /**
     * Imprime un número del modelo en la consola y en un cuadro de diálogo.
     */
    private void imprimirNumero() {
        try {
            int indice = Integer.parseInt(JOptionPane.showInputDialog(frame, "Ingrese el índice del número a imprimir"));
            controlador.imprimirNumero(indice);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Debe ingresar un número entero válido");
        }
    }

    /**
     * Cambia el orden de los números del modelo y actualiza la vista.
     */
    private void cambiarOrden() {
        controlador.cambiarOrden();
        actualizarOutputNumeros();
    }

    /**
     * Borra el último número del modelo y actualiza la vista.
     */
    private void borrarUltimoNumero() {
        controlador.borrarUltimo();
        actualizarOutputNumeros();
    }

    /**
     * Borra el primer número del modelo y actualiza la vista.
     */
    private void borrarPrimerNumero() {
        controlador.borrarPrimero();
        actualizarOutputNumeros();
    }

    /**
     * Quita el número menor del modelo y actualiza la vista.
     */
    private void quitarNumeroMenor() {
        controlador.quitarMenor();
        actualizarOutputNumeros();
    }

    /**
     * Quita el número mayor del modelo y actualiza la vista.
     */
    private void quitarNumeroMayor() {
        controlador.quitarMayor();
        actualizarOutputNumeros();
    }

    /**
     * Actualiza el cuadro de texto de números cargados con los números del modelo.
     */
    private void actualizarOutputNumeros() {
        outputNumeros.setText("");
        ArrayList<Integer> numeros = (ArrayList<Integer>) controlador.getNumeros(); // Obtenemos los números del modelo
        for (Integer numero : numeros) {
            outputNumeros.append(numero + "\n"); // Agregamos los números al cuadro de texto
        }
    }
}
