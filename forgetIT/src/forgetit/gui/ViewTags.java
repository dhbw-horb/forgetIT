package forgetit.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class ViewTags extends StandardView {
	
	Composite parent;

	public ViewTags(Composite parent) {
		super(parent,"Tags");
		this.parent = parent;
		initGui();
	}
	
	private void initGui() {
		// layout
		RowLayout layout = new RowLayout();
		content.setLayout(layout);
		
		// titleBar
		setTitleBarColors(new RGB(0,0,0),new RGB(130,230,200));
		
		// test content
		Button btnTest1 = new Button(content, SWT.PUSH);
		btnTest1.setText("Study");
		Button btnTest2 = new Button(content, SWT.PUSH);
		btnTest2.setText("Work");
		Button btnTest3 = new Button(content, SWT.PUSH);
		btnTest3.setText("Personal");
	}
}