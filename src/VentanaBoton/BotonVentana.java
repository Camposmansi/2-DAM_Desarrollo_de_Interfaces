package VentanaBoton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotonVentana extends JFrame  {
    public BotonVentana() {
        super("Botón");
        setSize(200,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        JButton boton = new JButton("¡Púlsame!");
        boton.addActionListener((ActionListener) new EventoBotonPulsado());
        cp.add(boton);
    }


}
