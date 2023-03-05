package Trimestre2.Ejercicio1;

import javax.swing.*;

public class Main extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new View(new Controller(new Model())));
    }

}


