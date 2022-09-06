package Midterm2;

public class MusicLibrary {
	public static void main(String[] args) {
		System.out.println("New library");
		MusicLibrary lib = new MusicLibrary();
		lib.addSong(new MusicLibrary.Song("Bob", "1", "asdf"));
		lib.print();
		lib.addSong(new MusicLibrary.Song("Joe", "1", "asdf"));
		lib.print();
		lib.addSong(new MusicLibrary.Song("Harold", "1", "asdf"));
		lib.print();
		lib.addSong(new MusicLibrary.Song("Bob", "2", "asdf"));
		lib.print();
		lib.addSong(new MusicLibrary.Song("Harold", "2", "asdf"));
		lib.print();
		lib.addSong(new MusicLibrary.Song("Joe", "2", "asdf"));
		lib.print();
		lib.addSong(new MusicLibrary.Song("Harold", "3", "asdf"));
		lib.print();
		lib.addSong(new MusicLibrary.Song("Harold", "4", "asdf"));
		lib.print();
		lib.addSong(new MusicLibrary.Song("Joe", "3", "asdf"));
		lib.print();
		System.out.println("Print backwards");
		lib.printBackwards();

		System.out.println("\nNew library");		
		lib = new MusicLibrary();
		lib.addSong(new MusicLibrary.Song("Bob", "1", "asdf"));
		lib.print();
		lib.addSong(new MusicLibrary.Song("Bob", "2", "asdf"));
		lib.print();
		
		System.out.println("\nNew library");		
		lib = new MusicLibrary();
		lib.addSong(new MusicLibrary.Song("Joe", "1", "asdf"));
		lib.print();
		lib.addSong(new MusicLibrary.Song("Bob", "1", "asdf"));
		lib.print();
		lib.addSong(new MusicLibrary.Song("Joe", "2", "asdf"));
		lib.print();
		lib.addSong(new MusicLibrary.Song("Joe", "3", "asdf"));
		lib.print();
		lib.addSong(new MusicLibrary.Song("Bob", "2", "asdf"));
		lib.print();

		System.out.println("\nNew library");		
		lib = new MusicLibrary();
		lib.addSong(new MusicLibrary.Song("Bob", "1", "asdf"));
		lib.print();
		lib.addSong(new MusicLibrary.Song("Bob", "2", "asdf"));
		lib.print();
		lib.addSong(new MusicLibrary.Song("Joe", "1", "asdf"));
		lib.print();
		lib.addSong(new MusicLibrary.Song("Joe", "2", "asdf"));
		lib.print();
		lib.addSong(new MusicLibrary.Song("Joe", "3", "asdf"));
		lib.print();
		lib.addSong(new MusicLibrary.Song("Joe", "4", "asdf"));
		lib.print();
		lib.addSong(new MusicLibrary.Song("Joe", "5", "asdf"));
		lib.print();
		lib.addSong(new MusicLibrary.Song("Joe", "6", "asdf"));
		lib.print();
		lib.addSong(new MusicLibrary.Song("Bob", "3", "asdf"));
		lib.print();

		System.out.println("\nNew library");		
		lib = new MusicLibrary();
		lib.addSong(new MusicLibrary.Song("Bob", "1", "asdf"));
		lib.print();
		lib.addSong(new MusicLibrary.Song("Joe", "1", "asdf"));
		lib.print();
		lib.addSong(new MusicLibrary.Song("Bob", "2", "asdf"));
		lib.print();
		lib.addSong(new MusicLibrary.Song("Joe", "2", "asdf"));
		lib.print();
	}

	private Node first;
	int size;

	public static class Song {
		String singer;
		String name;
		String file;

		public Song(String singer, String name, String file) {
			this.singer = singer;
			this.name = name;
			this.file = file;
		}

		@Override
		public String toString() {
			return "[" + singer + ", " + name + ", " + file + "]";
		}
	}

	public class Node {
		Song item;
		Node prev;
		Node next;

		public Node(Song item, Node prev, Node next) {
			this.item = item;
			this.prev = prev;
			this.next = next;
		}
	}

	public void addSong(Song s) {
		if (first == null) {
			first = new Node(s, null, null);
			return;
		}
		
		Node singerNode = first;

		// Account for edge case where only 1 song exists for singer and is located at the start.
		if (singerNode.next != null && singerNode.item.singer == s.singer && singerNode.next.item.singer != s.singer)
		{
			Node newNode = new Node(s, singerNode, singerNode.next);
			singerNode.next = newNode;
			if (newNode.next != null)
				newNode.next.prev = newNode;
			return;
		}

		// Find start of signer group
		while (singerNode.next != null && singerNode.next.item.singer != s.singer) {
			singerNode = singerNode.next;
		}

		// Account for edge case where singer group doesn't exist
		if (singerNode.next == null)
		{         
			Node newNode = new Node(s, singerNode, null);
			singerNode.next = newNode;
			return;
		}

		singerNode = singerNode.next;

		// Find last song in singer group
		while (singerNode.next != null && singerNode.next.item.singer == s.singer)
			singerNode = singerNode.next;
	
		Node newNode = new Node(s, singerNode, singerNode.next);
		singerNode.next = newNode;
		if (newNode.next != null)
			newNode.next.prev = newNode;
	}

	public void print() {
		Node node = first;
		while (node != null) {
			System.out.print(node.item + ", ");
			node = node.next;
		}
		System.out.println();
	}

	public void printBackwards() {
		Node node = first;
		while (node != null && node.next != null) {
			node = node.next;
		}

		while (node != null) {
			System.out.print(node.item + ", ");
			node = node.prev;
		}
	}
}