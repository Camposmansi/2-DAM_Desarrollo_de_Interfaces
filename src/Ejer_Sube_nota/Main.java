/** Ejercicio realizado por:
  * Carlos Campos
  * Davinia Lozano
 *-
  * Tres ventanas (A, B y C), cada una con un campo de texto y al menos dos botones.
 *-
  * Uno de los botones le pasa la información a una de las otras ventanas.
  * Y el segundo botón se la pasa a la otra ventana.
  * Cada ventana muestra la información enviada por las otras ventanas.
 *-
  * Extra: Si la ventana que recibe la información ha sido cerrada por el usuario,
  * la ventana que envía la información deberá reflejar que la ventana receptora está cerrada.**/

package Ejer_Sube_nota;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        Image icon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("minion.png"))).getImage();

        /** Se Crea La Ventana A **/
        VentanaA vA = new VentanaA();
        vA.setIconImage(icon);
        vA.setResizable(false);
        vA.setSize(200, 100);
        //vA.pack(); //Agrupamos todo sin setSize
        vA.setLocation(250, 50);


        /** Se Crea La Ventana B **/
        VentanaB vB = new VentanaB();
        vB.setIconImage(icon);
        vB.setResizable(false);
        vB.setSize(200, 100);
        vB.setLocation(450, 50);

        /** Se Crea La Ventana C **/
        VentanaC vC = new VentanaC();
        vC.setIconImage(icon);
        vC.setResizable(false);
        vC.setSize(200, 100);
        vC.setLocation(650, 50);

        /** Se Muestran las Ventanas **/
        vA.setVisible(true);
        vB.setVisible(true);
        vC.setVisible(true);

        /** Se activan los Listeners **/
        vA.listenersOn();
        vB.listenersOn();
        vC.listenersOn();
    }
}
