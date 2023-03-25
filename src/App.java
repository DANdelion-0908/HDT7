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
        
        String max = "";
        
        try {
            dictionary = reader.Read("diccionario");

        } catch (Exception e) {
            e.printStackTrace();
        }

        for (String string : dictionary) {
            String[] sentenceWords = string.toLowerCase().split(",");

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
                String[] wordStrings = string.toLowerCase().split(" ");

                int spanish = 0;
                int english = 0;
                int french = 0;
    
                for (String word : wordStrings) {

                    if (englishToPrint.contains(word.toLowerCase())) {
                        english ++;

                    } else if (spanishToPrint.contains(word.toLowerCase())) {
                        spanish ++;

                    } else if (frenchToPrint.contains(word.toLowerCase())) {
                        french ++;
                    }
                }

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

        switch(max) {
            case "Inglés":

                System.out.println("¿A qué idioma deseas traducir la oración?");
                System.out.println("1. Español.");
                System.out.println("2. Francés." + "\n");
    
                System.out.print("Tu elección: ");
                int langSelection = inputScanner.nextInt();
                
                switch(langSelection) {
                    case 1:

                    for (String string : dictionary) {
                        String[] words = string.toLowerCase().split(",");

                        spanishBinarySearchTree.insert(words[0], words[1]);
                    }

                    for (String string : translation) {
                        String translateString = "";

                        String[] words = string.toLowerCase().split(" ");

                        for (String string2 : words) {
                            String replacementString = spanishBinarySearchTree.search(string2);

                            if(replacementString == null) {
                                translateString = translateString + "*" + string2 + "* ";

                            } else {
                                translateString = translateString + replacementString + " ";

                            }
                        }

                        System.out.println(translateString);
                    }

                    break;
        
                    case 2:

                    for (String string : dictionary) {
                        String[] words = string.toLowerCase().split(",");

                        frenchBinarySearchTree.insert(words[0], words[2]);
                    }

                    for (String string : translation) {
                        String translateString = "";

                        String[] words = string.toLowerCase().split(" ");

                        for (String string2 : words) {
                            String replacementString = frenchBinarySearchTree.search(string2);

                            if(replacementString == null) {
                                translateString = translateString + "*" + string2 + "* ";

                            } else {
                                translateString = translateString + replacementString + " ";

                            }
                        }

                        System.out.println(translateString);
                    }
        
                }

            break;

            case "Español":

                System.out.println("¿A qué idioma deseas traducir la oración?");
                System.out.println("1. Inglés.");
                System.out.println("2. Francés." + "\n");

                System.out.print("Tu elección: ");
                int langSelection2 = inputScanner.nextInt();
            
                switch(langSelection2) {
                    case 1:

                    for (String string : dictionary) {
                        String[] words = string.toLowerCase().split(",");

                        englishBinarySearchTree.insert(words[1], words[0]);
                    }

                    for (String string : translation) {
                        String translateString = "";

                        String[] words = string.toLowerCase().split(" ");

                        for (String string2 : words) {
                            String replacementString = englishBinarySearchTree.search(string2);

                            if(replacementString == null) {
                                translateString = translateString + "*" + string2 + "* ";

                            } else {
                                translateString = translateString + replacementString + " ";

                            }
                        }

                        System.out.println(translateString);
                    }

                    break;
    
                    case 2:

                    for (String string : dictionary) {
                        String[] words = string.toLowerCase().split(",");

                        frenchBinarySearchTree.insert(words[1], words[2]);
                    }

                    for (String string : translation) {
                        String translateString = "";

                        String[] words = string.toLowerCase().split(" ");

                        for (String string2 : words) {
                            String replacementString = frenchBinarySearchTree.search(string2);

                            if(replacementString == null) {
                                translateString = translateString + "*" + string2 + "* ";

                            } else {
                                translateString = translateString + replacementString + " ";

                            }
                        }

                        System.out.println(translateString);
                    }
    
                }

                break;

            case "Francés":
                System.out.println("¿A qué idioma deseas traducir la oración?");
                System.out.println("1. Español.");
                System.out.println("2. Inglés." + "\n");

                System.out.print("Tu elección: ");
                int langSelection3 = inputScanner.nextInt();
        
                switch(langSelection3) {
                    case 1:

                    for (String string : dictionary) {
                        String[] words = string.toLowerCase().split(",");

                        frenchBinarySearchTree.insert(words[2], words[1]);
                    }

                    for (String string : translation) {
                        String translateString = "";

                        String[] words = string.toLowerCase().split(" ");

                        for (String string2 : words) {
                            String replacementString = frenchBinarySearchTree.search(string2);

                            if(replacementString == null) {
                                translateString = translateString + "*" + string2 + "* ";

                            } else {
                                translateString = translateString + replacementString + " ";

                            }
                        }

                        System.out.println(translateString);
                    }

                    break;

                    case 2:

                    for (String string : dictionary) {
                        String[] words = string.toLowerCase().split(",");

                        frenchBinarySearchTree.insert(words[2], words[0]);
                    }

                    for (String string : translation) {
                        String translateString = "";

                        String[] words = string.toLowerCase().split(" ");

                        for (String string2 : words) {
                            String replacementString = frenchBinarySearchTree.search(string2);

                            if(replacementString == null) {
                                translateString = translateString + "*" + string2 + "* ";

                            } else {
                                translateString = translateString + replacementString + " ";

                            }
                        }

                        System.out.println("");
                        System.out.println(translateString);
                    }

                }

                break;
        }

        inputScanner.close();
    }
}