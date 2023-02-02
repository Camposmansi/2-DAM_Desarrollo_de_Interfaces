package Curso.Calculadora;

import java.util.Scanner;

public class Calculadora {
    public Calculadora() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\n");
            System.out.println("***** CALCULADORA OPENWEBINARS *****");
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("5. Resto");
            System.out.println("0. Salir del programa");
            System.out.print("Introduzca una opción válida: ");
            opcion = Integer.parseInt(sc.nextLine());
            if (opcion >= 0 && opcion <= 5) {
                if (opcion != 0) {
                    System.out.println("\n");
                    System.out.print("Introduzca el primer operando: ");
                    float operando1 = Float.parseFloat(sc.nextLine());
                    System.out.print("Introduzca el segundo operando: ");
                    float operando2 = Float.parseFloat(sc.nextLine());
                    System.out.println("\n");
                    switch (opcion) {
                        case 1:
                            System.out.println("El resultado de la suma es " + (operando1 + operando2));
                            break;
                        case 2:
                            System.out.println("El resultado de la resta es " + (operando1 - operando2));
                            break;
                        case 3:
                            System.out.println("El resultado de la multiplicación es " + operando1 * operando2);
                            break;
                        case 4:
                            System.out.println("El resultado de la división es " + operando1 / operando2);
                            break;
                        case 5:
                            System.out.println("El resto de dividir " + operando1 + " entre " + operando2 + " es " + operando1 % operando2);
                    }
                }
            } else {
                System.out.println("Opción no válida. Vuelva a escoger");
            }
        } while(opcion != 0);

        sc.close();
        System.out.println("Finalizando la ejecución de la calculadora");
    }
}
