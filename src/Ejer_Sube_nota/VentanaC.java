package Ejer_Sube_nota;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class VentanaC extends JFrame {
    static JLabel etiquetaC;
    private static JTextField texto;
    private final JButton botonA;
    private final JButton botonB;
    String exitC = "La ventana C se ha cerrado";
    public VentanaC() {
        super("C");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        etiquetaC = new JLabel("Envía el texto a otra ventana ");
        texto = new JTextField("Envio de Ventana C");
        botonA = new JButton("VentanaA");
        botonB = new JButton("VentanaB");
        cp.add(etiquetaC);
        cp.add(botonA);
        cp.add(botonB);

        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                e.getWindow().dispose();
                System.out.println("Closed C");
                VentanaA.etiquetaA.setText(exitC);
                VentanaB.etiquetaB.setText(exitC);

                JOptionPane.showMessageDialog(null, "¡Chao, " +
                        exitC + "!");
            }
        });
    }

    public void listenersOn() {
        botonA.addActionListener(new Listener(VentanaA.getEtiqueta(), VentanaC.getTexto()));
        botonB.addActionListener(new Listener(VentanaB.getEtiqueta(), VentanaC.getTexto()));
    }

    public static JTextField getTexto() {
        return texto;
    }

    public static JLabel getEtiqueta() {
        return etiquetaC;
    }

    public static void setEtiquetaC(JLabel etiquetaC) {
        VentanaC.etiquetaC = etiquetaC;
    }
}



