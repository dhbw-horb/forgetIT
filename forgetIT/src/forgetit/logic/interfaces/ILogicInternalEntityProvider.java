package forgetit.logic.interfaces;

import java.util.List;

import forgetit.common.Date;
import forgetit.common.Entity;
import forgetit.common.Tag;

/**
 * 
 * @author David Henn
 * @date 1.3.2011
 * internal interface to be free from ILogicEntityProvider
 *
 */

public interface ILogicInternalEntityProvider {

	/**
	 * 
	 * @return all entities from database
	 */
	public List<Entity> getEntities();

	/**
	 * 
	 * @param startDate
	 *            entities from this date
	 * @param endDate
	 *            to this date
	 * @return all entities between the given start and end date
	 */
	public List<Entity> getEntities(Date startDate, Date endDate);

	/**
	 * 
	 * @param startDate
	 *            entities from this date
	 * @param endDate
	 *            to this date
	 * @param tags
	 *            entities which are tagged with the tags in this list
	 * @return all entities between the given start and end date, which are tagged
	 *         with the given tags
	 */
	public List<Entity> getEntities(Date startDate, Date endDate, List<Tag> tags);

	/**
	 * 
	 * @param tags
	 *            the tags with which the entities should be tagged
	 * @return all entities tagged with the given tags
	 */
	public List<Entity> getEntities(List<Tag> tags);

}
