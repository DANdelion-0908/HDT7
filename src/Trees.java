package src;
import java.util.ArrayList;
import java.util.TreeMap;

public class Trees {
    TreeMap<String, ArrayList<String>> englishTree = new TreeMap<>();
    TreeMap<String, ArrayList<String>> spanishTree = new TreeMap<>();
    TreeMap<String, ArrayList<String>> frenchTree = new TreeMap<>();

    /**
     * This function adds a key and value to a TreeMap.
     * 
     * @param treeMap The TreeMap that you want to add the key and value to.
     * @param keyString The key to be added to the TreeMap.
     * @param valuesArrayList The values to be added to the TreeMap.
     */
    public void add(TreeMap<String, ArrayList<String>> treeMap, String keyString, ArrayList<String> valuesArrayList) {
        treeMap.put(keyString, valuesArrayList);

    }

    /**
     * This function takes a TreeMap as a parameter and prints out the key and the value of the TreeMap.
     * 
     * @param treeMap The TreeMap that contains the words and their translations.
     */
    public void showMap(TreeMap<String, ArrayList<String>> treeMap) {
        for (String string : treeMap.keySet()) {
            System.out.println("La palabra " + string + " se traduce a español y francés como " + treeMap.get(string) + " respectivamente. \n");
        }
    }
}