import java.util.ArrayList;
import java.util.TreeMap;

import src.Reader;

public class App {
    
    public static void main(String[] args) throws Exception {
        Reader reader = new Reader();

        TreeMap<String, ArrayList<String>> englishTree = new TreeMap<>();
        TreeMap<String, ArrayList<String>> spanishTree = new TreeMap<>();
        TreeMap<String, ArrayList<String>> frenchTree = new TreeMap<>();

        reader.Read(englishTree, spanishTree, frenchTree);
    }
}