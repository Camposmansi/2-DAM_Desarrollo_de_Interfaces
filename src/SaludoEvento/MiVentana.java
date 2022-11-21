package SaludoEvento;

import javax.swing.*;
import java.awt.*;

public class MiVentana extends JFrame {
    public MiVentana() {
        super("Titulo de ventana");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        Container cp = getContentPane();
        cp.add(new JLabel("Nombre :"));
        JTextField texto = new JTextField(20);
        cp.add(texto);
        JButton botonSaludo = new JButton("Saludar");
        cp.add(botonSaludo);
        botonSaludo.addActionListener(new EventoSaludo(texto));
    }
}
