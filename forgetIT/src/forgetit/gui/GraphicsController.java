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

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

import forgetit.common.Category;
import forgetit.common.Date;
import forgetit.common.Entity;
import forgetit.common.Tag;
import forgetit.gui.views.IEntitiesView;
import forgetit.logic.Calendar;
import forgetit.logic.ILogicEntity;
import forgetit.logic.ILogicEntityProvider;
import forgetit.logic.ILogicTags;
import forgetit.logic.interfaces.ICalendar;

/**
 * The "controller" of the gui
 * 
 * GraphicsController is the interface between GraphicsModel and the views.
 * The gui-package works like the MVC-Pattern descripes.
 * 
 * @author ChornHulio (<a href="mailto:[chornhulio@web.de]">chornhulio@web.de</a>)
 * @since 0.1
 */
public class GraphicsController {
	
	private Display display = null;
	private MainWindow mainWindow = null;
	private GraphicsModel model = null;
	private LinkedList<Button> tagBtns = new LinkedList<Button>();
	private LinkedList<IEntitiesView> entitiesViews = new LinkedList<IEntitiesView>();

	public GraphicsController(ILogicTags lt, ILogicEntity ln, ILogicEntityProvider provider, ICalendar cal) {		
		// create graphic model
		this.model = new GraphicsModel(lt, ln, provider, cal); 

		// create graphic view
		display = new Display();
		mainWindow = new MainWindow(display, this);
		
		// show the current entities
		refreshViews();
	}
	
	public void addTagButton(Button btn) {
		if(!tagBtns.contains(btn)) {
			tagBtns.add(btn);
		}
	}
	
	public void removeTagButton(Button btn) {
		if(tagBtns.contains(btn)) {
			tagBtns.remove(btn);
		}
	}
	
	public void setStartDate(Text field) {
		Calendar cal = new Calendar();
		try {
			Date startDate = cal.convertStringToDate(field.getText());
			model.setStartDate(startDate);
			refreshViews();
		} catch (Exception e) {
			String startDate = cal.convertDateToStringInGermanStyle(model.getStartDate());
			field.setText(startDate);
		}
	}
	
	public void setEndDate(Text field) {
		Calendar cal = new Calendar();
		try {
			Date endDate = cal.convertStringToDate(field.getText());
			model.setEndDate(endDate); 
			refreshViews();
		} catch (Exception e) {
			String endDate = cal.convertDateToStringInGermanStyle(model.getEndDate());
			field.setText(endDate);
		}
	}
	
	public void addEntitiesView(IEntitiesView view) {
		if(!entitiesViews.contains(view)) {
			entitiesViews.add(view);
		}
	}
	
	public void removeEntitiesView(IEntitiesView view) {
		if(entitiesViews.contains(view)) {
			entitiesViews.remove(view);
		}
	}
	
	public void searchTextChanged(Text field) {
		//TODO implement this listener	
		refreshViews();
	}
	
	public void tagBtnsChanged() {
		List<Tag> selectedTags = new LinkedList<Tag>();
		List<Tag> allTags = model.getTags();
		for(Button btn : tagBtns) {
			if(btn.getSelection()) {
				for(int i = 0; i < allTags.size(); i++) {
					if(allTags.get(i).getName().matches(btn.getText())) {
						selectedTags.add(allTags.get(i));
						break;
					}
				}				
			}
		}
		model.setTagsList(selectedTags);
		refreshViews();
	}
	
	public void addEntity(Entity entity) {
		model.addEntity(entity);	
		refreshViews();
	}
	
	public void deleteAllEntities() {
		model.deleteAllEntities();
		refreshViews();
	}
	
	public String getToday() {
		// Get the current date
		Date today = model.getToday();
		
		// convert it in a string		
		return new Calendar().convertDateToStringInGermanStyle(today);
	}
	
	public List<String> getTags() {
		List<String> strTags = new LinkedList<String>();
		List<Tag> tags = model.getTags();
		if(tags == null) {
			return null;
		}
		for(Tag tag : tags) {
			strTags.add(tag.getName());
		}
		return strTags;
	}
	
	public void refreshViews() {
		List<Entity> entities = model.getEntities();
		if(entities == null) {
			return;
		}

		// iterate over all views
		for(IEntitiesView view : entitiesViews) {
			// only use the compatible entities for the view
			LinkedList<Entity> entitiesForView = new LinkedList<Entity>();
			Category category = view.getCategory();
			for(Entity entity : entities) {
				if(category == entity.getCategory()) {
					entitiesForView.add(entity);
				}
			}
			// refresh the view
			view.refreshView(entitiesForView);
		}
	}
	
	public void waitForDispose() {
		mainWindow.waitForDispose();
		display.dispose();
	}
}
