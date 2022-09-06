package Experimentation;

public class RuntimeAnalysis {
	public static void main(String[] args) {
		int n = 8;
		int iterCount = 0;

		clearScreen();
		System.out.println("TESTING FOR RUNTIME WITH n=" + n);

		System.out.println("i = n, i > 1, i /= 2");
		for (int i = n; i > 1; i /= 2) {
			iterCount += 1;
			System.out.print("0");
		}
		System.out.println("\nIter count: " + iterCount + "\n");

		iterCount = 0;
		System.out.println("i = n, i >= 1, i /= 2");
		for (int i = n; i >= 1; i /= 2) {
			iterCount += 1;
			System.out.print("0");
		}
		System.out.println("\nIter count: " + iterCount + "\n");

		iterCount = 0;
		System.out.println("i = 1, i < n, i *= 2");
		for (int i = 1; i < n; i *= 2) {
			iterCount += 1;
			System.out.print("0");
		}
		System.out.println("\nIter count: " + iterCount + "\n");	
		
		iterCount = 0;
		System.out.println("i = 1, i <= n, i *= 2");
		for (int i = 1; i <= n; i *= 2) {
			iterCount += 1;
			System.out.print("0");
		}
		System.out.println("\nIter count: " + iterCount + "\n");

		// <= 1 and >= 1 create an extra iteration and both will round up to the nearest base^x
		// < 1 will round up to the nearest base^x
		// > 1 will round down to the nearest base^x

		int uniqueStart = 4;
		System.out.println("TESTING UNIQUE i=" + uniqueStart);

		iterCount = 0;
		System.out.println("i = 1, i < n, i *= 2");
		for (int i = uniqueStart; i < n; i *= 2) {
			iterCount += 1;
			System.out.print("0");
		}
		System.out.println("\nIter count: " + iterCount + "\n");	
		
		iterCount = 0;
		System.out.println("i = 1, i <= n, i *= 2");
		for (int i = uniqueStart; i <= n; i *= 2) {
			iterCount += 1;
			System.out.print("0");
		}
		System.out.println("\nIter count: " + iterCount + "\n");
	}

	public static void clearScreen() {
		System.out.print("\033[H\033[2J");  
		System.out.flush();
	}
}