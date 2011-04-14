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

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import forgetit.gui.GraphicsController;

/**
 * The view for start and end date settings
 * 
 * The outer design (borders, titles, ...) of this view is dependent on StandardView
 * 
 * @author ChornHulio (<a href="mailto:[chornhulio@web.de]">chornhulio@web.de</a>)
 * @since 0.1
 */
public class ViewDate extends StandardView {
	
	Composite parent = null;
	GraphicsController controller = null;
	Text textStart = null;
	Text textEnd = null;

	public ViewDate(Composite parent, GraphicsController controller) {
		super(parent,"Date");
		this.parent = parent;
		this.controller = controller;
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
		// start
		Label labelStart = new Label(content, SWT.CENTER);
		labelStart.setText("Start:");
		textStart = new Text(content, SWT.SINGLE);
		textStart.setText(controller.getToday());
		textStart.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				textStart.setBackground(new Color(parent.getDisplay(),255,255,255));
				controller.setStartDate(textStart);
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				textStart.setBackground(new Color(parent.getDisplay(),240,240,240));
			}
		});		
		//end
		Label labelEnd = new Label(content, SWT.CENTER);
		labelEnd.setText("End:");
		textEnd = new Text(content, SWT.SINGLE);
		textEnd.setText(controller.getToday());	
		textEnd.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				textEnd.setBackground(new Color(parent.getDisplay(),255,255,255));
				controller.setEndDate(textEnd);
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				textEnd.setBackground(new Color(parent.getDisplay(),240,240,240));
			}
		});	
	}
}