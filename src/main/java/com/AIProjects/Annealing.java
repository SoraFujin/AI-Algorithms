package com.AIProjects;
// calculate the Cost
// acceptance func
// generate a new arrangement

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Annealing {
	private List<Integer> arrangement = new ArrayList<>();

	public Annealing(List<Integer> arrangment) {
		this.arrangement = arrangment;
	}

	// Boltzmann Probability distribution
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
}

