package Recitation_10_19_21;

import java.util.*;

public class BST<TKey extends Comparable<TKey>, TValue> {
	public static void main(String[] args) {
		BST<Integer, String> bst = new BST<Integer, String>();
		bst.insert(4, "Test");
		bst.insert(1, "Test2");
		bst.insert(6, "Test3");
		bst.insert(5, "Test4");
		System.out.println(bst);
	}

	private class Node {
		public TKey key;
		public TValue value;

		public Node right;
		public Node left;
		public int size = 1;
		
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

	@Override
	public String toString() {
		return root.toString();
	}

	public void insert(TKey key, TValue value) {
		Node newNode = new Node(key, value);
		if (root == null) {
			root = newNode;
			return;
		}

		insertRecursive(root, newNode);
	}

	private boolean insertRecursive(Node node, Node newNode) {
		if (node == null)
			return false;
		int comparison = newNode.key.compareTo(node.key);
		if (comparison > 0 && !insertRecursive(node.right, newNode)) {
			node.right = newNode;
			return true;
		} else if (comparison < 0 && !insertRecursive(node.left, newNode)) {
			node.left = newNode;
			return true;
		} else {
			node.value = newNode.value;
			return true;
		}
	}

	public Node kthLargest(Node node, int kth) {
		if (node == null)
			return null;
		if (node.right != null) {
			if (node.right.size < kth - 1) {
				return kthLargest(node.left, kth - node.right.size - 1);
			} else if (node.right.size >= kth) {
				return kthLargest(node.right, kth);
			} else {
				return node;
			}
		} else
			return kthLargest(node.left, kth);
	}
}