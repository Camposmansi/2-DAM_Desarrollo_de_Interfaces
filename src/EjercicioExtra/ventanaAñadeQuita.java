package EjercicioExtra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ventanaAñadeQuita implements ActionListener {

    private JLabel label = new JLabel("Añade o quita un boton");
    private JLabel vacio = new JLabel("");
    private JLabel vacio2 = new JLabel("");
    private JFrame frame = new JFrame();
    JPanel panel;
    JButton button;
    JButton buttonA;
    JButton buttonQ;

    public ventanaAñadeQuita() {
        // el botón
        button = new JButton("Añadir Nuevo");
        button.addActionListener(this);
        buttonA = new JButton("Nuevo Boton");
        button.addActionListener(this);
        buttonQ = new JButton("Quitar Boton");
        button.addActionListener(this);

        // el panel con el botón y el texto
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 40, 100, 40));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(label);
        panel.add(button);
        panel.add(vacio);
        panel.add(buttonA);
        buttonA.setVisible(false);
        panel.add(buttonQ);
        buttonQ.setVisible(false);


        // configura el marco y muéstralo
        Image icon = new ImageIcon(getClass().getResource("minion.png")).getImage();
        frame.setIconImage(icon);
        frame.setResizable(false);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("ventanaAñadeQuita");
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            panel = new JPanel();
            buttonA.setVisible(true);
            buttonQ.setVisible(true);
            //panel.add(buttonA);
            //panel.add(buttonQ);
        }
        if (e.getSource() == buttonQ) {
            buttonA.setVisible(false);
            buttonQ.setVisible(false);
            //panel.remove(buttonA);
            //panel.remove(buttonQ);
        }
    }

    public static void main(String[] args) {
        new ventanaAñadeQuita();
    }
}
