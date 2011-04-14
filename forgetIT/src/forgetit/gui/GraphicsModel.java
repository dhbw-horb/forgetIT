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

package forgetit.gui;

import java.util.LinkedList;
import java.util.List;

import forgetit.common.Date;
import forgetit.common.Entity;
import forgetit.common.Tag;
import forgetit.logic.ILogicEntity;
import forgetit.logic.ILogicEntityProvider;
import forgetit.logic.ILogicTags;
import forgetit.logic.interfaces.ICalendar;

/**
 * The "data model" of the gui
 * 
 * GraphicsModel is the interface to the logic layer. It takes and holds the data.
 * The gui-package works like the MVC-Pattern descripes.
 * 
 * @author ChornHulio (<a href="mailto:[chornhulio@web.de]">chornhulio@web.de</a>)
 * @since 0.1
 */
public class GraphicsModel {
	
	private ILogicTags logicTags = null;
	private ILogicEntity logicNotes = null;
	private ILogicEntityProvider provider = null;
	private ICalendar cal = null;
		
	private Date startDate = null;
	private Date endDate = null;
	private List<Tag> tags = new LinkedList<Tag>();
	
	
	public GraphicsModel(ILogicTags lt, ILogicEntity ln, ILogicEntityProvider provider, ICalendar cal) {
		this.provider = provider;
		this.logicTags = lt;
		this.logicNotes = ln;
		this.cal = cal;
		this.startDate = this.getToday();
		this.endDate = this.getToday();
		this.tags = this.getTags();
	}
	
	public void setStartDate(Date date) throws IllegalArgumentException {
		if(cal.checkDate(date)) {
			startDate = date;
		} else {
			throw new IllegalArgumentException("That's not a date");
		}
	}	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setEndDate(Date date) throws IllegalArgumentException {
		if(cal.checkDate(date)) {
			endDate = date;
		} else {
			throw new IllegalArgumentException("That's not a date");
		}
	}
	public Date getEndDate() {
		return endDate;
	}
	
	public void setTagsList(List<Tag> tags) {
		this.tags = tags;
	}
	
	public Date getToday() {
		return cal.today();
	}
	
	public List<Tag> getTags() {
		return logicTags.getTags();
		
		// TODO delete dummy
		/*// Dummy
		List<Tag> tags = new LinkedList<Tag>();
		String[] tagTitles = {"Work", "Study", "Personal"};
		for (int i=0; i < tagTitles.length; i++) {
			tags.add(new Tag( i, tagTitles[i], "Description of "+tagTitles[i]));
		}
		return tags;*/
	}

	public List<Entity> getEntities() {
		if(startDate == null || endDate == null) {
			if(tags.isEmpty()) {
				// all entities
				return provider.getEntities();
			} else {
				// all entities with the given tags
				return provider.getEntities(tags);
			}
		} else {
			if(tags.isEmpty()) {
				// all entities between startDate and endDate
				return provider.getEntities(startDate, endDate);
			} else {
				// all entities with the given tags and between startDate and endDate
				return provider.getEntities(startDate, endDate, tags);
			}
		}
	}
	
	public void addEntity(Entity entity) {
		logicNotes.addEntity(entity);
	}
	
	public void deleteEntity(Entity entity) {
		logicNotes.deleteEntity(entity);
	}
	
	public void changeEntity(Entity entity) {
		logicNotes.changeEntity(entity);
	}
}
