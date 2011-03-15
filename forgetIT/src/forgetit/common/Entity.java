package forgetit.common;

import java.util.GregorianCalendar;
import java.util.List;


/**
 * 
 * @author David Henn
 * @date 15.3.2011
 *
 */

public class Entity {

	private int id;
	private String title;
	private String description;
	private Status status;
	private Function priority;
	private GregorianCalendar startDate;
	private GregorianCalendar endDate;	
	private List<Tag> tags;	
	private List<Entity> dependencies; //All notes, that have to happen before
	
	public Entity(int id){
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Function getPriority() {
		return priority;
	}
	public void setPriority(Function priority) {
		this.priority = priority;
	}
	public GregorianCalendar getStartDate() {
		return startDate;
	}
	public void setStartDate(GregorianCalendar startDate) {
		this.startDate = startDate;
	}
	public GregorianCalendar getEndDate() {
		return endDate;
	}
	public void setEndDate(GregorianCalendar endDate) {
		this.endDate = endDate;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	public List<Entity> getDependencies() {
		return dependencies;
	}
	public void setDependencies(List<Entity> dependencies) {
		this.dependencies = dependencies;
	}
	public int getId() {
		return id;
	}
	
	
	
}
