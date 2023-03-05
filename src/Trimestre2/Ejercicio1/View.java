package Trimestre2.Ejercicio1;

import javax.swing.*;
import java.awt.*;

public class View {
    private final Controller CONTROL;
    private JFrame frame;
    private JTextField input;
    private JTextArea output1;
    private JTextArea output2;

    private JMenuBar menuBar;


    public View(Controller controlador) {
        this.CONTROL = controlador;
        Ventana();
        Menu();
    }

    private void Ventana() {
        frame = new JFrame("Ejercicio 1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(950, 350);

        // Crear un panel principal con un GridBagLayout
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridBagLayout());

        // Crear un objeto GridBagConstraints para configurar la posición y tamaño de los componentes
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5); // Agregar un margen de 5 píxeles en todos los lados
        gbc.fill = GridBagConstraints.BOTH; // Permitir que los componentes se expandan tanto en horizontal como en vertical

        // Crear un JTextField para ingresar el texto a buscar
        input = new JTextField(15);
        gbc.gridx = 0; // Colocar el JTextField en la primera columna
        gbc.gridy = 0; // Colocar el JTextField en la primera fila
        gbc.gridwidth = 1; // El JTextField ocupa una celda en horizontal
        gbc.gridheight = 1; // El JTextField ocupa una celda en vertical
        panelPrincipal.add(input, gbc); // Agregar el JTextField al panel principal


        JButton cargarSinBorrar = new JButton("Cargar sin borrar");
        cargarSinBorrar.addActionListener(e -> CONTROL.cargarNumero(false, frame, input, output1));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        panelPrincipal.add(cargarSinBorrar, gbc);

        JButton cargarYBorrar = new JButton("Cargar y borrar");
        cargarYBorrar.addActionListener(e -> CONTROL.cargarNumero(true, frame, input, output1));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        panelPrincipal.add(cargarYBorrar, gbc);

        JButton borrar = new JButton("Borrar");
        borrar.addActionListener(e -> CONTROL.borrarNumeros(output1));
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        panelPrincipal.add(borrar, gbc);

        output1 = new JTextArea(5, 15);
        output1.setEditable(false);
        JScrollPane scrollPane1 = new JScrollPane(output1);
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 7;
        panelPrincipal.add(scrollPane1, gbc);

        JButton imprimirTodos = new JButton("Imprimir todos");
        imprimirTodos.addActionListener(e -> CONTROL.imprimirNumeros(output2));
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        panelPrincipal.add(imprimirTodos, gbc);

        JButton imprimirUno = new JButton("Imprimir uno");
        imprimirUno.addActionListener(e -> CONTROL.imprimirNumero(frame, output2));
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        panelPrincipal.add(imprimirUno, gbc);

        JButton cambiarOrden = new JButton("Cambiar de orden");
        cambiarOrden.addActionListener(e -> CONTROL.cambiarOrden(output2));
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        panelPrincipal.add(cambiarOrden, gbc);

        JButton borrarUltimo = new JButton("Borrar el último de la fila");
        borrarUltimo.addActionListener(e -> CONTROL.borrarUltimo(output2));
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        panelPrincipal.add(borrarUltimo, gbc);

        JButton borrarPrimero = new JButton("Borrar el primero de la fila");
        borrarPrimero.addActionListener(e -> CONTROL.borrarPrimero(output2));
        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        panelPrincipal.add(borrarPrimero, gbc);

        JButton quitarNumeroMenor = new JButton("Quitar el número menor");
        quitarNumeroMenor.addActionListener(e -> CONTROL.quitarMenor(output2));
        gbc.gridx = 3;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        panelPrincipal.add(quitarNumeroMenor, gbc);

        JButton quitarNumeroMayor = new JButton("Quitar el número mayor");
        quitarNumeroMayor.addActionListener(e -> CONTROL.quitarMayor(output2));
        gbc.gridx = 3;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        panelPrincipal.add(quitarNumeroMayor, gbc);

        output2 = new JTextArea(5, 15);
        output2.setEditable(false);
        JScrollPane scrollPane2 = new JScrollPane(output2);
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 7;
        panelPrincipal.add(scrollPane2, gbc);

        frame.setContentPane(panelPrincipal);
        frame.setVisible(true);
    }

    private void Menu() {
        menuBar = new JMenuBar();
        JMenu menu = new JMenu("Archivo");
        JMenu menu2 = new JMenu("Informacion");


        JMenuItem menuItem1 = new JMenuItem("Salir");
        menuItem1.addActionListener(e -> {
            System.exit(0); // Cerrar la aplicación
        });

        JMenuItem menuItem2 = new JMenuItem("Ver info");
        menuItem2.addActionListener(e -> {
            CONTROL.mostrarInformacion(); // Mostrar ventana de información
        });

        menu.add(menuItem1);
        menu2.add(menuItem2);
        menuBar.add(menu);
        menuBar.add(menu2);
        frame.setJMenuBar(menuBar);
    }


}
