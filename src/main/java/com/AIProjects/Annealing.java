package com.AIProjects;
// calculate the Cost
// acceptance func
// generate a new arrangement

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Annealing {
	private static List<Integer> arrangement = new ArrayList<>();

	public Annealing(List<Integer> arrangment) {
		this.arrangement = arrangment;
	}

	public static boolean acceptance(double temp, double deltaE) {
		Random random = new Random();
		if (deltaE < 0) {
			return true;
		} else {
			if (random.nextDouble() < Math.exp((deltaE / temp))) {
				return true;
			} else
				return false;
		}
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
}

