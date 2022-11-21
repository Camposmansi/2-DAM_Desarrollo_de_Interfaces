import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventoSaludo implements ActionListener {
    private JTextField cuadroTexto;

    public EventoSaludo(JTextField cuadroTexto) {
        this.cuadroTexto = cuadroTexto;
    }

    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "¡Hola, " +
                cuadroTexto.getText() + "!");
    }
}
