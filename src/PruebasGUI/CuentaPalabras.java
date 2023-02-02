package PruebasGUI;

public class CuentaPalabras {
    public static void main(String[] args) {
        HiloEj2 hilo1 = new HiloEj2("mundo");
        HiloEj2 hilo2 = new HiloEj2("hola");
        HiloEj2 hilo3 = new HiloEj2("haces");
        hilo1.start();
        hilo2.start();
        hilo3.start();
        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
        } catch (InterruptedException e) {
            System.out.println("Error joining threads: " + e.getMessage());
        }
        System.out.println("Count for word 'palabra1': " + hilo1.getCount());
        System.out.println("Count for word 'palabra2': " + hilo2.getCount());
        System.out.println("Count for word 'palabra3': " + hilo3.getCount());
    }
}

