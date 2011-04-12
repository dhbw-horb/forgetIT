package forgetit.gui;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

import forgetit.common.Category;
import forgetit.common.Date;
import forgetit.common.Entity;
import forgetit.common.Function;
import forgetit.common.Tag;
import forgetit.gui.views.IEntitiesView;
import forgetit.logic.Calendar;
import forgetit.logic.ILogicEntity;
import forgetit.logic.ILogicEntityProvider;
import forgetit.logic.ILogicTags;
import forgetit.logic.interfaces.ICalendar;

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
		// TODO replace dummy with this
		/*List<Entity> entities = model.getEntities();
		if(entities == null) {
			return;
		}*/
		// dummy
		List<Entity> entities = new LinkedList<Entity>();
		Function func = new Function();
		List<Integer> coef = new LinkedList<Integer>();
		coef.add(1);
		func.setCoefficients(coef);
		List<Tag> tags = new LinkedList<Tag>();
		tags.add(new Tag(0, "DHBW", "DHBW Horb"));
		for(int i = 0; i < 3; i++) {
			Entity entity = new Entity(i);
			entity.setTitle("TestTodo "+i);
			entity.setCategory(Category.TODO);
			entity.setPriority(func);
			entity.setTags(tags);
			entities.add(entity);
		}
		for(int i = 0; i < 3; i++) {
			Entity entity = new Entity(i);
			entity.setTitle("TestCal "+i);
			entity.setCategory(Category.APPOINTMENT);
			entity.setStartDate(new Date(2011, 04, 12, 12, 34));
			entity.setEndDate(new Date(2011, 04, 13, 12, 34));
			entity.setTags(tags);
			entities.add(entity);
		}
		for(int i = 0; i < 3; i++) {
			Entity entity = new Entity(i);
			entity.setTitle("TestNotes "+i);
			entity.setCategory(Category.NOTE);
			entity.setDescription("I am a test");
			entity.setTags(tags);
			entities.add(entity);
		}
		// End of dummy
		
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
