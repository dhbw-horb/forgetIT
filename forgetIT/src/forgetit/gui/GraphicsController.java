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
import forgetit.logic.ILogicNote;
import forgetit.logic.ILogicNoteProvider;
import forgetit.logic.ILogicTags;
import forgetit.logic.interfaces.ICalendar;

public class GraphicsController {
	
	private GraphicsModel model = null;
	private LinkedList<Button> tagBtns = new LinkedList<Button>();
	private LinkedList<IEntitiesView> entitiesViews = new LinkedList<IEntitiesView>();

	public GraphicsController(ILogicTags lt, ILogicNote ln, ILogicNoteProvider provider, ICalendar cal) {		
		// create graphic model
		this.model = new GraphicsModel(lt, ln, provider, cal); 
		
		// create graphic view
		Display display = new Display();
		new MainWindow(display, this);
		display.dispose();
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
	
	public void addActivitiesView(IEntitiesView view) {
		if(!entitiesViews.contains(view)) {
			entitiesViews.add(view);
		}
	}
	
	public void removeActivitiesView(IEntitiesView view) {
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
	
	public String getToday() {
		// Get the current date
		Date today = model.getToday();
		
		// convert it in a string		
		return new Calendar().convertDateToStringInGermanStyle(today);
	}
	
	public List<String> getTags() {
		List<String> strTags = new LinkedList<String>();
		List<Tag> tags = model.getTags();
		for(Tag tag : tags) {
			strTags.add(tag.getName());
		}
		return strTags;
	}
	
	public void refreshViews() {
		List<Entity> entities = model.getEntities();
		
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
}
