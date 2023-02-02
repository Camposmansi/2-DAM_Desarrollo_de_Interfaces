package EjercicioCalculadora;

import javax.swing.*;
import java.awt.*;

public class Calc extends JFrame  {
    String[] numeros = {"1","2","3","4","5","6","7","8","9","Clear","0","V"};
    String[] operadores = {"+","-","*","/","="};
    JButton[] n=new JButton[12];
    JButton[] o=new JButton[5];
    JTextField text;

    public void panel(){
        Container container=getContentPane();
        setTitle("Mi Calculadora");
        setSize(300,250);

        JPanel panel = new JPanel(new GridLayout(1,1,1,1));
        panel.setPreferredSize(new Dimension(300,30));

        JPanel panel2 = new JPanel(new GridLayout(4,3,1,1));
        panel.setPreferredSize(new Dimension(220,10));
        for (int i=0;i<12;i++){
            n[i]=new JButton(numeros[i]);
            //n[i].addActionListener(this);
        }


    }
}
