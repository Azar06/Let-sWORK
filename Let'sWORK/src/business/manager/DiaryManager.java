package business.manager;

import java.util.*;

import business.Factory;
import business.utils.GoalReturnState;
import business.utils.SignupReturnState;
import jdbc.FactoryJDBC;
import persistence.*;
import persistence.exception.*;

public class DiaryManager {
	private Factory factorio;

	public DiaryManager() {
		// FactoryJDBC creation
		this.factorio = new FactoryJDBC();
	}
	
	public List<Goal> getGoals(User user) {
		try {
			user.loadGoals();
		}
		catch (LoadException e) {
		}
		return user.getGoals();
	}
	
	public GoalReturnState createGoal(User owner, String name, String description, Date deadline) {
		GoalReturnState goalReturnState = new GoalReturnState();
		//
		if (name == null || name.length() == 0) {
			goalReturnState.setNameState("You need to fill this field.");
		}
		//
		if (description == null || description.length() == 0) {
			goalReturnState.setDescriptionState("You need to fill this field.");
		}
		// 
		if (deadline == null || deadline.after(new Date())) {
			goalReturnState.setDeadlineState("You need to fill this field.");
		}

		// If all is right :
		if (goalReturnState.isRight()) {
			Goal goal = this.factorio.createGoal();
			goal.setUser(owner);
			goal.setName(name);
			goal.setDescription(description);
			goal.setDeadline(deadline);
			try {
				goal.save();
			} catch (SaveException e) {
				e.printStackTrace();
			}
		}
		return goalReturnState;
	}
}
