package forgetit.db;

import java.util.List;

import forgetit.common.Date;
import forgetit.common.Entity;
import forgetit.common.Tag;

/**
 * 
 * @author David Henn
 * @date 2.3.2011 This interface provides methods to retrieve notes from the database
 */
public interface IDBEntityProvider {
	/**
	 * 
	 * @return all notes from database
	 */
	public List<Entity> getEntities();

	/**
	 * 
	 * @param startDate
	 *            notes from this date
	 * @param endDate
	 *            to this date
	 * @return all notes between the given start and end date
	 */
	public List<Entity> getEntities(Date startDate, Date endDate);

	/**
	 * 
	 * @param startDate
	 *            notes from this date
	 * @param endDate
	 *            to this date
	 * @param tags
	 *            notes which are tagged with the tags in this list
	 * @return all notes betwenn the given start and end date, which are tagged with the given tags
	 */
	public List<Entity> getEntities(Date startDate, Date endDate, List<Tag> tags);

	/**
	 * 
	 * @param tags
	 *            the tags with which the note should be tagged
	 * @return all notes tagged with the given tags
	 */
	public List<Entity> getEntities(List<Tag> tags);



}
