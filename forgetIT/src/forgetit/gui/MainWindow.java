package forgetit.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class MainWindow {
	
	private Shell shell = null;

	public MainWindow(Display display) {
		shell = new Shell(display);
		shell.setText("forgetIT");
		
		// set Layout
		GridLayout gridLayout = new GridLayout(5,true);
		shell.setLayout(gridLayout);
		
		// Color for widget
		Color wColor = new Color(display, 200, 200, 200);
		
		// Search
		Text search = new Text(shell, SWT.SINGLE);
		search.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 4, 1));
		
		// Settings
		Button settings = new Button(shell, SWT.PUSH);
		settings.setText("Settings");
		settings.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		settings.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                // TODO show Dialog for settings
            }
        });
		
		// space of time
		Label dates = new Label(shell, SWT.CENTER);
		dates.setText("Placeholder for space of time");
		dates.setBackground(wColor);
		dates.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 2, 3));
		
		// Tags
		Label tags = new Label(shell, SWT.CENTER);
		tags.setText("Placeholder for tags");
		tags.setBackground(wColor);
		tags.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 3, 3));
		
		// Calendar
		Label calendar = new Label(shell, SWT.CENTER);
		calendar.setText("Placeholder for the calendar");
		calendar.setBackground(wColor);
		calendar.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 2, 10));
		
		// To-Do
		Label todos = new Label(shell, SWT.CENTER);
		todos.setText("Placeholder for todos");
		todos.setBackground(wColor);
		todos.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 3, 5));
		
		// Notes
		Label notes = new Label(shell, SWT.CENTER);
		notes.setText("Placeholder for notes");
		notes.setBackground(wColor);
		notes.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 3, 5));

        // resize shell to contents
        shell.pack();
        // open shell
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

}
