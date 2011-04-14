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
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import forgetit.common.Category;
import forgetit.common.Entity;
import forgetit.common.Function;
import forgetit.common.Tag;

/**
 * A dialog for adding entities
 * 
 * @author ChornHulio (<a href="mailto:[chornhulio@web.de]">chornhulio@web.de</a>)
 * @since 0.1
 */
public class AddEntityDialog extends Dialog {

	private Shell shell = null;
	private Entity entity = null;

	/**
	 * @param parent
	 */
	public AddEntityDialog(Shell parent) {
		super(parent);
		entity = new Entity();
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

		
		inputFieldTitle();
		inputFieldDescription();
		buttons();
		
		// TODO delete dummy and replace it
		Function func = new Function();
		List<Integer> coef = new LinkedList<Integer>();
		coef.add(1);
		func.setCoefficients(coef);    
		entity.setTitle("Test");
		entity.setCategory(Category.TODO);
		entity.setPriority(func);
		List<Tag> tags = new LinkedList<Tag>();
		tags.add(new Tag(0, "Study", "Description of Study"));
		entity.setTags(tags);
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
			if (!display.readAndDispatch())
				display.sleep();
		}
		return entity;
	}

	private void inputFieldTitle() {
		Label label = new Label(shell, SWT.NULL);
		label.setText("Title:");

		final Text text = new Text(shell, SWT.SINGLE | SWT.BORDER);
		text.setText("");

		text.addListener(SWT.Modify, new Listener() {
			public void handleEvent(Event event) {
				entity.setTitle(text.getText());
			}
		});
	}
	
	private void inputFieldDescription() {
		Label label = new Label(shell, SWT.NULL);
		label.setText("Description:");

		final Text text = new Text(shell, SWT.SINGLE | SWT.BORDER);
		text.setText("");

		text.addListener(SWT.Modify, new Listener() {
			public void handleEvent(Event event) {
				entity.setDescription(text.getText());
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
