package forgetit.common;

import forgetit.gui.GraphicsController;
import forgetit.logic.Calendar;
import forgetit.logic.ILogicEntity;
import forgetit.logic.ILogicEntityProvider;
import forgetit.logic.ILogicTags;
import forgetit.logic.LogicEntity;
import forgetit.logic.LogicEntityProvider;
import forgetit.logic.LogicTags;
import forgetit.logic.interfaces.ICalendar;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ICalendar cal = new Calendar();
		ILogicTags lt = new LogicTags();
		ILogicEntity ln = new LogicEntity();
		ILogicEntityProvider lnProvider = new LogicEntityProvider();
		GraphicsController gui = new GraphicsController(lt, ln, lnProvider, cal);
		gui.waitForDispose();
	}
}
