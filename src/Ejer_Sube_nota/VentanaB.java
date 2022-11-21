package Ejer_Sube_nota;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class VentanaB extends JFrame {
    static JLabel etiquetaB;
    private static JTextField texto;
    private final JButton botonA;
    private final JButton botonC;

    String exitB = "La ventana B se ha cerrado";

    public VentanaB() {
        super("B");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        etiquetaB = new JLabel("Envía el texto a otra ventana ");
        texto = new JTextField("Envio de Ventana B");
        botonA = new JButton("VentanaA");
        botonC = new JButton("VentanaC");
        cp.add(etiquetaB);
        cp.add(botonA);
        cp.add(botonC);
        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                e.getWindow().dispose();
                System.out.println("Closed B");
                VentanaA.etiquetaA.setText(exitB);
                VentanaC.etiquetaC.setText(exitB);

                JOptionPane.showMessageDialog(null, "¡Chao, " +
                        exitB + "!");
            }
        });
    }

    public void listenersOn() {
        botonA.addActionListener(new Listener(VentanaA.getEtiqueta(), VentanaB.getTexto()));
        botonC.addActionListener(new Listener(VentanaC.getEtiqueta(), VentanaB.getTexto()));
    }

    public static JTextField getTexto() {
        return texto;
    }

    public static JLabel getEtiqueta() {
        return etiquetaB;
    }

    public static void setEtiquetaB(JLabel etiquetaB) {
        VentanaB.etiquetaB = etiquetaB;
    }


}