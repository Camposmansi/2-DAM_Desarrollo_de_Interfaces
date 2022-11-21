package Ejer_Sube_nota;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Listener implements ActionListener {

    private final JLabel etiqueta;
    private JTextField texto;

    public Listener(JLabel etiqueta, JTextField texto) {
        this.etiqueta = etiqueta;
        this.texto = texto;
    }



    public void actionPerformed(ActionEvent e) {
        etiqueta.setText(texto.getText());
    }
}