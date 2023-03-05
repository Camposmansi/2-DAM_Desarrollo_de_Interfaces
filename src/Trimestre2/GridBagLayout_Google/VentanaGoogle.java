package Trimestre2.GridBagLayout_Google;

import java.awt.*;
import javax.swing.*;

public class VentanaGoogle extends JFrame {
    public VentanaGoogle() {
        setSize(1200,800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridBagLayout());

       /* CONJUNTO DE COMPONENTES

       JButton bM1 = new JButton("Gmail");
       JButton bM2 = new JButton("Images");
       JButton bM3 = new JButton("Menu");
       JButton bM4 = new JButton("Personal"); // NOTA PROFE: luego ponemos un icono

       JTextArea taGoogle = new JTextArea("Google");
       JTextField tfBuscar = new JTextField();
       JButton bBuscar = new JButton("Buscar");
       JButton bLucky = new JButton("Voy a tener suerte");

       JTextArea taIdiomas = new JTextArea("Google está en:");
       JButton bIdioma1 = new JButton("Español");
       JButton bIdioma2 = new JButton("català");
       JButton bIdioma3 = new JButton("galego");
       JButton bIdioma4 = new JButton("euskara");
       */

// OTRA FORMA de hacerlo es usando un solo objeto componente como variable. Nos ahorra poner nombres a los objetos de los componentes.

        Container pane = getContentPane();
        GridBagConstraints c = new GridBagConstraints();

        // creamos el primer botón, en este caso del menú
        JButton bM1 = new JButton("Gmail");
        c.gridx = 5;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_END; //bottom of space
        pane.add(bM1, c);
        System.out.println(c);
        c.weightx = 0;


        JButton bM2 = new JButton("Images");
        c.gridx = 6;
        c.gridy = 0;
        pane.add(bM2, c);


        JButton bM3 = new JButton("Menu");
        c.gridx = 7;
        c.gridy = 0;
        pane.add(bM3, c);

        JButton bM4 = new JButton("Personal"); // NOTA PROFE: luego ponemos un icono
        c.gridx = 8;
        c.gridy = 0;
        pane.add(bM4, c);

        // AHORA LA ZONA CENTRAL

        JTextArea taGoogle = new JTextArea("Google", 10,40 );
        System.out.println(taGoogle.getFont());
//        System.out.println("dale");

        taGoogle.setFont(taGoogle.getFont().deriveFont(60f)); // will only change size to 12pt
        c.gridx = 3;
        c.gridy = 1;
        pane.add(taGoogle, c);


        JTextField tfBuscar = new JTextField(" ", 300);
        c.gridx =3;
        c.gridy = 2;
        pane.add(tfBuscar, c);


        JButton bBuscar = new JButton("Buscar");
        c.gridx = 3;
        c.gridy = 3;
        pane.add(bBuscar, c);

        JButton bSuerte = new JButton("Voy a tener suerte");
        c.gridx = 3;
        c.gridy = 3;
        pane.add(bSuerte, c);


// FILA DE IDIOMAS

        JTextArea taIdiomas = new JTextArea("Google está en:");
        c.gridx = 2;
        c.gridy = 4;
        pane.add(taIdiomas, c);

        JButton bIdioma1 = new JButton("Español");
        c.gridx = 3;
        c.gridy = 4;
        pane.add(bIdioma1, c);

        JButton bIdioma2 = new JButton("català");
        c.gridx = 4;
        c.gridy = 4;
        pane.add(bIdioma2, c);

        JButton bIdioma3 = new JButton("galego");
        c.gridx = 5;
        c.gridy = 4;
        pane.add(bIdioma3, c);

        JButton bIdioma4 = new JButton("euskara");
        c.gridx = 6;
        c.gridy = 4;
        pane.add(bIdioma4, c);
    }


    public static void main(String[] args) {
        VentanaGoogle v = new VentanaGoogle();

        v.setVisible(true);


    }


}

