package business.manager;

import java.sql.Date;

import business.Factory;
import business.utils.ActivityReturnState;
import business.utils.CategoryReturnState;
import business.utils.SignupReturnState;
import jdbc.FactoryJDBC;
import persistence.*;

public class ActivityManager {
	private Factory factorio;

	public ActivityManager() {
		// FactoryJDBC creation
		this.factorio = new FactoryJDBC();
	}
	
	public ActivityReturnState create(String name, String date, String position, String isPublic, String diary, String category, String goal) {
		ActivityReturnState state = new ActivityReturnState();
		if (name == null || name.length() == 0) {
			state.setNameState("You need to fill this field.");
		}
		if (date == null || date.length() == 0) {
			state.setDateState("You need to fill this field.");
		}
		if (position == null || position.length() == 0) {
			state.setPositionState("You need to fill this field.");
		}
		if (isPublic == null || isPublic.length() == 0) {
			state.setIsPublicState("You need to fill this field.");
		}
		if (diary == null || diary.length() == 0) {
			state.setDiaryState("You need to fill this field.");
		}
		if (category == null || category.length() == 0) {
			state.setCategoryState("You need to fill this field.");
		}
		if (goal == null || goal.length() == 0) {
			state.setGoalState("You need to fill this field.");
		}
		//If all is right
		if (state.isRight()) {
			Activity activity = this.factorio.createActivity();
			activity.setName(name);
			//activity.setDescription(description);
		}
		return state;
	}
}
