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
	
	/**
	 * Create a new activity
	 * @throws SaveException
	 */
	public abstract void save() throws SaveException;
	
	/**
	 * Delete the activity selected
	 * @throws DeleteException
	 */
	public abstract void delete() throws DeleteException;
	
	// GETTER AND SETTER
	
	// Accesseurs & Mutateurs : NAME
	/**
	 * Get the name of an activity
	 * @return the name of an activity
	 */
	public String getName() {
		return this.name;
	}
	
	public void setName(String nom) {
		this.name = nom;
	}
	
	// Accesseurs & Mutateurs : DATE
	/**
	 * Get the date of an activity
	 * @return the date of an activity
	 */
	public Date getDate() {
		return this.date;
	}
	
	/**
	 * Change the date of an activity
	 * @param dateDetail : the new date of the activity
	 */
	public void setDate(Date dateDetail) {
		this.date = dateDetail;
	}
	
	// Accesseurs & Mutateurs : POSITION
	/**
	 * Get the time position of an activity
	 * @return the time position of an activity
	 */
	public TimePosition getPosition() {
		return this.position;
	}
		
	/**
	 * Change the position time of an activity
	 * @param position : the new position time of the activity
	 */
	public void setPosition(TimePosition position) {
		this.position = position;
	}
		
	// Accesseurs & Mutateurs : ISPUBLIC
	/**
	 * Get if the activity is public
	 * @return true if the activity is public, false otherwise
	 */
	public boolean getIsPublic() {
		return this.isPublic;
	}
	
	/**
	 * Change the visibility of an activity
	 * @param estPublic : the new visibility of the activity
	 */
	public void setIsPublic(boolean estPublic) {
		this.isPublic = estPublic;
	}
	
	// Accesseurs & Mutateurs : JOURNALID
	/**
	 * Get the diary where the activity is placed
	 * @return the name of an activity
	 */
	public Diary getDiary() {
		return this.diary;
	}
			
	/**
	 * Change the journal id of an activity
	 * @param journalId : the new journal id of the activity
	 */
	public void setDiary(Diary journalId) {
		this.diary = journalId;
	}
	
	// Accesseurs & Mutateurs : CATEGORYID
	/**
	 * Get the category of an activity
	 * @return the category of an activity
	 */
	public Category getCategory() {
		return this.category;
	}
	
	/**
	 * Change the category of an activity
	 * @param cat : the new category of the activity
	 */
	public void setCategory(Category cat) {
		this.category = cat;
	}
	
	// Accesseurs & Mutateurs : GOALID
	/**
	 * Get the goal of the activity
	 * @return the goal of the activity
	 */
	public Goal getGoal() {
		return this.goal;
	}
				
	/**
	 * Change the goal of an activity
	 * @param but : the new goal of the activity
	 */
	public void setGoal(Goal but) {
		this.goal = but;
	}
}
