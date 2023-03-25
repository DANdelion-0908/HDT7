package BinaryTree;

import java.util.Comparator;

public class Association implements Comparator<String> {

    @Override
    public int compare(String word1, String word2) {
        return word1.compareTo(word2);
        
    }
    
    
}
