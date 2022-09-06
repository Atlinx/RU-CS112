package Recitation_9_7_21;

import java.util.Arrays;

public class HighwayExits
{
	public static void main(String[] args) {
		clearScreen();

		int[] testDistances = new int[] { 5, 3, 4, 2, 8, 6 };
		int startExit = 3;
		int endExit = 5;
		System.out.println("Test Distances: " + Arrays.toString(testDistances));
		System.out.println("================" + "=".repeat(testDistances.length * 3));
		System.out.println(String.format("Calculated distance from exit %s to %s:\t\t", startExit, endExit) + String.valueOf(calculateDistance(testDistances, startExit, endExit)));
		System.out.println(String.format("Calculated efficient distance from exit %s to %s:\t", startExit, endExit) + String.valueOf(efficientDistance(testDistances, startExit, endExit)));	
	}

	public static void clearScreen() {
		System.out.print("\033[H\033[2J");  
		System.out.flush();
	}

	// Time Complexity:		O(n)
	// Space Complexity:	O(1)
	public static int calculateDistance(int[] distanceArray, int startExit, int endExit) {
		int totalDistance = 0;
		for (int i = startExit; i < endExit; i++)
			totalDistance += distanceArray[i];
		return totalDistance;
	}

	// Time Complexity:		O(1)
	// Space Complexity:	O(n)
	private static int[] efficientDistanceCached;
	
	public static int efficientDistance(int[] distanceArray, int startExit, int endExit) {
		if (efficientDistanceCached == null) {
			int totalDistance = 0;
			efficientDistanceCached = new int[distanceArray.length];
			for (int i = 0; i < distanceArray.length; i++) {
				totalDistance += distanceArray[i];
				efficientDistanceCached[i] = totalDistance;
			}
		}

		return efficientDistanceCached[endExit - 1] - efficientDistanceCached[startExit - 1];
	}
}