package Recitation_10_5_21;

public class InsertFront {
	public static void main(String[] args) {
		CLL<Integer> cll = new CLL<Integer>();
		cll.insertFront(1);
		cll.insertFront(2);
		cll.insertFront(3);
		cll.insertFront(4);
		System.out.println(cll);
	}

	public static class CLL<T> {
		private class Node {
			public T value;
			public Node next;
			
			public Node(T value, Node next) {
				this.value = value;
				this.next = next;
			}
		}

		public Node last;

		public void insertFront(T newValue) {
			Node node = new Node(newValue, null);
			if (last != null)
				node.next = last.next;
			else 
				last = node;
			
			last.next = node;
		}

		@Override
		public String toString()
		{
			String str = "{";
			if (last == null)
				return str + "}";
			
			Node curr = last.next;
			do
			{
				str += curr.value + ",";
				curr = curr.next;
			} while (curr != last);
			str += last.value + "}";
			return str;
		}
	}
}