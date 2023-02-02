import javax.swing.*;
import java.awt.*;

public class ejercicio1 extends JFrame {

    public static void main(String[] args) {
        ejercicio1 ej1 = new ejercicio1();
        ej1.setVisible(true);
    }

    public ejercicio1(){

        setTitle("ejercicio 1");
        setSize(400, 400);
        Container c = getContentPane();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextField texto1 = new JTextField("hola que tal estas");

        // en la linea de arriba creo un JtextField y le establezco un nombre por defecto que será (hola que tal estas).


        System.out.println(texto1.getText().toString());
        // el syso se encarga de imprimir por pantalla el texto

        texto1.getText();
        // el getText recoge el texto
        texto1.setText("me llamo juanito");
        // el setText lo modifica a me llamo juanito

        System.out.println(texto1.getText().toString());
        // y el ultimo syso imprimr el texto modificado


        System.out.println("primero establecemos un texto al crear el JTextField en el que he puesto: hola que tal estas. " +
                " A continuacion muestro por pantalla el texto con un syso, lo recojo con el getText y lo modifico con el setText. " +
                " Finalmente lo imprimo con otro syso");


        c.add(texto1);


    }
}
