package com.AIProjects;

import java.util.HashMap;

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
		System.out.println("Hello, Java!");
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



}
