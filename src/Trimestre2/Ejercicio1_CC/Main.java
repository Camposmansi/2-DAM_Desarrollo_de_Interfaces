package Trimestre2.Ejercicio1_CC;

import javax.swing.JFrame;

public class Main extends JFrame {

    public static void main(String[] args) {

        new NumerosView(new NumerosController(new NumerosModel()));

    }

}


