package forgetit.gui.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class StandardView extends Composite {
	
	private String title;
	private Label titleBar;
	
	private Composite parent;
	protected Composite content;	

	public StandardView(Composite parent, String title) {
		super(parent, SWT.BORDER);
		
		// init members
		this.title = title;
		this.parent = parent;
				
		// init layout
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		this.setLayout(layout);

		// init title bar
		initTitleBar();
		
		//  init content
		initContent();
	}

	private void initTitleBar() {
		// Title
		titleBar = new Label(this, SWT.CENTER);
		titleBar.setText(title);
		titleBar.setBackground(new Color(parent.getDisplay(),100,100,120));
		titleBar.setForeground(new Color(parent.getDisplay(),255,255,255));	
		
		// Layout
		GridData gridData = new GridData(GridData.FILL,GridData.BEGINNING,true,false);
		titleBar.setLayoutData(gridData);
	}
	
	private void initContent() {
		content = new Composite(this, SWT.NONE);
		
		// Layout
		GridData gridData = new GridData(GridData.FILL,GridData.FILL,true,true);
		content.setLayoutData(gridData);
	}
	
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(Composite content) {
		this.content = content;
	}

	/**
	 * @return the content
	 */
	public Composite getContent() {
		return content;
	}
	
	/**
	 * Set new titleBar colors
	 * 
	 * @param foreground foreground color
	 * @param background background color
	 */
	protected void setTitleBarColors(RGB foreground, RGB background) {
		if(foreground != null) {
			titleBar.setForeground(new Color(parent.getDisplay(),foreground));
		}
		if(background != null) {
			titleBar.setBackground(new Color(parent.getDisplay(),background));
		}
	}
}
