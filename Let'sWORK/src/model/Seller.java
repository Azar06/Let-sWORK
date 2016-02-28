package model;

public class Seller extends Person{
	private String siret;
	private String url;
	
	public Seller(String ln, String fn, String s, String pc, String c, String p, String e, String siret, String url) {
		super(ln, fn, s, pc, c, p, e);
		this.siret=siret;
		this.url=url;
	}
	
	public void setSiret(String siret) {
		this.siret=siret;
	}
	
	public String getSiret() {
		return this.siret;
	}
	
	public void setUrl(String url) {
		this.url=url;
	}

	public String getUrl() {
		return this.url;
	}
}
