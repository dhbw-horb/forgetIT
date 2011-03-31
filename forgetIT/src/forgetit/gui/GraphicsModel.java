package forgetit.gui;

import java.util.LinkedList;
import java.util.List;

import forgetit.common.Date;
import forgetit.common.Entity;
import forgetit.common.Tag;
import forgetit.logic.Calendar;
import forgetit.logic.ILogicNote;
import forgetit.logic.ILogicNoteProvider;
import forgetit.logic.ILogicTags;

public class GraphicsModel {
	
	private ILogicTags logicTags = null;
	private ILogicNote logicNotes = null;
	private ILogicNoteProvider provider = null;
		
	private Date startDate = null;
	private Date endDate = null;
	private List<Tag> tags = new LinkedList<Tag>();
	
	
	public GraphicsModel(ILogicTags lt, ILogicNote ln, ILogicNoteProvider provider) {
		this.provider = provider;
		this.logicTags = lt;
		this.logicNotes = ln;
	}
	
	public void setStartDate(Date date) {
		startDate = date;
	}
	
	public void setEndDate(Date date) {
		endDate = date;
	}
	
	public void setTagsList(List<Tag> tags) {
		this.tags = tags;
	}
	
	public Date getToday() {
		return new Calendar().today();
	}
	
	public List<Tag> getTags() {
		//TODO delete dummy		
		//return logicTags.getTags();
		
		// Dummy
		List<Tag> tags = new LinkedList<Tag>();
		for(int i = 0; i < 10; i++) {
			tags.add(new Tag(0,"Test "+i, "Description of Test "+i));
		}
		return tags;
	}

	public List<Entity> getEntities() {
		if(startDate == null || endDate == null) {
			if(tags.isEmpty()) {
				// all entities
				return provider.getNotes();
			} else {
				// all entities with the given tags
				return provider.getNotes(tags);
			}
		} else {
			if(tags.isEmpty()) {
				// all entities between startDate and endDate
				return provider.getNotes(startDate, endDate);
			} else {
				// all entities with the given tags and between startDate and endDate
				return provider.getNotes(startDate, endDate, tags);
			}
		}
	}
	
	public void addEntity(Entity entity) {
		logicNotes.addNote(entity);
	}
	
	public void deleteEntity(Entity entity) {
		logicNotes.deleteNode(entity);
	}
	
	public void changeEntity(Entity entity) {
		logicNotes.changeNote(entity);
	}
}
