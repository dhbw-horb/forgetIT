package forgetit.common;

import java.util.List;

import forgetit.db.DBEntityHandler;
import forgetit.db.DBEntityProvider;
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
		
		
		/*
		// Uncomment this to test the database
		DBEntityHandler handler = new DBEntityHandler();
		DBEntityProvider provider = new DBEntityProvider();
		List<Entity> entities = provider.getEntities();*/
		
		
		ICalendar cal = new Calendar();
		ILogicTags lt = new LogicTags();
		ILogicEntity ln = new LogicEntity();
		ILogicEntityProvider lnProvider = new LogicEntityProvider();
		GraphicsController gui = new GraphicsController(lt, ln, lnProvider, cal);
		gui.waitForDispose();
	}
}
