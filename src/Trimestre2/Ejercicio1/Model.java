package Trimestre2.Ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Model {

    private List<Integer> numeros;

    public Model() {
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

