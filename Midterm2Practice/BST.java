package Midterm2Practice;

import java.util.ArrayList;
import java.util.List;

public class BST {
	public static void main(String[] args) {
		BSTNode node = new BSTNode(10);
		node.left = new BSTNode(5);
		node.left.left = new BSTNode(3);
		node.left.right = new BSTNode(9);
		node.right = new BSTNode(15);
		node.right.left = new BSTNode(13);
		node.right.right = new BSTNode(21);
		testCountInRange(node, 4, 11);
		testCountInRange(node, 16, 17);
		testCountInRange(node, 15, 17);
		testCountInRange(node, 0, 21);

		BSTNode rotNode = new BSTNode(10);
		rotNode.left = new BSTNode(5);
		rotNode.right = new BSTNode(15);
		rotNode.right.left = new BSTNode(13);
		rotNode.right.right = new BSTNode(20);

		printKeyInOrder(rotNode);
		print(rotNode);
		BSTNode newRoot = rotNode.right;
		rotateLeft(rotNode);
		print(newRoot);
		printKeyInOrder(newRoot);
	}

	public static void printTreePretty(BSTNode node) {
		System.out.println("Tree: ");
		printTreePrettyHelper(node, "");
	}

	public static void printTreePrettyHelper(BSTNode node, String tabStr) {
		if (node == null) {
			System.out.println("]");
			return;
		}
		System.out.println(node.key);
		System.out.print(tabStr + "|-- ");
		printTreePrettyHelper(node.left, tabStr + "|" + "   ");
		System.out.print(tabStr + "'-- ");
		printTreePrettyHelper(node.right, tabStr + " " + "   ");
	}

	public static void printKeyInOrder(BSTNode node) {
		System.out.print("Keys: ");
		printKeyInOrderHelper(node);
		System.out.println();
	}

	public static void printKeyInOrderHelper(BSTNode node) {
		if (node == null)
			return;
		printKeyInOrderHelper(node.left);
		System.out.print(node.key + ", ");
		printKeyInOrderHelper(node.right);
	}

	public static void testCountInRange(BSTNode root, int low, int height) {
		System.out.println("Count range " + low + "-" + height + ": " + countInRange(root, low, height));
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

	public static void rotateLeft(BSTNode node) {
		if (node == null || node.right == null)
			return;
		BSTNode right = node.right;
		node.right = right.left;
		right.left = node;
	}

	public static int countInRange(BSTNode root, int low, int height) {
		if (root == null)
			return 0;
		
		int count = 0;
		if (root.key >= low && root.key <= height)
			count++;
		if (root.key > low)
			count += countInRange(root.left, low, height);
		if (root.key < height)
			count += countInRange(root.right, low, height);
		return count;
	}


    /**
     * Print a tree
     * 
     * @param root
     *            tree root node
     */
    public static void print(BSTNode root)
    {
		System.out.println();
		System.out.println();
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