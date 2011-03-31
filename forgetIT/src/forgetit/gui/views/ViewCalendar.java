package forgetit.gui.views;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import forgetit.common.Category;
import forgetit.common.Entity;

public class ViewCalendar extends StandardView implements IEntitiesView {
	
	Composite parent;

	public ViewCalendar(Composite parent) {
		super(parent,"Calendar");
		this.parent = parent;
		initGui();
	}
	
	private void initGui() {
		RowLayout layout = new RowLayout();
		layout.type = SWT.VERTICAL;
		content.setLayout(layout);
		Label label = new Label(content, SWT.CENTER);
		label.setText("Placeholder for Calendar");
	}

	@Override
	public void refreshView(List<Entity> entities) {
		// TODO Auto-generated method stub
		for(Entity entity : entities) {
			System.out.println("Appointment: " + entity.getTitle());
		}
	}

	@Override
	public Category getCategory() {
		return Category.APPOINTMENT;
	}

}
