package Recitation_10_5_21;

public class Cycles {
	public static void main(String[] args) {
		LinkedList<Integer> cll = new LinkedList<Integer>();
		cll.insertFront(1);
		cll.insertFront(2);
		cll.insertFront(3);
		cll.insertFront(4);
		System.out.println(cll);
		System.out.println(cll.hasCycle());
	}

	public static class LinkedList<T> {
		private class Node {
			public T value;
			public Node next;
			
			public Node(T value, Node next) {
				this.value = value;
				this.next = next;
			}
		}

		public Node head;

		public boolean hasCycle() {
			Node slow = head;
			Node fast = head;

			while (fast != null && fast.next != null && fast.next != null) {
				slow = slow.next;
				fast = fast.next.next;
				
				if (slow == fast)
					return true;
			}
			return false;
		}

		public void insertFront(T newValue) {
			Node node = new Node(newValue, null);
			if (head == null)
				head = node;
			else {
				node.next = head;
				head = node;
			}
		}

		@Override
		public String toString()
		{
			String str = "{";
			if (head == null)
				return str + "}";
			
			Node curr = head;
			while (curr != null)
			{
				str += curr.value + (curr.next != null ? "," : "}");
				curr = curr.next;
			}
			return str;
		}
	}
}