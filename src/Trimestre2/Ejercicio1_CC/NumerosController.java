package Trimestre2.Ejercicio1_CC;

import java.util.Collections;
import java.util.List;

public class NumerosController {

    private NumerosModel modelo;

    public NumerosController(NumerosModel modelo) {
        this.modelo = modelo;
    }

    public void cargarNumero(int numero, boolean borrarAnteriores) {
        modelo.agregarNumero(numero);
    }

    public void borrarNumeros() {
        modelo.borrarNumeros();
    }

    public List<Integer> getNumeros() {
        return modelo.getNumeros();
    }

    public void imprimirNumeros() {
        List<Integer> numeros = modelo.getNumeros();
        System.out.println("Números cargados:");
        for (Integer numero : numeros) {
            System.out.println(numero);
        }
    }

    public void imprimirNumero(int indice) {
        List<Integer> numeros = modelo.getNumeros();
        if (indice >= 0 && indice < numeros.size()) {
            System.out.println("Número en la posición " + indice + ": " + numeros.get(indice));
        }
    }

    public void cambiarOrden() {
        modelo.cambiarOrden();
    }

    public void borrarUltimo() {
        modelo.borrarUltimo();
    }

    public void borrarPrimero() {
        modelo.borrarPrimero();
    }

    public void quitarMenor() {
        List<Integer> numeros = modelo.getNumeros();
        if (!numeros.isEmpty()) {
            Integer menor = Collections.min(numeros);
            modelo.quitarNumero(menor);
        }
    }

    public void quitarMayor() {
        List<Integer> numeros = modelo.getNumeros();
        if (!numeros.isEmpty()) {
            Integer mayor = Collections.max(numeros);
            modelo.quitarNumero(mayor);
        }
    }

}