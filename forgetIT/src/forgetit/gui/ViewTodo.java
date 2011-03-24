package forgetit.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class ViewTodo extends StandardView {
	
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
}
