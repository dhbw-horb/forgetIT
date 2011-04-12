package forgetit.logic.entity;

import java.util.List;

import forgetit.common.Tag;
import forgetit.db.IDBTags;
import forgetit.logic.interfaces.ILogicInternalTags;
/**
 * 
 * @author David Henn
 * @date 2.3.2011
 * Implementation of ILogicInternalTags
 * @see ILogicInternalTags
 *
 */
public class LogicTagsInternal implements ILogicInternalTags {
	
	private IDBTags dbTags;

	@Override
	public List<Tag> getTags() {
		
		return dbTags.getTags();
	}

}
