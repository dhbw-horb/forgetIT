package forgetit.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class ViewNotes extends StandardView {
	
	Composite parent;

	public ViewNotes(Composite parent) {
		super(parent,"Notes");
		this.parent = parent;
		initGui();
	}
	
	private void initGui() {
		RowLayout layout = new RowLayout();
		layout.type = SWT.VERTICAL;
		content.setLayout(layout);
		Label label1 = new Label(content, SWT.CENTER);
		label1.setText("Placeholder");
		Label label2 = new Label(content, SWT.CENTER);
		label2.setText("for");
		Label label3 = new Label(content, SWT.CENTER);
		label3.setText("Notes");
	}

}