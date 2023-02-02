package PruebasGUI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class HiloEj2 extends Thread {
    private String word;
    private int count;

    public HiloEj2(String word) {
        this.word = word;
        this.count = 0;
    }

    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("texto.txt"));
            String line = reader.readLine();
            while (line != null) {
                String[] words = line.split("\\s+");
                for (String w : words) {
                    if (w.equals(word)) {
                        count++;
                    }
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public int getCount() {
        return count;
    }
}


