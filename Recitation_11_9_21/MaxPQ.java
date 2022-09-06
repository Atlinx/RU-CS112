package Recitation_11_9_21;

import java.util.*;

public class MaxPQ<T extends Comparable<T>> {
	private ArrayList<T> list;

	// We are not using the first element
	public MaxPQ() {
		list = new ArrayList<>();
		list.add(null);
	}

	public MaxPQ(ArrayList<T> list) {
		this();
		heapify(list);
	}

	public int size() {
		return list.size() - 1;
	}

	public ArrayList<T> getList() {
		return list;
	}

	public void insert(T element) {
		list.add(element);
		swim(list.size() - 1);
	}

	private int getParentIndex(int index) {
		return index / 2;
	}

	private int getLeftChildIndex(int index) {
		return index * 2;
	}

	private int getRightChildIndex(int index) {
		return index * 2 + 1;
	}

	private T getParent(int index) {
		if (index <= 1 || index >= list.size())
			return null;
		return list.get(getParentIndex(index));
	}

	private T getLeftChild(int index) {
		if (index <= 1 || index >= list.size())
			return null;
		return list.get(getLeftChildIndex(index));
	}

	private T getRightChild(int index) {
		if (index <= 1 || index >= list.size())
			return null;
		return list.get(getRightChildIndex(index));
	}

	private void swim(int index) {
		while (index > 1 && list.get(getParentIndex(index)).compareTo(list.get(index)) < 0) {
			swap(index, getParentIndex(index));
			index = getParentIndex(index);
		}
	}

	public boolean isMaxHeap() {
		 return isMaxHeapHelper(1);
	}

	public boolean isMaxHeapConstantSpace() {
		for (int index = 1; index < list.size(); index++) {
			T left = getLeftChild(index);
			T right = getRightChild(index);
			if (left == null || right == null)
				break;
			if (list.get(index).compareTo(left) < 0 || list.get(index).compareTo(right) < 0)
				return false;
		}
		return true;
	}

	private boolean isMaxHeapHelper(int index) {
		T left = getLeftChild(index);
		T right = getRightChild(index);
		if (left == null || right == null)
			return true;
		if (list.get(index).compareTo(left) > 0 && list.get(index).compareTo(right) > 0)
			return isMaxHeapHelper(getLeftChildIndex(index)) && isMaxHeapHelper(getRightChildIndex(index));
		return false;
	}

	private void sink(int index) {
		// TODO: implement sink
		while (getLeftChild(index) != null || getRightChild(index) != null) {
			if (list.get(index).compareTo(getLeftChild(index)) < 0) {
				swap(index, getLeftChildIndex(index));
				index = getLeftChildIndex(index);
			} else if (list.get(index).compareTo(getLeftChild(index)) < 0) {
				int leftChildIndex = getLeftChildIndex(index); 
				swap(index, leftChildIndex);
				index = leftChildIndex;
			}
		}
	}

	private void swap(int index, int otherIndex) {
		var temp = list.get(index);
		list.set(index, list.get(otherIndex));
		list.set(otherIndex, temp);
	}

	public void heapify(ArrayList<T> a) {
		for (int i = 0; i < a.size(); i++)
			insert(a.get(i));
	}

	public T deleteMax() {
		if (size() > 0) {
			T result = list.get(1);
			sink(1);
			return result;
		}
		return null;
	}
	
	public static <T extends Comparable<T>> ArrayList<T> topK(ArrayList<T> a, int k) {
		MaxPQ<T> pq = new MaxPQ<T>(a);
		ArrayList<T> result = new ArrayList<T>();
		for (int i = 0; i < k; i++)
			result.add(pq.deleteMax());
		return result;
	}
}
