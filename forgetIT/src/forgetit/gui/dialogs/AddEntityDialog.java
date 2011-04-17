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

package forgetit.gui.dialogs;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import forgetit.common.Category;
import forgetit.common.Date;
import forgetit.common.Entity;
import forgetit.common.Function;
import forgetit.common.Tag;
import forgetit.logic.Calendar;

/**
 * A dialog for adding entities
 * 
 * @author ChornHulio (<a href="mailto:[chornhulio@web.de]">chornhulio@web.de</a>)
 * @since 0.1
 */
public class AddEntityDialog extends Dialog {

	private Shell shell = null;
	private Entity entity = null;
	private String startDate = null;
	private String endDate = null;

	/**
	 * @param parent
	 */
	public AddEntityDialog(Shell parent) {
		super(parent);
		entity = new Entity();
		startDate = "";
		endDate = "";
	}

	/**
	 * Makes the dialog visible.
	 * 
	 * @return title
	 */
	public Entity open() {
		Shell parent = getParent();
		shell = new Shell(parent, SWT.TITLE | SWT.BORDER | SWT.APPLICATION_MODAL);
		shell.setText("Add an Entity");

		shell.setLayout(new GridLayout(2, true));

		inputCategory();
		inputTitle();
		inputDescription();
		inputStartDate();
		inputEndDate();
		inputTags();
		buttons();
		
		// TODO delete dummy and replace it
		Function func = new Function();
		List<Integer> coef = new LinkedList<Integer>();
		coef.add(1);
		func.setCoefficients(coef);    
		entity.setPriority(func);
		// End of dummy

		shell.addListener(SWT.Traverse, new Listener() {
			public void handleEvent(Event event) {
				if (event.detail == SWT.TRAVERSE_ESCAPE)
					event.doit = false;
			}
		});

		shell.pack();
		shell.open();

		Display display = parent.getDisplay();
		while (!shell.isDisposed()) {
			// check dates
			Calendar cal = new Calendar();
			// startDate
			try {
				Date newDate = cal.convertStringToDate(startDate);
				entity.setStartDate(newDate);
			} catch (Exception e) {
				entity.setStartDate(cal.today());
			}
			// endDate
			try {
				Date newDate = cal.convertStringToDate(endDate);
				// TODO check if endDate is after startDate
				entity.setEndDate(newDate);
			} catch (Exception e) {
				entity.setEndDate(entity.getStartDate());
			}
			
			if (!display.readAndDispatch())
				display.sleep();
		}
		return entity;
	}
	
	private void inputCategory() {		
		Label label = new Label(shell, SWT.NULL);
		label.setText("Category:");
		
		final Combo combo = new Combo (shell, SWT.DROP_DOWN | SWT.READ_ONLY);
		combo.setItems(new String [] {"Appointment", "Todo", "Note"});
		combo.select(0);
		entity.setCategory(Category.APPOINTMENT);

		combo.addListener(SWT.Selection, new Listener () {
			public void handleEvent (Event e) {
				int index = combo.indexOf(combo.getText());
				switch(index) {
				case 0:
					entity.setCategory(Category.APPOINTMENT);
					break;
				case 1:
					entity.setCategory(Category.TODO);
					break;
				case 2:
					entity.setCategory(Category.NOTE);
					break;
				}
			}
		});
	}

	private void inputTitle() {
		Label label = new Label(shell, SWT.NULL);
		label.setText("Title:");

		final Text text = new Text(shell, SWT.SINGLE | SWT.BORDER);
		text.setText("");
		entity.setTitle("");

		text.addListener(SWT.Modify, new Listener() {
			public void handleEvent(Event event) {
				entity.setTitle(text.getText());
			}
		});
	}
	
	private void inputDescription() {
		Label label = new Label(shell, SWT.NULL);
		label.setText("Description:");

		final Text text = new Text(shell, SWT.SINGLE | SWT.BORDER);
		text.setText("");
		entity.setDescription("");

		text.addListener(SWT.Modify, new Listener() {
			public void handleEvent(Event event) {
				entity.setDescription(text.getText());
			}
		});
	}
	
	private void inputStartDate() {
		Label label = new Label(shell, SWT.NULL);
		label.setText("Start:");

		final Text text = new Text(shell, SWT.SINGLE | SWT.BORDER);
		Calendar cal = new Calendar();
		entity.setStartDate(cal.today());
		text.setText(cal.convertDateToStringInGermanStyle(entity.getStartDate()));
		startDate = text.getText();

		text.addListener(SWT.Modify, new Listener() {
			public void handleEvent(Event event) {
				startDate = text.getText();
			}
		});
	}
	
	private void inputEndDate() {
		Label label = new Label(shell, SWT.NULL);
		label.setText("End:");

		final Text text = new Text(shell, SWT.SINGLE | SWT.BORDER);
		Calendar cal = new Calendar();
		entity.setEndDate(cal.today());
		text.setText(cal.convertDateToStringInGermanStyle(entity.getEndDate()));
		endDate = text.getText();

		text.addListener(SWT.Modify, new Listener() {
			public void handleEvent(Event event) {
				endDate = text.getText();
			}
		});
	}
	
	private void inputTags() {		
		Label label = new Label(shell, SWT.NULL);
		label.setText("Tags:");
		
		final Combo combo = new Combo (shell, SWT.DROP_DOWN | SWT.READ_ONLY);
		combo.setItems(new String [] {"Study", "Work", "Personal"});
		combo.select(0);
		final List<Tag> tags = new LinkedList<Tag>();
		tags.add(new Tag(0, "Study", "Description of Study"));
		entity.setTags(tags);

		combo.addListener(SWT.Selection, new Listener () {
			public void handleEvent (Event e) {
				int index = combo.indexOf(combo.getText());
				switch(index) {
				case 0:
					tags.clear();
					tags.add(new Tag(0, "Study", "Description of Study"));
					entity.setTags(tags);
					break;
				case 1:
					tags.clear();
					tags.add(new Tag(1, "Work", "Description of Work"));
					entity.setTags(tags);
					break;
				case 2:
					tags.clear();
					tags.add(new Tag(2, "Personal", "Description of Personal"));
					entity.setTags(tags);
					break;
				}
			}
		});
	}

	private void buttons() {
		Button buttonOK = new Button(shell, SWT.PUSH);
		buttonOK.setText("Ok");
		buttonOK.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_END));
		Button buttonCancel = new Button(shell, SWT.PUSH);
		buttonCancel.setText("Cancel");

		buttonOK.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				shell.dispose();
			}
		});

		buttonCancel.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				entity = null;
				shell.dispose();
			}
		});
	}
}
