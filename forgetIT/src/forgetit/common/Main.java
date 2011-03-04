package forgetit.common;

import org.eclipse.swt.widgets.Display;

import forgetit.gui.MainWindow;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = new Display();
		new MainWindow(display);
		display.dispose();
	}
}
