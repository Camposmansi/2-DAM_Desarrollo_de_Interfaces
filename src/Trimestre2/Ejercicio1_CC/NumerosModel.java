package Trimestre2.Ejercicio1_CC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumerosModel {

    private List<Integer> numeros;

    public NumerosModel() {
        numeros = new ArrayList<>();
    }

    public void agregarNumero(int numero) {
        numeros.add(numero);
    }

    public void borrarNumeros() {
        numeros.clear();
    }

    public List<Integer> getNumeros() {
        return new ArrayList<>(numeros);
    }

    public void cambiarOrden() {
        List<Integer> numerosOrdenados = new ArrayList<>(numeros);
        Collections.reverse(numerosOrdenados);
        numeros = numerosOrdenados;
    }

    public void borrarUltimo() {
        if (!numeros.isEmpty()) {
            numeros.remove(numeros.size() - 1);
        }
    }

    public void borrarPrimero() {
        if (!numeros.isEmpty()) {
            numeros.remove(0);
        }
    }

    public void quitarNumero(int numero) {
        numeros.removeIf(n -> n == numero);
    }

}

