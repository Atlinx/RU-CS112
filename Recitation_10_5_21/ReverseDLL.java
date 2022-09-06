package Recitation_10_5_21;

public class ReverseDLL {
	public static void main(String[] args) {
		DLL<Integer> dll = new DLL<Integer>();
		dll.insertFront(1);
		dll.insertFront(2);
		dll.insertFront(3);
		dll.insertFront(4);
		System.out.println(dll);
		dll.reverse();
		System.out.println(dll);
	}

	public static class DLL<T> {
		private class Node {
			public T value;
			public Node next;
			public Node previous;
			
			public Node(T value, Node previous, Node next) {
				this.value = value;
				this.previous = previous;
				this.next = next;
			}
		}

		public Node head;

		public void reverse() {
			Node curr = head;
			while (curr != null) {
				Node next = curr.next;
				curr.next = curr.previous;
				curr.previous = next;

				if (curr.previous == null)
					head = curr;
				curr = curr.previous;
			}
		}

		public void insertFront(T newValue) {
			Node node = new Node(newValue, null, null);
			if (head == null)
				head = node;
			else {
				node.next = head;
				head.previous = node;
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