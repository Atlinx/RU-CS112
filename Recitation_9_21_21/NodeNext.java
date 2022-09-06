package Recitation_9_21_21;

public class NodeNext {
	public static class Node {
		public int val;
		public Node next;

		public Node(int val, Node next) {
			this.val = val;
			this.next = next;
		}
	}

	public static void removeNext(Node node, int target) {
		while (node != null) {
			if (node.val == target && node.next != null)
				node.next = node.next.next;

			node = node.next;
		}
	}

	public static void printLinkedList(Node node) {
		while (node != null) {
			System.out.print(node.val);
			node = node.next;
		}
		System.out.println();
	}

	public static int max(Node node) {
		int maxValue = Integer.MIN_VALUE;
		for (Node ptr = node; ptr != null; ptr = ptr.next) {
			if (ptr.val > maxValue)
				maxValue = ptr.val;
		}
		return maxValue;
	}

	public static int maxRecursive(Node node) {
		return maxRecursive(node, Integer.MIN_VALUE);
	}

	public static int maxRecursive(Node node, int minValue) {
		if (node == null)
			return minValue;
		if (node.val > minValue)
			minValue = node.val;
		return maxRecursive(node.next, minValue);
	}
	
	public static void main(String[] args) {
		Node five = new Node(5, null);
		Node four = new Node(4, five);
		Node three = new Node(3, four);
		Node two = new Node(2, three);
		Node one = new Node(1, two);

		printLinkedList(one);
		removeNext(one, 3);
		printLinkedList(one);

		System.out.println("Max: " + max(one));
		System.out.println("Max recursive: " + maxRecursive(one));
	}
}