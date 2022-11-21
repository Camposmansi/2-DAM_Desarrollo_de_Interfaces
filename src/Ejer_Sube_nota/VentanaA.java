package Ejer_Sube_nota;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class VentanaA extends JFrame {

    static JLabel etiquetaA;
    static JTextField texto;

    private final JButton botonB;
    private final JButton botonC;

    String exitA = "La ventana A se ha cerrado";

    public VentanaA() {
        super("A");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        etiquetaA = new JLabel("Envía el texto a otra ventana ");
        texto = new JTextField("Envio de Ventana A");
        botonB = new JButton("VentanaB");
        botonC = new JButton("VentanaC");
        cp.add(etiquetaA);
        cp.add(botonB);
        cp.add(botonC);

        /** Extra:
          * Si la ventana que recibe la información ha sido cerrada por el usuario,
          * la ventana que envía la información deberá reflejar que la ventana receptora está cerrada. **/
        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                e.getWindow().dispose();
                /** Mostramos por consola que se ha cerrado **/
                System.out.println("Closed A");

                /** Mostramos en cada ventana el texto exit al salir **/
                VentanaB.etiquetaB.setText(exitA);
                VentanaC.etiquetaC.setText(exitA);

                /** Mostramos un Dialog un dialogo **/
                JOptionPane.showMessageDialog(null, "¡Chao, " +
                        exitA + "!");
            }
        });
        /*********** FIN DEL EXTRA ******************/
    }

    public void listenersOn() {
        botonB.addActionListener(new Listener(VentanaB.getEtiqueta(), VentanaA.getTexto()));
        botonC.addActionListener(new Listener(VentanaC.getEtiqueta(), VentanaA.getTexto()));
    }

    public static JTextField getTexto() {
        return texto;
    }

    public static JLabel getEtiqueta() {
        return etiquetaA;
    }

    public static void setEtiquetaA(JLabel etiquetaA) {
        VentanaA.etiquetaA = etiquetaA;
    }
}
