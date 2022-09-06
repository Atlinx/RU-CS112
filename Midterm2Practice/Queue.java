package Midterm2Practice;

public class Queue<Item> {
	public static void main(String[] args) {
		Queue<String> queue = new Queue<>();
		for (int i = 0; i < 10; i++)
			queue.enqueue("Number " + i);
		System.out.println("Queue: " + queue.toString());
		while (!queue.isEmpty())
			System.out.println("Dequeue: " + queue.dequeue());
	}

	private class Node {
		public Item item;
		public Node next;

		public Node(Item item, Node next) {
			this.item = item;
			this.next = next;
		}
	}

	private Node last;
	private int size;

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	@Override
	public String toString() {
		Node node = last;
		if (node == null)
			return "";
		String str = "";
		do {
			node = node.next;
			str += node.item.toString() + ", ";
		} while (node != last);
		return str;
	}

	public void enqueue(Item item) {
		size++;
		if (last == null) {
			last = new Node(item, null);
			last.next = last;
			return;
		}

		Node newLast = new Node(item, last.next);
		last.next = newLast;
		last = newLast;
	}

	public Item dequeue() {
		if (last == null)
			return null;
		
		size--;
		if (last.next == last) {
			Item item =  last.item;
			last = null;
			return item;
		}
		Item item = last.next.item;
		last.next = last.next.next;
		return item;
	}
}