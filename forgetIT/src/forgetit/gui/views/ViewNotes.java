package forgetit.gui.views;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import forgetit.common.Category;
import forgetit.common.Entity;

public class ViewNotes extends StandardView implements IEntitiesView {

	Composite parent;
	Table table;

	public ViewNotes(Composite parent) {
		super(parent, "Notes");
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
		String[] titles = {"Title", "Description"};
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
		
		// clear content of the table
		table.clearAll();

		// set content of the table
		for (Entity entity : entities) {
			TableItem item = new TableItem (table, SWT.NONE);
			item.setText (0, entity.getTitle());
			item.setText (1, entity.getDescription());
		}
		
		// resize columns
		for (int i=0; i < table.getColumnCount(); i++) {
			table.getColumn (i).pack ();
		}
	}

	@Override
	public Category getCategory() {
		return Category.NOTE;
	}

}