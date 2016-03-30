package persistence;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import persistence.exception.LoadException;

public abstract class GoalSet {

	private List<Goal> goals;
	
	public GoalSet() {
		this.goals = new ArrayList<Goal>();
	}
}
