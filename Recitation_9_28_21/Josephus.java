package Recitation_9_28_21;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import javax.management.Query;

public class Josephus {
	public static void main(String[] args) {
		josephus(7, 2);
	}

	public static void josephus(int numberOfPeople, int peopleSkippedPerKill) {
		Queue<Integer> people = new LinkedList<>();
		for (int i = 0; i < numberOfPeople; i++)
			people.add(i);
		
		// Simulate the killings
		while (!people.isEmpty()) {
			for (int i = 0; i < peopleSkippedPerKill - 1; i++)
				people.add(people.remove());
			System.out.print(people.remove() + " ");
		}
	}
}