package forgetit.logic.interfaces;

import java.util.List;

import forgetit.common.Tag;

/**
 * 
 * @author David Henn
 * @date 1.3.2011
 * internal interface to be free from ILogicNote
 *
 */
public interface ILogicInternalTags {
	
	/**
	 * 
	 * @return all tags in the database
	 */
	public List<Tag> getTags();

}
