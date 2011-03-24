package forgetit.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class ViewDate extends StandardView {
	
	Composite parent;

	public ViewDate(Composite parent) {
		super(parent,"Date");
		this.parent = parent;
		initGui();
	}
	
	private void initGui() {
		// layout
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		content.setLayout(layout);
		
		// titleBar
		setTitleBarColors(new RGB(0,0,0),new RGB(130,230,200));
		
		// content
		Label labelStart = new Label(content, SWT.CENTER);
		labelStart.setText("Start:");
		Text textStart = new Text(content, SWT.SINGLE);
		textStart.setText("04.03.2010");
		Label labelEnd = new Label(content, SWT.CENTER);
		labelEnd.setText("End:");
		Text textEnd = new Text(content, SWT.SINGLE);
		textEnd.setText("05.04.3020");		
	}
}