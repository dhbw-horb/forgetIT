/*
 * Copyright 2011 DHBW Stuttgart Campus Horb
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either 
 * express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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

/**
 * The view for choosing tags
 * 
 * The outer design (borders, titles, ...) of this view is dependent on StandardView
 * 
 * @author ChornHulio (<a href="mailto:[chornhulio@web.de]">chornhulio@web.de</a>)
 * @since 0.1
 */
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
		if(strTags != null) {
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
}