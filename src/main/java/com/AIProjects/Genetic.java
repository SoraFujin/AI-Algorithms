package com.AIProjects;

// a method initialize population --done
// a method for evaluation of population
// a method to select which solutin has the best fitness
// a mthod for cross over to create new routes by combining genetic material from 2 parents
// a method for mutation random changes to the current population by randomly swaping 2 indexes in
// the list
// a method to create new generation the children of the crossover and mutation with the best
// fitness function

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Genetic {
	private List<Integer> arrangement;

	public Genetic(List<Integer> arrangment) {
		this.arrangement = new ArrayList<>();
	}

	public List<List<Integer>> initializePopulation(int population_size) {
		List<List<Integer>> population = new ArrayList<>();
		for (int i = 0; i < population_size; i++) {
			List<Integer> arrangment = new ArrayList<>();
			for (int j = 0; j < 10; j++) {
				arrangment.add(j);
			}
			Collections.shuffle(arrangement);
			population.add(arrangment);
		}
		return population;
	}

	public List<List<Integer>> evolve(List<List<Integer>> population, double mutationRate) {
		List<List<Integer>> newPopulation = new ArrayList<>();
		population.sort(Comparator.comparingDouble(Main::calculate_cost));
		int eliteCount = (int) (0.6 * population.size());

		newPopulation.addAll(population.subList(0, eliteCount));

		Random random = new Random();
		while (newPopulation.size() < population.size()) {
			List<Integer> parent1 = population.get(random.nextInt(eliteCount));
			List<Integer> parent2 = population.get(random.nextInt(eliteCount));
			List<Integer> child = crossOver(parent1, parent2);
			if (random.nextDouble() < mutationRate) {
				mutate(child);
			}
			newPopulation.add(child);
		}

		return newPopulation;

	}

	public List<Integer> crossOver(List<Integer> parent1, List<Integer> parent2) {
		Random random = new Random();
		int crossOverPoint = random.nextInt(parent1.size());
		List<Integer> child = new ArrayList<>(parent1.subList(0, crossOverPoint));
		for (Integer gene : parent2) {
			if (!child.contains(gene))
				child.add(gene);
		}
		return child;
	}

	private static void mutate(List<Integer> arrangement) {
		Random random = new Random();
		int index1 = random.nextInt(arrangement.size());
		int index2 = random.nextInt(arrangement.size());
		Collections.swap(arrangement, index1, index2);
	}

}

