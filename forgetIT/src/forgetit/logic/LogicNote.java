package forgetit.logic;

import forgetit.common.Note;
import forgetit.logic.interfaces.ILogicInternalNote;

/**
 * 
 * @author David Henn
 * @date 1.3.2011
 * Implementation of ILogicNote
 * @see ILogicNote
 *
 */

public class LogicNote implements ILogicNote {
	
	private ILogicInternalNote internalNote;
	public LogicNote(){
		//TODO Create an Instance of implementing class of ILogicInternalNote
	}

	@Override
	public void addNote(Note note) {
		internalNote.addNote(note);
		

	}

	@Override
	public void deleteNode(Note note) {
		internalNote.deleteNode(note);

	}

	@Override
	public void changeNote(Note note) {
		internalNote.changeNote(note);

	}

}
