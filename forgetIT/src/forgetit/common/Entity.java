package forgetit.common;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * 
 * @author David Henn
 * @date 15.3.2011
 * 
 */

@javax.persistence.Entity
public class Entity {

	@Id
	@GeneratedValue
	private int id;
	private String title;
	private String description;

	private Status status;

	@OneToOne(mappedBy = "entity_id")
	private Function priority;
	@OneToOne(mappedBy = "entity_id")
	private Date startDate;
	@OneToOne(mappedBy = "entity_id")
	private Date endDate;

	@OneToMany(mappedBy = "entity_id")
	private List<Tag> tags;

	@OneToMany
	private List<Entity> dependencies; // All notes, that have to happen before
	private Category category;

	public Entity() {

		this.title = "";
		this.description = "";
		this.status = Status.IDLE;
		this.priority = new Function();
		this.startDate = new Date();
		this.endDate = new Date();
		this.tags = new LinkedList<Tag>();
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

		if (priority == null) {
			return new Function();
		}
		return priority;
	}

	public void setPriority(Function priority) {

		this.priority = priority;
	}

	public Date getStartDate() {

		return startDate;
	}

	public void setStartDate(Date startDate) {

		this.startDate = startDate;
	}

	public Date getEndDate() {

		return endDate;
	}

	public void setEndDate(Date endDate) {

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

	public Category getCategory() {

		return category;
	}

	public void setCategory(Category category) {

		this.category = category;
	}

}