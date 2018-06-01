/* This is a class include binary search tree and inner class for binary search node.
 * @author Tao Guo
 */
public class BSTree {

	// Inner class for binary search tree.
	private class BSTNode {

		public Comparable data;
		public BSTNode right;
		public BSTNode left;

		// Constructor
		BSTNode(Comparable newData) {

			data = newData;
		}
	}

	private BSTNode root;

	// Insert node to the tree
	public void insert(Comparable data) {
		root = insert(data, root);
	}

	// Helper methods for insert.
	public BSTNode insert(Comparable data, BSTNode node) {
		if (node == null) {
			return new BSTNode(data);
		}

		if (data.compareTo(node.data) < 0) {
			node.left = insert(data, node.left);
			return node;
		} else {
			node.right = insert(data, node.right);
			return node;
		}

	}

	// Find node in the tree.
	public boolean find(Comparable data) {

		return find(data, root);
	}

	// Helper method for find.
	private boolean find(Comparable data, BSTNode node) {

		if (node == null) {
			return false;
		}
		if (node.data.compareTo(data) == 0) {
			return true;
		}
		if (node.data.compareTo(data) < 0) {
			return find(data, node.right);
		} else {
			return find(data, node.left);
		}
	}

	// Delete a node in the tree.
	public void delete(Comparable data) {
		root = delete(data, root);

	}

	// Helper method for delete.
	private BSTNode delete(Comparable data, BSTNode node) {

		if (node == null) {
			return null;
		}

		if (node.data.compareTo(data) == 0) {
			if (node.left == null) {
				return node.right;
			} else if (node.right == null) {
				return node.left;
			} else {
				if (node.right.left == null) {
					node.data = node.right.data;
					node.right = node.right.right;
					return node;
				} else {
					node.data = removeSmallest(node.right);
					return node;
				}
			}
		} else if (node.data.compareTo(node.data) < 0) {
			node.left = delete(data, node.left);
			return node;
		} else {
			node.right = delete(data, node.right);
			return node;
		}

	}

	// Helper method for helper method. Remove the smallest in the tree.
	private Comparable removeSmallest(BSTNode node) {

		if (node.left.left == null) {
			Comparable smallest = node.left.data;
			node.left = node.left.right;
			return smallest;
		}
		return removeSmallest(node.left);
	}

	// Print the node as left + root + right.
	public String toStringInOrder() {

		String s1 = (String) root.data;
		String s2 = toStringInOrder(root.left);
		String s3 = toStringInOrder(root.right);
		String s4 = s2 + " " + s1 + s3;
		s4 = s4.trim();
		return s4;
	}

	// Helper method for the toString method.
	private String toStringInOrder(BSTNode node) {

		if (node != null) {
			return toStringInOrder(node.left) + " " + (String) node.data + toStringInOrder(node.right);
		} else {
			return "";
		}
	}

	// Print the node as root + left + right.
	public String toStringPreOrder() {

		String s1 = (String) root.data;
		String s2 = toStringPreOrder(root.left);
		String s3 = toStringPreOrder(root.right);
		return s1 + s2 + s3;
	}

	// Helper method for the toString method.
	private String toStringPreOrder(BSTNode node) {

		if (node != null) {
			return " " + (String) node.data + toStringPreOrder(node.left) + toStringPreOrder(node.right);
		} else {
			return "";
		}
	}

}
