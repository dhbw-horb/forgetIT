package forgetit.logic;

import java.util.List;



import forgetit.common.Date;
import forgetit.common.Note;
import forgetit.common.Tag;
import forgetit.logic.interfaces.ILogicInternalNoteProvider;


/**
 * 
 * @author David Henn
 * @date 1.3.2011
 * Implementation of ILogicNoteProvider
 * @see ILogicNoteProvider
 *
 */
public class LogicNoteProvider implements ILogicNoteProvider {
	
	private ILogicInternalNoteProvider internalNoteProvider;
	public LogicNoteProvider(){
		//TODO create instance of ILogicInternalNoteProvider implementing class
	}

	@Override
	public List<Note> getNotes() {
		return internalNoteProvider.getNotes();
	}

	@Override
	public List<Note> getNotes(Date startDate, Date endDate) {
		return getNotes(startDate, endDate);
	}

	@Override
	public List<Note> getNotes(Date startDate, Date endDate, List<Tag> tags) {
		return internalNoteProvider.getNotes(startDate, endDate, tags);
	}

	@Override
	public List<Note> getNotes(List<Tag> tags) {
		return internalNoteProvider.getNotes(tags);
	}

}
