package forgetit.common;

import forgetit.gui.GraphicsController;
import forgetit.logic.ILogicNote;
import forgetit.logic.ILogicNoteProvider;
import forgetit.logic.ILogicTags;
import forgetit.logic.LogicNote;
import forgetit.logic.LogicNoteProvider;
import forgetit.logic.LogicTags;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ILogicTags lt = new LogicTags();
		ILogicNote ln = new LogicNote();
		ILogicNoteProvider lnProvider = new LogicNoteProvider();
		new GraphicsController(lt, ln, lnProvider);
	}
}
