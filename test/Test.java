package test;
import java.util.*;

public class Test {
	public static class Node {
		public int item;
		public Node next;

		public Node(int item, Node next) {
			this.item = item;
			this.next = next;
		}
	}

	public static void main(String[] args) {
		Node lastInstance = new Node(15, new Node(30, new Node(17, new Node(17, null))));
		Node front = new Node(5, new Node(15, new Node(15, lastInstance)));
		
		Node lastDup = findLastDup(front);
		System.out.println("Testing last dup");
		System.out.print("Linked List: ");
		printLinkedList(front);
		System.out.println(lastDup.item);
		System.out.println(lastDup == lastInstance);
		System.out.println();

		// System.out.println("Testing removeDup");
		// System.out.print("Before: ");
		// printLinkedList(front);
		// removeDup(front);
		// System.out.print("After: ");
		// printLinkedList(front);
		// System.out.println();

		System.out.println("Testing correctRemoveDup");
		System.out.print("Before: ");
		printLinkedList(front);
		correctRemoveDup(front);
		System.out.print("After: ");
		printLinkedList(front);
		System.out.println();
	}

	public static Node findLastDup(Node front) {
		Node prevNode = front;
		Node duplicate = null;
		while (prevNode.next != null) {
			if (prevNode.item == prevNode.next.item)
				duplicate = prevNode.next;
			prevNode = prevNode.next;
		}
		return duplicate;
	}

	// POST MORTEM:
	// This only removes one duplicate. 
	// 
	// Next time, we need to write more test cases. First thing
	// you should write are functions for generating test
	// cases. Try to make as many test cases as you
	// can think of.
	public static void removeDup(Node front) {
		Node prevNode = front;
		while (prevNode.next != null) {
			if (prevNode.item == prevNode.next.item)
				prevNode.next = prevNode.next.next;
			prevNode = prevNode.next;
		}
	}

	public static void correctRemoveDup(Node front) {
		Node prevNode = front;
		while (prevNode != null) {
			Node duplicateNode = prevNode.next;
			while (duplicateNode != null && prevNode.item == duplicateNode.item)
				duplicateNode = duplicateNode.next;
			prevNode.next = duplicateNode;
			prevNode = prevNode.next;
		}
	}

	public static void printLinkedList(Node front) {
		while (front != null) {
			System.out.print(front.item + " -> ");
			front = front.next;
		}
		System.out.println();
	}
}
