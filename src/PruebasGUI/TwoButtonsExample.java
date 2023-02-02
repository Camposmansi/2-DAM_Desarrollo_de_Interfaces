package PruebasGUI;

import javax.swing.*;
import java.awt.*;

public class TwoButtonsExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Two Buttons Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");

        panel.add(button1);
        panel.add(button2);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
