package Midterm2;

import java.util.*;

public class BST {
	
    public static class MusicLibrary {
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

            if (singerNode.next == null)
            {         
                Node newNode = new Node(s, singerNode, null);
                singerNode.next = newNode;
                return;
            }

            singerNode = singerNode.next;

            // Find last song in singer group
            if (singerNode.next != null && singerNode.next.item.singer == s.singer)
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
    }
    
	public static void main(String[] args) {
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
        lib.addSong(new MusicLibrary.Song("Joe", "3", "asdf"));
        lib.print();
	}






	private static class BSTNode {
		public int key;
		public BSTNode left;
		public BSTNode right;

		public BSTNode(int key) {
			this.key = key;
		}

		public BSTNode getLeft() {
			return left;
		}

		public BSTNode getRight() {
			return right;
		}

		public String getText() {
			return "" + key;
		}
	}
	
	public static void print(BSTNode root)
    {	
        List<List<String>> lines = new ArrayList<List<String>>();

        List<BSTNode> level = new ArrayList<BSTNode>();
        List<BSTNode> next = new ArrayList<BSTNode>();

        level.add(root);
        int nn = 1;

        int widest = 0;

        while (nn != 0) {
            List<String> line = new ArrayList<String>();

            nn = 0;

            for (BSTNode n : level) {
                if (n == null) {
                    line.add(null);

                    next.add(null);
                    next.add(null);
                } else {
                    String aa = n.getText();
                    line.add(aa);
                    if (aa.length() > widest) widest = aa.length();

                    next.add(n.getLeft());
                    next.add(n.getRight());

                    if (n.getLeft() != null) nn++;
                    if (n.getRight() != null) nn++;
                }
            }

            if (widest % 2 == 1) widest++;

            lines.add(line);

            List<BSTNode> tmp = level;
            level = next;
            next = tmp;
            next.clear();
        }

        int perpiece = lines.get(lines.size() - 1).size() * (widest + 4);
        for (int i = 0; i < lines.size(); i++) {
            List<String> line = lines.get(i);
            int hpw = (int) Math.floor(perpiece / 2f) - 1;

            if (i > 0) {
                for (int j = 0; j < line.size(); j++) {

                    // split node
                    char c = ' ';
                    if (j % 2 == 1) {
                        if (line.get(j - 1) != null) {
                            c = (line.get(j) != null) ? '┴' : '┘';
                        } else {
                            if (j < line.size() && line.get(j) != null) c = '└';
                        }
                    }
                    System.out.print(c);

                    // lines and spaces
                    if (line.get(j) == null) {
                        for (int k = 0; k < perpiece - 1; k++) {
                            System.out.print(" ");
                        }
                    } else {

                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? " " : "─");
                        }
                        System.out.print(j % 2 == 0 ? "┌" : "┐");
                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? "─" : " ");
                        }
                    }
                }
                System.out.println();
            }

            // print line of numbers
            for (int j = 0; j < line.size(); j++) {

                String f = line.get(j);
                if (f == null) f = "";
                int gap1 = (int) Math.ceil(perpiece / 2f - f.length() / 2f);
                int gap2 = (int) Math.floor(perpiece / 2f - f.length() / 2f);

                // a number
                for (int k = 0; k < gap1; k++) {
                    System.out.print(" ");
                }
                System.out.print(f);
                for (int k = 0; k < gap2; k++) {
                    System.out.print(" ");
                }
            }
            System.out.println();

            perpiece /= 2;
        }
    }
}