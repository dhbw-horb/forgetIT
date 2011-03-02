package forgetit.db;

import java.util.List;

import forgetit.common.Tag;
/**
 * 
 * @author David Henn
 * @date 2.3.2011
 * Interface to retrieve all existing tags
 * new tags are automatically created with new or updated notes
 *
 */
public interface IDBTags {
	/**
	 * 
	 * @return all tags in the database
	 */
	public List<Tag> getTags();
}
