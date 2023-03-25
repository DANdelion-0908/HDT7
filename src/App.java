package src;

import java.util.ArrayList;
import java.util.Scanner;
import BinaryTree.Association;
import BinaryTree.BinarySearchTree;

public class App {
    
    public static void main(String[] args) throws Exception {

        Association langAssociation = new Association();
        Reader reader = new Reader();
        Scanner inputScanner = new Scanner(System.in);
        
        BinarySearchTree<String, String> englishBinarySearchTree = new BinarySearchTree<>(langAssociation, null);
        BinarySearchTree<String, String> frenchBinarySearchTree = new BinarySearchTree<>(langAssociation, null);
        BinarySearchTree<String, String> spanishBinarySearchTree = new BinarySearchTree<>(langAssociation, null);
        
        ArrayList<String> dictionary = new ArrayList<>();
        ArrayList<String> translation = new ArrayList<>();
        ArrayList<String> englishToPrint = new ArrayList<>();
        ArrayList<String> frenchToPrint = new ArrayList<>();
        ArrayList<String> spanishToPrint = new ArrayList<>();
        
        try {
            dictionary = reader.Read("diccionario");

        } catch (Exception e) {
            e.printStackTrace();
        }

        for (String string : dictionary) {
            String[] sentenceWords = string.split(",");

            englishToPrint.add(sentenceWords[0]);
            spanishToPrint.add(sentenceWords[1]);
            frenchToPrint.add(sentenceWords[2]);
        }

        System.out.println("Diccionario");
        System.out.println("Nota: solo colocar el nombre de los archivos. 'src' y '.tx' se agregan automáticamente.");
        System.out.print("Ingresa el nombre del archivo a traducir: ");
        String translationFile = inputScanner.nextLine();
        System.out.println("");

        System.out.println("La oración a traducir es: " + reader.Read(translationFile) + "\n");

        try {
            translation = reader.Read(translationFile);

            for (String string : translation) {
                String[] wordStrings = string.split(" ");

                int spanish = 0;
                int english = 0;
                int french = 0;
    
                for (String word : wordStrings) {

                    if (englishToPrint.contains(word)) {
                        english ++;

                    } if (spanishToPrint.contains(word)) {
                        spanish ++;

                    } if (frenchToPrint.contains(word)) {
                        french ++;
                    }
                }

                String max = "";

                if (english >= spanish && english >= french) {
                    max = "Inglés";
                } else if (spanish >= english && spanish >= french) {
                    max = "Español";
                } else if (french >= english && french >= spanish) {
                    max = "Francés";
                }
                
                System.out.println("Idioma detectado: " + max + "\n");
            }


        } catch (Exception e) {
            System.out.println("Ingresa un nombre de archivo '.txt' válido.");
            inputScanner.close();
            return;
        }

        for (String string : translation) {
            String traduced = "";
            String[] word = string.split(" ");

            for (String string2 : word) {
                String traduction = englishBinarySearchTree.search(string);

                if (traduction == null) {
                    traduced  = traduced + "*" + string2 + "* ";

                } else {
                    traduced = traduced + traduction + " ";
                }
            }

            System.out.println(traduced);
        }

        inputScanner.close();
    }
}