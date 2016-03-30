package test.persistence;

import persistence.Category;
import persistence.exception.DeleteException;
import persistence.exception.LoadException;
import persistence.exception.SaveException;

public class CategoryT extends Category {

	public CategoryT() {
		super();
	}

	@Override
	public void loadWithName(String name) throws LoadException {
		// TODO Auto-generated method stub
	}

	@Override
	public void save() throws SaveException {
		// TODO Auto-generated method stub
		// Nothing
	}

	@Override
	public void delete() throws DeleteException {
		// TODO Auto-generated method stub
		
	}

}
