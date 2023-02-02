package PruebasGUI;

import java.util.Scanner;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String sentence = scanner.nextLine();
        String[] words = sentence.split("\\s+");
        int wordCount = words.length;
        System.out.println("Word count: " + wordCount);
    }
}

