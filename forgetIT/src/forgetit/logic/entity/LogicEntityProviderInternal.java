package forgetit.logic.entity;

import java.util.List;

import forgetit.common.Date;
import forgetit.common.Entity;
import forgetit.common.Tag;
import forgetit.db.DBEntityProvider;
import forgetit.db.IDBEntityProvider;
import forgetit.logic.interfaces.ILogicInternalEntityProvider;

/**
 * 
 * @author David Henn
 * @date 2.3.2011
 * Implementation of @see ILogicInternalEntityProvider
 * @see ILogicInternalEntityProvider
 */
public class LogicEntityProviderInternal implements ILogicInternalEntityProvider {
	
	private IDBEntityProvider dbNoteProvider;
	
	public LogicEntityProviderInternal(){
		try{
			dbNoteProvider = new DBEntityProvider();
		}catch(Exception e){
			System.err.println("Can't instantiate DBEntityProvider");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public List<Entity> getEntities() {
		try{
			return dbNoteProvider.getEntities();
		}catch(Exception e){
			System.err.println("Can't get Entities");
			System.err.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Entity> getEntities(Date startDate, Date endDate) {
		//TODO check input
		try{
			return dbNoteProvider.getEntities(startDate, endDate);
		}catch(Exception e){
			System.err.println("Can't get Entities");
			System.err.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Entity> getEntities(Date startDate, Date endDate, List<Tag> tags) {
		// TODO check input
		try{
		return dbNoteProvider.getEntities(startDate, endDate, tags);
			}catch(Exception e){
			System.err.println("Can't get Entities");
			System.err.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Entity> getEntities(List<Tag> tags) {
		// TODO check input
		try{
			return dbNoteProvider.getEntities(tags);
		}catch(Exception e){
			System.err.println("Can't get Entities");
			System.err.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

}
