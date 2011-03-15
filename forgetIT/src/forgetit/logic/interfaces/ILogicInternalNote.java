package forgetit.logic.interfaces;

import forgetit.common.Entity;

/**
 * 
 * @author David Henn
 * @date 1.3.2011
 * internal interface to be free from ILogicNote
 *
 */
public interface ILogicInternalNote {
	/**
	 * 
	 * @param note the note to be added
	 */
	public void addNote(Entity note);
	/**
	 * 
	 * @param note the note, which should be deleted
	 */
	public void deleteNode(Entity note);
	/**
	 * Update an existing note
	 * @param note the note you've changed
	 */
	public void changeNote(Entity note);
}
