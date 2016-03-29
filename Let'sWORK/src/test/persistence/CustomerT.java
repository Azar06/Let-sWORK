package test.persistence;

import persistence.Customer;
import persistence.PersonInfo;
import persistence.exception.LoadException;
import persistence.exception.SaveException;

public class CustomerT extends Customer {

	public CustomerT(PersonInfo personInfo) {
		super(personInfo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save() throws SaveException {
		// TODO Auto-generated method stub

	}

	@Override
	public void load(long id) throws LoadException {
		// TODO Auto-generated method stub

	}

}
