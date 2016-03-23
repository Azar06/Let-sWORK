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
	
	public ActivityReturnState create(String name, Date date, int position, boolean isPublic, int diaryId, Category categoryId, int goalId) {
		ActivityReturnState state = new ActivityReturnState();
		if (name == null || name.length() == 0) {
			state.setNameState("You need to fill this field.");
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
