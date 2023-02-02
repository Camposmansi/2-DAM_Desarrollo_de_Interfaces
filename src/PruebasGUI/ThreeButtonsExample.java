package PruebasGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThreeButtonsExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Three Buttons Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField textField = new JTextField(20);
        JButton button1 = new JButton("Click Me");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                JOptionPane.showMessageDialog(frame, "Text entered: " + text);
            }
        });
        JButton button2 = new JButton("Button 2");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JPanel panel1 = new JPanel();
        panel1.add(textField);
        panel1.add(button1);
        panel.add(panel1);

        JPanel panel2 = new JPanel();
        panel2.add(button2);
        panel.add(panel2);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}


