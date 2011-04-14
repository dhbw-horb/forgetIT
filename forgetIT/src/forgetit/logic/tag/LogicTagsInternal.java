package forgetit.logic.tag;

import java.util.List;

import forgetit.common.Tag;
import forgetit.db.DBTags;
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
	
	public LogicTagsInternal() {
		try{
			dbTags = new DBTags();
		}catch(Exception e){
			System.err.println("Can't instantiate DBTags");
			System.err.println(e.getMessage());
			e.printStackTrace();
			
		}
	}

	@Override
	public List<Tag> getTags() {
		try{
			return dbTags.getTags();
		}catch(Exception e){
			System.err.println("Can't get Tags");
			System.err.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
		
			
	}

}
