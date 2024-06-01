package com.AIProjects;

import java.util.ArrayList;
import java.util.List;

public class HillClimbing {
	private double[][] data;
	private List<Integer> arrangement;

	public HillClimbing(double[][] data, List<Integer> arrangement) {
		this.data = data;
		this.arrangement = new ArrayList<>(arrangement);
	}


	public double calculate_cost(List<Integer> arrangement) {}

	public List<State> getNeighbor() {
		List<State> neighbors = new ArrayList<>();
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
		return "Seating arrangment " + arrangement + "\n dislike " + calculate_cost(arrangement);
	}
}
