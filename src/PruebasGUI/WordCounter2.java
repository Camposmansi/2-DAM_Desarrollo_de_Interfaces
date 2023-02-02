package PruebasGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCounter2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Word Counter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea textArea = new JTextArea(10, 20);
        JScrollPane scrollPane = new JScrollPane(textArea);
        JButton countButton = new JButton("Count");
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea.getText();
                String[] words = text.split("\\s+");
                int wordCount = words.length;
                JOptionPane.showMessageDialog(frame, "Word count: " + wordCount);
            }
        });

        JPanel panel = new JPanel();
        panel.add(scrollPane);
        panel.add(countButton);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}

