package Recitation_11_9_21;

import java.lang.reflect.Array;
import java.util.*;

public class MinPQ {
	private MaxPQ<Integer> maxPQ;

	public MinPQ() {
		maxPQ = new MaxPQ<>();
	}

	public int size() {
		return maxPQ.size();
	}

	public void insert(int n) {
		maxPQ.insert(-n);
	}

	public int deleteMin() {
		return -maxPQ.deleteMax();
	}
}