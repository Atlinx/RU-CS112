package Experimentation;

public class Testing {
	public static void main(String[] args) {
		int n = 8;
		int count = 0;
		for (int i = n; i >= 1; i = i/2) {
			for (int j = 1; j <= i; j++)
				count++;
		}
		System.out.println("Final count: " + count);
	}
}

/*

XX
XX
XX
XX
XX
XX
XX

*/

/*

XXXXXXXXXX
XXXXXXX

*/