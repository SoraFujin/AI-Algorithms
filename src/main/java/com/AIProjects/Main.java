package com.AIProjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Main {
	private static HashMap<Integer, String> namesMap = new HashMap<>();
	private static final double[][] DISLIKE_MATRIX =
			{{0, 0.68, 0.55, 0.30, 0.82, 0.48, 0.33, 0.10, 0.76, 0.43},
					{0.68, 0, 0.90, 0.11, 0.76, 0.20, 0.55, 0.17, 0.62, 0.99},
					{0.55, 0.90, 0, 0.70, 0.63, 0.96, 0.51, 0.90, 0.88, 0.64},
					{0.30, 0.11, 0.70, 0, 0.91, 0.86, 0.78, 0.99, 0.53, 0.92},
					{0.82, 0.76, 0.63, 0.91, 0, 0.43, 0.88, 0.53, 0.42, 0.75},
					{0.48, 0.20, 0.96, 0.86, 0.43, 0, 0.63, 0.97, 0.37, 0.26},
					{0.33, 0.55, 0.51, 0.78, 0.88, 0.63, 0, 0.92, 0.87, 0.81},
					{0.10, 0.17, 0.90, 0.99, 0.53, 0.97, 0.92, 0, 0.81, 0.78},
					{0.76, 0.62, 0.88, 0.53, 0.42, 0.37, 0.87, 0.81, 0, 0.45},
					{0.43, 0.99, 0.64, 0.92, 0.75, 0.26, 0.81, 0.78, 0.45, 0}};

	public static void main(String[] args) {
		fillHashMap();
		genetic_algorithm(100, 1000, 0.1);
		simulated_annealing(1000, 0.99, 10000);
		hill_climbing(100);
	}

	private static void fillHashMap() {
		namesMap.put(0, "Ahmed");
		namesMap.put(1, "Salem");
		namesMap.put(2, "Ayman");
		namesMap.put(3, "Hani");
		namesMap.put(4, "Kamal");
		namesMap.put(5, "Samir");
		namesMap.put(6, "Hakam");
		namesMap.put(7, "Fuad");
		namesMap.put(8, "Ibrahim");
		namesMap.put(9, "Khalid");
	}

	public static double calculate_cost(List<Integer> arrangement) {
		double totalDislike = 0;
		for (int i = 0; i < arrangement.size(); i++) {
			int person1 = arrangement.get(i);
			int person2 = arrangement.get((i + 1) % arrangement.size());
			totalDislike += DISLIKE_MATRIX[person1][person2];
		}
		return totalDislike;
	}

	public static void hill_climbing(int num_restarts) {
		int repeat = 0;
		List<Integer> initialArrangement = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			initialArrangement.add(i);
		}

		double bestCost = Double.MAX_VALUE;
		List<Integer> bestArrangement = new ArrayList<>(initialArrangement);

		Random random = new Random();

		while (repeat < num_restarts) {
			Collections.shuffle(initialArrangement, random);
			HillClimbing hc = new HillClimbing(initialArrangement);
			double currentCost = calculate_cost(initialArrangement);

			boolean foundBetter;
			do {
				foundBetter = false;
				List<List<Integer>> neighbors = hc.getNeighbor();
				for (List<Integer> neighbor : neighbors) {
					double neighborCost = calculate_cost(neighbor);
					if (neighborCost < currentCost) {
						currentCost = neighborCost;
						initialArrangement = neighbor;
						foundBetter = true;
					}
				}
			} while (foundBetter);

			if (currentCost < bestCost) {
				bestCost = currentCost;
				bestArrangement = new ArrayList<>(initialArrangement);
			}

			repeat++;
		}

		System.out.println("Hill Climbing: ");
		System.out.println("Best seating arrangment: ");
		for (int index : bestArrangement) {
			System.out.print(namesMap.get(index) + " ");
		}
		System.out.println();
		System.out.println("Total Cost: " + bestCost + "\n");
	}


	public static void simulated_annealing(int initialTemperature, double coolingRate,
			int numIteration) {
		List<Integer> initialArrangement = new ArrayList<>();
		int minTemp = 1;
		for (int i = 0; i < 10; i++) {
			initialArrangement.add(i);
		}

		Random random = new Random();
		List<Integer> bestArrangement = new ArrayList<>(initialArrangement);
		double bestCost = calculate_cost(bestArrangement);

		double currentTemperature = initialTemperature;
		int iteration = 0;

		while (currentTemperature > minTemp) {
			List<Integer> newArrangement = new ArrayList<>(initialArrangement);
			Collections.shuffle(newArrangement, random);
			double currentCost = calculate_cost(initialArrangement);
			double newCost = calculate_cost(newArrangement);

			if (Annealing.acceptance(currentTemperature, newCost - currentCost)) {
				initialArrangement = new ArrayList<>(newArrangement);
				currentCost = newCost;

				if (newCost < bestCost) {
					bestArrangement = new ArrayList<>(newArrangement);
					bestCost = newCost;
				}
			}

			currentTemperature *= (1 - coolingRate);
			iteration++;

			if (iteration >= numIteration) {
				break;
			}
		}

		System.out.println("Simulated Annealing: ");
		System.out.println("Best Seating: ");
		for (Integer person : bestArrangement) {
			System.out.print(namesMap.get(person) + " ");
		}
		System.out.println("\nBest cost: " + bestCost + "\n");
	}

	public static void genetic_algorithm(int population_size, int num_generation,
			double mutation_rate) {
		List<Integer> initialArrangement = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			initialArrangement.add(i);
		}
		Genetic GA = new Genetic(initialArrangement);
		List<List<Integer>> population = GA.initializePopulation(population_size);

		for (int generation = 0; generation < num_generation; generation++) {
			population = GA.evolve(population, mutation_rate);
		}

		population.sort(Comparator.comparingDouble(Main::calculate_cost));
		List<Integer> bestArrangement = population.get(0);
		System.out.println("Genetic: ");
		System.out.println("Best Seating arrangment");
		for (Integer person : bestArrangement) {
			System.out.print(namesMap.get(person) + " ");
		}
		System.out.println("\nBest cost: " + calculate_cost(bestArrangement) + "\n");
	}

}
