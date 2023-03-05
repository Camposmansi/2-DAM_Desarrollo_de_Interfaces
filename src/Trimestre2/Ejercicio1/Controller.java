package Trimestre2.Ejercicio1;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.List;

public class Controller {

    private final Model MODEL;

    public Controller(Model modelo) {
        this.MODEL = modelo;
    }

    public void mostrarInformacion() {
        // Crear y configurar la ventana
        JFrame infoFrame = new JFrame("Información del programa");
        infoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        infoFrame.setSize(400, 200);

        // Crear los JLabels y asignarles un texto
        JLabel label1 = new JLabel("Ejercicio 1 de Desarrollo de interfaces");
        label1.setHorizontalAlignment(SwingConstants.CENTER); // Centramos el texto

        JLabel label2 = new JLabel("Desarrollado por: Carlos Campos");
        label2.setHorizontalAlignment(SwingConstants.CENTER); // Centramos el texto

        // Agregar los JLabels al panel principal
        JPanel infoPanel = new JPanel(new GridLayout(4, 1, 0, 10));
        infoPanel.add(label1);
        infoPanel.add(label2);

        // Agregar el panel al frame y hacerlo visible
        infoFrame.getContentPane().add(infoPanel);
        infoFrame.setVisible(true);
    }

    public void cargarNumero(boolean borrarAnteriores, JFrame frame, JTextField input, JTextArea output1) {
        try {
            int numero = Integer.parseInt(input.getText());
            if (borrarAnteriores) {
                borrarNumeros(output1);
                input.setText("");
            }
            MODEL.agregarNumero(numero);
            //input.setText(String.valueOf(numero));
            actualizarOutput(output1);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Debe ingresar un número entero válido");
        }
    }

    public void borrarNumeros(JTextArea output1) {
        MODEL.borrarNumeros();
        actualizarOutput(output1);
    }

    public void imprimirNumeros(JTextArea output2) {
        List<Integer> numeros = MODEL.getNumeros();
        System.out.println("Números cargados:");
        for (Integer numero : numeros) {
            System.out.println(numero);
        }
        actualizarOutput(output2);
    }

    public void imprimirNumero(JFrame frame, JTextArea output2) {
        try {
            int indice = Integer.parseInt(JOptionPane.showInputDialog(frame, "Ingrese el índice del número a mostrar"));
            List<Integer> numeros = MODEL.getNumeros();
            if (indice >= 0 && indice < numeros.size()) {
                System.out.println("Número en la posición " + indice + ": " + numeros.get(indice));
                output2.setText("");
                output2.append(String.valueOf(numeros.get(indice)));
            } else {
                output2.setText("");
                System.out.println("Posición no válida");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Debe ingresar un número válido");
        }
    }

    public void cambiarOrden(JTextArea output2) {
        MODEL.cambiarOrden();
        actualizarOutput(output2);
    }

    public void borrarUltimo(JTextArea output2) {
        MODEL.borrarUltimo();
        actualizarOutput(output2);
    }

    public void borrarPrimero(JTextArea output2) {
        MODEL.borrarPrimero();
        actualizarOutput(output2);
    }

    public void quitarMenor(JTextArea output2) {
        List<Integer> numeros = MODEL.getNumeros();
        if (!numeros.isEmpty()) {
            Integer menor = Collections.min(numeros);
            MODEL.quitarNumero(menor);
        }
        actualizarOutput(output2);
    }

    public void quitarMayor(JTextArea output2) {
        List<Integer> numeros = MODEL.getNumeros();
        if (!numeros.isEmpty()) {
            Integer mayor = Collections.max(numeros);
            MODEL.quitarNumero(mayor);
        }
        actualizarOutput(output2);
    }

    public void actualizarOutput(JTextArea output) {
        output.setText("");
        List<Integer> numeros = MODEL.getNumeros();
        for (Integer numero : numeros) {
            output.append(numero + "\n");
        }
    }

}
