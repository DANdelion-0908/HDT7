package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import BinaryTree.Association;
import BinaryTree.BinarySearchTree;
import src.Reader;

public class TestsHDT7 {
    
    @Test
    // Testing the insert and search methods of the BinarySearchTree class.
    public void testInsert() {
        Association myAssociation = new Association();
        BinarySearchTree<String, String> myBinarySearchTree = new BinarySearchTree<>(myAssociation, null);

        myBinarySearchTree.insert("Hola", "Adiós");

        assertEquals("Adiós", myBinarySearchTree.search("Hola"));
    }
}
