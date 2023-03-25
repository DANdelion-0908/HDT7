package BinaryTree;

import java.util.Comparator;

public class Association implements Comparator<String> {

    /**
     * It compares two strings and returns the result.
     * 
     * @param word1 The first word to compare.
     * @param word2 The second word to compare.
     * @return The difference between the two words.
     */
    @Override
    public int compare(String word1, String word2) {
        return word1.compareTo(word2);
        
    }
    
    
}
