package forgetit.common;

import forgetit.gui.GraphicsController;
import forgetit.logic.Calendar;
import forgetit.logic.ILogicNote;
import forgetit.logic.ILogicNoteProvider;
import forgetit.logic.ILogicTags;
import forgetit.logic.LogicNote;
import forgetit.logic.LogicNoteProvider;
import forgetit.logic.LogicTags;
import forgetit.logic.interfaces.ICalendar;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ICalendar cal = new Calendar();
		ILogicTags lt = new LogicTags();
		ILogicNote ln = new LogicNote();
		ILogicNoteProvider lnProvider = new LogicNoteProvider();
		GraphicsController gui = new GraphicsController(lt, ln, lnProvider, cal);
		gui.refreshViews();
	}
}
