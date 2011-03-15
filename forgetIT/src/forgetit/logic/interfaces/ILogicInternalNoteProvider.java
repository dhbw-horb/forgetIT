package forgetit.logic.interfaces;

import java.util.List;

import forgetit.common.Date;
import forgetit.common.Entity;
import forgetit.common.Tag;

/**
 * 
 * @author David Henn
 * @date 1.3.2011
 * internal interface to be free from ILogicNoteProvider
 *
 */

public interface ILogicInternalNoteProvider {

	/**
	 * 
	 * @return all notes from database
	 */
	public List<Entity> getNotes();

	/**
	 * 
	 * @param startDate
	 *            notes from this date
	 * @param endDate
	 *            to this date
	 * @return all notes between the given start and end date
	 */
	public List<Entity> getNotes(Date startDate, Date endDate);

	/**
	 * 
	 * @param startDate
	 *            notes from this date
	 * @param endDate
	 *            to this date
	 * @param tags
	 *            notes which are tagged with the tags in this list
	 * @return all notes betwenn the given start and end date, which are tagged
	 *         with the given tags
	 */
	public List<Entity> getNotes(Date startDate, Date endDate, List<Tag> tags);

	/**
	 * 
	 * @param tags
	 *            the tags with which the note should be tagged
	 * @return all notes tagged with the given tags
	 */
	public List<Entity> getNotes(List<Tag> tags);

}
