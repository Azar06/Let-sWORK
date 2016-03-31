package persistence;

import java.sql.Date;

import persistence.exception.DeleteException;
import persistence.exception.SaveException;

public abstract class Activity {
	private String name;
	private Date date;
	private TimePosition position;
	private boolean isPublic;
	private Diary diary;
	private Category category;
	private Goal goal;

	
	public Activity(String nom, Date dateDetail, TimePosition position, boolean estPublic, Diary journalId, Category cat, Goal butId){
		super();
		this.name = nom;
		this.date = dateDetail ;
		this.position = position ;
		this.isPublic = estPublic ;
		this.diary = journalId ;
		this.category = cat;
		this.goal = butId;
	}
	
	public Activity() {
		this(null, null, null, true, null, null, null);
	}
	
	// ABSTRACT METHODS
	
	public abstract void save() throws SaveException;
	public abstract void delete() throws DeleteException;
	
	// GETTER AND SETTER
	
	// Accesseurs & Mutateurs : NAME
	public String getName() {
		return this.name;
	}
	
	public void setName(String nom) {
		this.name = nom;
	}
	
	// Accesseurs & Mutateurs : DATE
	public Date getDate() {
		return this.date;
	}
	
	public void setDate(Date dateDetail) {
		this.date = dateDetail;
	}
	
	// Accesseurs & Mutateurs : POSITION
	public TimePosition getPosition() {
		return this.position;
	}
		
	public void setPosition(TimePosition position) {
		this.position = position;
	}
		
	// Accesseurs & Mutateurs : ISPUBLIC
	public boolean getIsPublic() {
		return this.isPublic;
	}
	
	public void setIsPublic(boolean estPublic) {
		this.isPublic = estPublic;
	}
	
	// Accesseurs & Mutateurs : JOURNALID
	public Diary getDiary() {
		return this.diary;
	}
			
	public void setDiary(Diary journalId) {
		this.diary = journalId;
	}
	
	// Accesseurs & Mutateurs : CATEGORYID
	public Category getCategory() {
		return this.category;
	}
	
	public void setCategory(Category cat) {
		this.category = cat;
	}
	
	// Accesseurs & Mutateurs : GOALID
	public Goal getGoal() {
		return this.goal;
	}
				
	public void setGoal(Goal but) {
		this.goal = but;
	}
}
