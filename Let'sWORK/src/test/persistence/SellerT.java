package test.persistence;

import persistence.PersonInfo;
import persistence.Seller;
import persistence.exception.LoadException;
import persistence.exception.SaveException;

public class SellerT extends Seller {

	public SellerT(PersonInfo personInfo, String siret, String url) {
		super(personInfo, siret, url);
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
