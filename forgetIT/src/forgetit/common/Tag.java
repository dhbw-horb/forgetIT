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

/**
 * 
 * @author David Henn
 * @date 15.3.2011
 *
 */

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@javax.persistence.Entity
public class Tag implements Serializable {

	private int id;
	private String name;
	private String description;
	private List<Entity> entities;

	@ManyToMany(targetEntity = forgetit.common.Entity.class, mappedBy = "tags", cascade = { CascadeType.ALL,
			CascadeType.PERSIST, CascadeType.MERGE })
	public List<Entity> getEntities() {

		return entities;
	}

	public Tag() {

	}

	public Tag(int id) {

		this.setId(id);
	}

	public Tag(int id, String name) {

		this.setId(id);
		this.name = name;
	}

	public Tag(int id, String name, String description) {

		this.setId(id);
		this.name = name;
		this.description = description;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public String getDescription() {

		return description;
	}

	public void setDescription(String description) {

		this.description = description;
	}

	@Id
	@GeneratedValue
	public int getId() {

		return id;
	}

	public void setId(int id) {

		this.id = id;
	}

	public void setEntities(List<Entity> entities) {

		this.entities = entities;
	}

}
