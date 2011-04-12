package forgetit.logic;

import java.util.List;

import forgetit.common.Tag;
import forgetit.logic.entity.LogicTagsInternal;
import forgetit.logic.interfaces.ILogicInternalTags;

/**
 * 
 * @author David Henn
 * @date 1.3.2011
 * Implementation of ILogicTags
 * @see ILogicTags
 *
 */
public class LogicTags implements ILogicTags {
	
	private ILogicInternalTags internalTags;
	public LogicTags(){
		internalTags = new LogicTagsInternal();
	}

	@Override
	public List<Tag> getTags() {
		return internalTags.getTags();
	}

}
