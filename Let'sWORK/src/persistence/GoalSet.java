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
	
	// 
	
	public abstract void loadWithUser(User user) throws LoadException;

	public List<String> getNames() {
		List<String> names = new ArrayList<String>();
		for(Goal goal : this.goals) {
			names.add(goal.getName());
		}
		return names;
	}
	
	public Goal getGoalWithName(String name) {
		Iterator<Goal> it = this.getGoals().iterator();
		Goal goal = null;
		if(name != null){
			while(it.hasNext() && goal == null) {
				Goal g = it.next();
				if(name.equals(g.getName())) {
					goal = g;
				}
			}
		}
		return goal;
	}
	
	// GETTER AND SETTER
	
	public List<Goal> getGoals() {
		return goals;
	}

	public void setGoals(List<Goal> goals) {
		this.goals = goals;
	}
}
