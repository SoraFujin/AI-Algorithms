package com.AIProjects;

import java.util.ArrayList;
import java.util.List;

public class State {
	private List<Integer> arrangement;

	public State(List<Integer> arrangement) {
		this.arrangement = new ArrayList<>(arrangement);
	}

	public List<Integer> getArrangmenet() {
		return arrangement;
	}

}
