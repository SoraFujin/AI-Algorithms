package com.AIProjects;

import java.util.ArrayList;
import java.util.List;

public class HillClimbing {
	private List<Integer> arrangement;

	public HillClimbing(List<Integer> arrangement) {
		this.arrangement = new ArrayList<>(arrangement);
	}


	public List<List<Integer>> getNeighbor() {
		List<List<Integer>> neighbors = new ArrayList<>();
		for (int i = 0; i < arrangement.size(); i++) {
			for (int j = i + 1; j < arrangement.size(); j++) {
				List<Integer> newArrangement = new ArrayList<>(arrangement);
				swap(newArrangement, i, j);
			}
		}
		return neighbors;
	}

	public void swap(List<Integer> list, int i, int j) {
		int temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}

	public String toString() {
		return "Seating arrangment " + arrangement;
	}
}
