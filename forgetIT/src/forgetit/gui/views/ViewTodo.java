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
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import forgetit.common.Category;
import forgetit.common.Entity;
import forgetit.common.Function;

/**
 * The view for todos
 * 
 * The outer design (borders, titles, ...) of this view is dependent on StandardView.
 * Through IEntitiesView this view can be refreshed by GraphicsController.
 * 
 * @author ChornHulio (<a href="mailto:[chornhulio@web.de]">chornhulio@web.de</a>)
 * @since 0.1
 */
public class ViewTodo extends StandardView implements IEntitiesView {
	
	Composite parent;
	Table table;

	public ViewTodo(Composite parent) {
		super(parent,"ToDo");
		this.parent = parent;
		this.table = null;
		initGui();
	}
	
	private void initGui() {
		RowLayout layout = new RowLayout();
		layout.type = SWT.VERTICAL;
		content.setLayout(layout);
		
		// init a new table
		table = new Table (content, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
		table.setLinesVisible (true);
		table.setHeaderVisible (true);
		table.setVisible(false);
		
		
		// set titles of the table
		String[] titles = {"Title", "Priority"};
		for (int i=0; i < titles.length; i++) {
			TableColumn column = new TableColumn (table, SWT.NONE);
			column.setText (titles [i]);
		}
	}

	@Override
	public void refreshView(List<Entity> entities) {
		// if there is no entity, the table should not be visible
		if(entities.size() <= 0) {
			table.setVisible(false);
			return;
		} else if (!table.isVisible()) {
			table.setVisible(true);
		}
		
		// remove content of the table
		table.removeAll();
		
		// set new content of the table
		for (Entity entity : entities) {
			TableItem item = new TableItem (table, SWT.NONE);
			item.setText (0, entity.getTitle());
			item.setText (1, ""+entity.getPriority().getY(0));
		}
		
		// resize columns
		for (int i=0; i < table.getColumnCount(); i++) {
			table.getColumn(i).pack();
		}		
	}

	@Override
	public Category getCategory() {
		return Category.TODO;
	}
}
