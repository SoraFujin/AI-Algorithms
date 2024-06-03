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
import java.util.List;

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

	public List<Integer> crossOver(List<Integer> arrangment) {
		return arrangment;
	}

}

