/*
 * Copyright 2011 DHBW Stuttgart Campus Horb
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either 
 * express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package forgetit.common;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * 
 * @author David Henn
 * @date 15.3.2011
 * 
 */

@javax.persistence.Entity
public class Entity implements Serializable {

	private int id;
	private String title;
	private String description;

	private Status status;

	private Function priority;

	private Date startDate;

	private Date endDate;

	private List<Tag> tags;

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

	@OneToOne(mappedBy = "entity_id")
	public Function getPriority() {

		if (priority == null) {
			return new Function();
		}
		return priority;
	}

	public void setPriority(Function priority) {

		this.priority = priority;
	}

	@OneToOne(mappedBy = "entity_id")
	public Date getStartDate() {

		return startDate;
	}

	public void setStartDate(Date startDate) {

		this.startDate = startDate;
	}

	@OneToOne(mappedBy = "entity_id")
	public Date getEndDate() {

		return endDate;
	}

	public void setEndDate(Date endDate) {

		this.endDate = endDate;
	}

	@ManyToMany(targetEntity = forgetit.common.Tag.class, cascade = { CascadeType.ALL, CascadeType.PERSIST,
			CascadeType.MERGE })
	@JoinTable(name = "ENTITY_TAG", joinColumns = @JoinColumn(name = "ENTITY_ID"), inverseJoinColumns = @JoinColumn(name = "TAG_ID"))
	public List<Tag> getTags() {

		return tags;
	}

	public void setTags(List<Tag> tags) {

		this.tags = tags;
	}

	@OneToMany
	public List<Entity> getDependencies() {

		return dependencies;
	}

	public void setDependencies(List<Entity> dependencies) {

		this.dependencies = dependencies;
	}

	@Id
	@GeneratedValue
	public int getId() {

		return id;
	}

	public Category getCategory() {

		return category;
	}

	public void setCategory(Category category) {

		this.category = category;
	}

	public void setId(int id) {

		this.id = id;
	}

}
