package Ejer_Sube_nota;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Listener implements ActionListener {
    private String texto2;
    private final JLabel etiqueta;
    private JTextField texto;

    public Listener(JLabel etiqueta, JTextField texto) {
        this.etiqueta = etiqueta;
        this.texto = texto;
    }

    public Listener(JLabel etiqueta, String texto2) {
        this.etiqueta = etiqueta;
        this.texto2 = texto2;
    }

    public void actionPerformed(ActionEvent e) {
        etiqueta.setText(texto.getText());
    }
}