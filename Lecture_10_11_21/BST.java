package Lecture_10_11_21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Iterator;

public class BST<TKey extends Comparable<TKey>, TValue> {
	private class Node {
		public TKey key;
		public TValue value;

		public Node right;
		public Node left;
		
		public Node(TKey key, TValue value) {
			this.key = key;
			this.value = value;
		}

		public List<Node> getChildren() {
			List<Node> list = new ArrayList<>();
			if (right != null)
				list.add(right);
			if (left != null)
				list.add(left);
			return list;
		}

		public String toString() {
			StringBuilder buffer = new StringBuilder(50);
			print(buffer, "", "");
			return buffer.toString();
		}

		private void print(StringBuilder buffer, String prefix, String childrenPrefix) {
			buffer.append(prefix);
			buffer.append(key.toString() + " : " + (value == null ? "" : value.toString()));
			buffer.append('\n');
			for (Iterator<Node> it = getChildren().iterator(); it.hasNext();) {
				Node next = it.next();
				if (it.hasNext()) {
					next.print(buffer, childrenPrefix + "├── ", childrenPrefix + "│   ");
				} else {
					next.print(buffer, childrenPrefix + "└── ", childrenPrefix + "    ");
				}
			}
		}
	}

	private Node root;

	public boolean put(TKey key, TValue val) {
		if (root == null)
			root = new Node(key, val);
		else {
			Node currNode = root;
			while (true) {
				if (key.compareTo(currNode.key) > 0) {
					if (currNode.right == null) {
						currNode.right = new Node(key, val);
						break;
					}
					currNode = currNode.right;
				} else if (key.compareTo(currNode.key) < 0) {
					if (currNode.left == null) {
						currNode.left = new Node(key, val);
						break;
					}
					currNode = currNode.left;
				} else
				{
					// Key already exists!
					currNode.value = val;
					break;
				}
			}
		}
		return true;
	}

	public TValue get(TKey key) {
		Node currNode = root;
		while (currNode != null) {
			if (key.compareTo(currNode.key) > 0)
				currNode = currNode.right;
			else if (key.compareTo(currNode.key) < 0)
				currNode = currNode.left;
			else
				return currNode.value;
		}
		return null;
	}

	public TKey minKey()
	{
		if (root == null)
			return null;
		
		Node currNode = root;
		while (currNode.left != null) {
			currNode = currNode.left;
		}
		return currNode.key;
	}

	public TKey maxKey()
	{
		if (root == null)
			return null;
		
		Node currNode = root;
		while (currNode.right != null) {
			currNode = currNode.right;
		}
		return currNode.key;
	}

	// Finds the largest key that <= key
	// We are flooring the "key" into a key that already exists int he BS.
	public TKey floor(TKey key) {
		return floorHelper(root, key);
	}

	private TKey floorHelper(Node node, TKey key) {
		// We want to traverse firs to the left,
		// then to the right as far as possible 
		// without hitting a node whose
		// key is greater than "key".
		if (node == null)
			return null;
		if (node.key == key)
			return key;
		
		// key < Node.key
		if (key.compareTo(node.key) < 0)
			return floorHelper(node.left, key);
		
		// key > Node.key
		// Max may lie in the right subtree
		TKey floorValue = floorHelper(node.right, key);
		
		// Return the higher of the two floor values, which
		// should be the closest floor there is.
		if (floorValue == null || node.key.compareTo(floorValue) > 0)
			// Return the key if our attempt at flooring our children node was null
			return node.key;
		return floorValue;
	}

	// We want to ceil "key" to a key existing in the BST.
	public TKey ceil(TKey key) {
		return ceilHelper(root, key);
	}

	private TKey ceilHelper(Node node, TKey key) {
		// We want to traverse first to the right,
		// then to the left as far as possible
		// without hitting a node whose
		// key is less than "key".
		if (node == null)
			return null;
		if (node.key == key)
			return key;
		
		// key > Node.key
		if (key.compareTo(node.key) > 0)
			return ceilHelper(node.right, key);
		
		// key > Node.key
		// Max may lie in the right subtree
		TKey ceilValue = ceilHelper(node.left, key);
		
		// Return the smaller of the two ceil values, which
		// should be the closest ceiling there is.
		if (ceilValue == null || node.key.compareTo(ceilValue) < 0)
			// Return the key if our attempt at ceiling our children node was null
			return node.key;
		return ceilValue;
	}

	public String toString() {
		return root == null ? "" : root.toString();
	}
}