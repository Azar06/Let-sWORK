package persistence;

public abstract class Seller extends Person {
	
	private String siret;
	private String url;
	
	public Seller(PersonInfo personInfo, String siret, String url) {
		super(personInfo);
		this.siret=siret;
		this.url=url;
	}

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
