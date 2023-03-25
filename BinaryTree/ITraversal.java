package BinaryTree;

/**
 * @author MAAG
 *
 */
public interface ITraversal<K, V> {

	void visit(TreeNode<K, V> actualNode);
	
}