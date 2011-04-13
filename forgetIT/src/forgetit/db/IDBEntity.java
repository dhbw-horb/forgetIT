package forgetit.db;

import forgetit.common.Entity;

/**
 * 
 * @author David Henn
 * @date 2.3.2011
 * This Interface provides methods to manage notes
 *
 */
public interface IDBEntity {

	/**
	 * 
	 * @param note the note to be added
	 */
	public void addEntity(Entity note);
	/**
	 * 
	 * @param note the note, which should be deleted
	 */
	public void deleteEntity(Entity note);
	/**
	 * Update an existing note
	 * @param note the note you've changed
	 */
	public void editEntity(Entity note);
}
