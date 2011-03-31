package forgetit.gui.views;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import forgetit.gui.GraphicsController;

public class ViewTags extends StandardView {
	
	Composite parent;
	GraphicsController controller;

	public ViewTags(Composite parent, GraphicsController controller) {
		super(parent,"Tags");
		this.parent = parent;
		this.controller = controller;
		initGui();
	}
	
	private void initGui() {
		// layout
		GridLayout layout = new GridLayout();
		layout.numColumns = 5;
		content.setLayout(layout);
		
		// titleBar
		setTitleBarColors(new RGB(0,0,0),new RGB(130,230,200));

		// init buttons
		List<String> strTags = controller.getTags();
		for(String str : strTags) {
			// create button with name
			Button btn = new Button(content,SWT.TOGGLE);
			btn.setText(str);
			
			// add listener
			btn.addSelectionListener(new SelectionAdapter() {
	            @Override
	            public void widgetSelected(SelectionEvent e) {
	                controller.tagBtnsChanged();
	            }
	        });
			
			// tell the observer, that there is a new button
			controller.addTagButton(btn);
		}
	}
}