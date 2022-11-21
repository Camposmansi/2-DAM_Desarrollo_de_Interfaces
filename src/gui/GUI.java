package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI implements ActionListener {
    private int clicks = 0;
    private JLabel label = new JLabel("Numeros de clicks:  0     ");
    private JLabel vacio = new JLabel("");
    private JLabel vacio2 = new JLabel("");
    private JFrame frame = new JFrame();

    public GUI() {


        // el botón
        JCheckBox checkBox = new JCheckBox("Opcion 1");
        JButton button = new JButton("Cliqueame");
        button.addActionListener(this);

        // el panel con el botón y el texto
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);
        panel.add(vacio);
        panel.add(label);
        panel.add(vacio2);
        panel.add(checkBox);

        // configura el marco y muéstralo
        Image icon = new ImageIcon(getClass().getResource("minion.png")).getImage();
        frame.setIconImage(icon);
        frame.setResizable(false);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("GUI");
        frame.pack();
        frame.setVisible(true);
    }

    // procesar los clics del botón
    public void actionPerformed(ActionEvent e) {
        clicks++;
        label.setText("Numeros de clicks:  " + clicks);
    }

    // create one Frame
    public static void main(String[] args) {
        new GUI();
    }


}