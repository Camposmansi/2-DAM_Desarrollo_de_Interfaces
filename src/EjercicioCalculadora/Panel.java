package EjercicioCalculadora;

import javax.swing.*;
import java.awt.*;

public class Panel extends JFrame {
    private JButton display;
    private JPanel panel;

    public Panel() {
        super("Ejercicio Calculadora");
        setLayout(new BorderLayout());
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Container cp = getContentPane();
        display = new JButton("0");
        display.setEnabled(false);
        display.setFont(display.getFont().deriveFont(50f));
        add(display, BorderLayout.NORTH);
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));
        //gl.setHgap(1);
        //gl.setVgap(1);
        for (int i = 1; i <= 3; i++) {
            panel.add(new JButton(String.valueOf(i)));
        }
        panel.add(new JButton("X"));
        for (int i = 4; i <= 6; i++) {
            panel.add(new JButton(String.valueOf(i)));
        }
        panel.add(new JButton("-"));
        for (int i = 7; i <= 9; i++) {
            panel.add(new JButton(String.valueOf(i)));
        }
        panel.add(new JButton("+"));
        panel.add(new JButton("*"));
        panel.add(new JButton("0"));
        panel.add(new JButton("#"));
        panel.add(new JButton("="));
        add(panel,BorderLayout.CENTER);
    }
}
