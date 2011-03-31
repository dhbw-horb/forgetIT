package forgetit.gui;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

import forgetit.common.Category;
import forgetit.common.Entity;
import forgetit.common.Tag;
import forgetit.gui.views.IEntitiesView;
import forgetit.logic.ILogicNote;
import forgetit.logic.ILogicNoteProvider;
import forgetit.logic.ILogicTags;

public class GraphicsController {
	
	private GraphicsModel model = null;
	private LinkedList<Button> tagBtns = new LinkedList<Button>();
	private LinkedList<Text> dateFields = new LinkedList<Text>();
	private LinkedList<IEntitiesView> entitiesViews = new LinkedList<IEntitiesView>();

	public GraphicsController(ILogicTags lt, ILogicNote ln, ILogicNoteProvider provider) {		
		// create graphic model
		this.model = new GraphicsModel(lt, ln, provider); 
		
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
	
	public void addDateField(Text field) {
		if(!dateFields.contains(field)) {
			dateFields.add(field);
		}
	}
	
	public void removeDateField(Text field) {
		if(dateFields.contains(field)) {
			dateFields.remove(field);
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
	
	public void searchTextChanged() {
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
	
	public void dateFieldsChanged() {
		//TODO implement this listener
		refreshViews();
	}
	
	public String getToday() {
		return model.toString().replace("-", ".").substring(0, 9);
	}
	
	public List<String> getTags() {
		List<String> strTags = new LinkedList<String>();
		List<Tag> tags = model.getTags();
		for(Tag tag : tags) {
			strTags.add(tag.getName());
		}
		return strTags;
	}
	
	private void refreshViews() {
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
