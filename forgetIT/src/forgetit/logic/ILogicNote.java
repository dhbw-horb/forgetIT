package forgetit.logic;

import forgetit.common.Note;

/**
 * 
 * @author David Henn
 * @date 1.3.2011
 * This Interface provides methods to manage notes
 *
 */

public interface ILogicNote {
	
	/**
	 * 
	 * @param note the note to be added
	 */
	public void addNote(Note note);
	/**
	 * 
	 * @param note the note, which should be deleted
	 */
	public void deleteNode(Note note);
	/**
	 * Update an existing note
	 * @param note the note you've changed
	 */
	public void changeNote(Note note);

}
