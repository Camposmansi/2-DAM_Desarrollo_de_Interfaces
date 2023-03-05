package Trimestre2.GridBagLayout_Google;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GoogleLayout {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JTextField textField = new JTextField();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 4;
        c.insets = new Insets(10, 10, 10, 10);
        panel.add(textField, c);

        JButton searchButton = new JButton("Search");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 4;
        c.gridy = 0;
        c.gridwidth = 1;
        c.insets = new Insets(10, 0, 10, 10);
        panel.add(searchButton, c);

        JButton gmailButton = new JButton("Gmail");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 5;
        c.gridy = 0;
        c.gridwidth = 1;
        c.insets = new Insets(10, 0, 10, 10);
        panel.add(gmailButton, c);

        JButton imagesButton = new JButton("Images");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 6;
        c.gridy = 0;
        c.gridwidth = 1;
        c.insets = new Insets(10, 0, 10, 10);
        panel.add(imagesButton, c);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
