package Lecture_10_11_21;

import java.util.Random;

public class Runner
{
	public static void main(String[] args) {
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		BST<Integer, String> tree = new BST<Integer, String>();
		Random rand = new Random(1234);

		for (int i = 0; i < 10; i++)
			tree.put(rand.nextInt(100), randomString(rand, 5, alphabet));
		
		System.out.println("Original");
		System.out.println(tree.toString());
		System.out.println();

		tree.put(73, "REPLACED");

		System.out.println("Replace");
		System.out.println(tree.toString());
		System.out.println();

		tree.put(73, "REPLACED");

		System.out.println("Replace");
		System.out.println(tree.toString());
		System.out.println();
		
		System.out.println("Floor 50 = " + tree.floor(50));
		System.out.println();

		System.out.println("Ceil 50 = " + tree.ceil(50));
		System.out.println();
	}

	public static String randomString(Random rand, int length, String characters) {
		String string = "";
		for (int i = 0; i < length; i++)
			string += characters.charAt(rand.nextInt(characters.length()));
		return string;
	}
}