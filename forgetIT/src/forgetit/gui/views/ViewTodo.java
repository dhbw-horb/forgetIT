package forgetit.gui.views;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import forgetit.common.Category;
import forgetit.common.Entity;

public class ViewTodo extends StandardView implements IEntitiesView {
	
	Composite parent;

	public ViewTodo(Composite parent) {
		super(parent,"ToDo");
		this.parent = parent;
		initGui();
	}
	
	private void initGui() {
		RowLayout layout = new RowLayout();
		layout.type = SWT.VERTICAL;
		content.setLayout(layout);
		Label label = new Label(content, SWT.CENTER);
		label.setText("Placeholder for ToDos");
	}

	@Override
	public void refreshView(List<Entity> entities) {
		// TODO Auto-generated method stub
		for(Entity entity : entities) {
			System.out.println("Todo: " + entity.getTitle());
		}
	}

	@Override
	public Category getCategory() {
		return Category.TODO;
	}
}
