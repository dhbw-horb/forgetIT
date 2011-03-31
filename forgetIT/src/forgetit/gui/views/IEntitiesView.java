package forgetit.gui.views;

import java.util.List;

import forgetit.common.Category;
import forgetit.common.Entity;

public interface IEntitiesView {
	
	public void refreshView(List<Entity> entities);
	
	public Category getCategory();

}
