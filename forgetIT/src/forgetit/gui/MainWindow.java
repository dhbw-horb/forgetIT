package forgetit.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import forgetit.gui.views.IEntitiesView;
import forgetit.gui.views.ViewCalendar;
import forgetit.gui.views.ViewDate;
import forgetit.gui.views.ViewNotes;
import forgetit.gui.views.ViewTags;
import forgetit.gui.views.ViewTodo;

public class MainWindow {
	
	private Shell shell = null;
	private Display display = null;
	private GraphicsController controller = null;
	
	public MainWindow(Display display, GraphicsController graphicsController) {
		// set controller and display
		this.controller = graphicsController;
		this.display = display;
		
		// main window
		shell = new Shell(display);
		shell.setText("forgetIT");
		
		// define outter layout
		GridLayout outterLayout = new GridLayout();		
		outterLayout.numColumns = 8;
		shell.setLayout(outterLayout);

		// init row by row
		initFirstRow();
		initSecondRow();
		initContentView();

		// resize shell to contents
        shell.pack();
        // open shell
		shell.open();
	}
	
	private void initFirstRow() {
		// searchBar
		GridData gridData = new GridData(GridData.FILL, GridData.FILL, true, false);
		gridData.horizontalSpan = 6;
		Text text = new Text(shell, SWT.SINGLE);		
		text.setLayoutData(gridData);
		
		// add button
		gridData = new GridData(GridData.END, GridData.END, false, false);
		Button add = new Button(shell, SWT.PUSH);
		add.setLayoutData(gridData);
		add.setImage(new Image(shell.getDisplay(), "res/addIcon.png"));
		add.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                // TODO show Dialog for adding entities
            }
        });		
		
		// settings button
		gridData = new GridData(GridData.END, GridData.END, false, false);
		Button settings = new Button(shell, SWT.PUSH);
		settings.setLayoutData(gridData);
		settings.setImage(new Image(shell.getDisplay(), "res/settingsIcon.png"));
		settings.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                // TODO show Dialog for settings
            }
        });		
	}
	
	private void initSecondRow() {
		// date
		GridData gridData = new GridData(GridData.BEGINNING,GridData.BEGINNING,false,false);
		gridData.horizontalSpan = 3;
		gridData.verticalSpan = 3;
		Composite comDate = new Composite(shell, SWT.NONE);
		comDate.setLayoutData(gridData);
		comDate.setLayout(new FillLayout());
		new ViewDate(comDate, controller);
		
		// tags
		gridData = new GridData(GridData.FILL,GridData.BEGINNING,true,false);
		gridData.horizontalSpan = 5;
		gridData.verticalSpan = 3;
		Composite comTags = new Composite(shell, SWT.NONE);
		comTags.setLayoutData(gridData);
		comTags.setLayout(new FillLayout());
		new ViewTags(comTags, controller);
	}

	private void initContentView() {
		// calendar
		GridData gridData = new GridData(GridData.FILL,GridData.FILL,true,true);
		gridData.horizontalSpan = 4;
		gridData.verticalSpan = 8;
		Composite comCal = new Composite(shell, SWT.NONE);
		comCal.setLayoutData(gridData);
		comCal.setLayout(new FillLayout());
		controller.addEntitiesView(new ViewCalendar(comCal));
		
		// todos
		gridData = new GridData(GridData.FILL,GridData.FILL,true,true);
		gridData.horizontalSpan = 4;
		gridData.verticalSpan = 4;
		Composite comTodo = new Composite(shell, SWT.NONE);
		comTodo.setLayoutData(gridData);
		comTodo.setLayout(new FillLayout());		
		controller.addEntitiesView(new ViewTodo(comTodo));
		
		// notes
		gridData = new GridData(GridData.FILL,GridData.FILL,true,true);
		gridData.horizontalSpan = 4;
		gridData.verticalSpan = 4;
		Composite comNotes = new Composite(shell, SWT.NONE);
		comNotes.setLayoutData(gridData);
		comNotes.setLayout(new FillLayout());
		controller.addEntitiesView(new ViewNotes(comNotes));
	}	
	
	public void waitForDispose() {
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}