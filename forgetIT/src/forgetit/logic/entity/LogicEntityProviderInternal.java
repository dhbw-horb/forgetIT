package forgetit.logic.entity;

import java.util.List;

import forgetit.common.Date;
import forgetit.common.Entity;
import forgetit.common.Tag;
import forgetit.db.DBNoteProvider;
import forgetit.db.IDBNoteProvider;
import forgetit.logic.interfaces.ILogicInternalEntityProvider;

/**
 * 
 * @author David Henn
 * @date 2.3.2011
 * Implementation of @see ILogicInternalEntityProvider
 * @see ILogicInternalEntityProvider
 */
public class LogicEntityProviderInternal implements ILogicInternalEntityProvider {
	
	private IDBNoteProvider dbNoteProvider;
	
	public LogicEntityProviderInternal(){
		dbNoteProvider = new DBNoteProvider();
	}

	@Override
	public List<Entity> getEntities() {
		return dbNoteProvider.getNotes();
	}

	@Override
	public List<Entity> getEntities(Date startDate, Date endDate) {
		//TODO check input
		return dbNoteProvider.getNotes(startDate, endDate);
	}

	@Override
	public List<Entity> getEntities(Date startDate, Date endDate, List<Tag> tags) {
		// TODO check input
		return dbNoteProvider.getNotes(startDate, endDate, tags);
	}

	@Override
	public List<Entity> getEntities(List<Tag> tags) {
		// TODO check input
		return dbNoteProvider.getNotes(tags);
	}

}
