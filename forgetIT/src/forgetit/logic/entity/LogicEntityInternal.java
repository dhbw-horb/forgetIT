package forgetit.logic.entity;

import forgetit.common.Entity;
import forgetit.db.DBEntityHandler;
import forgetit.db.IDBEntity;
import forgetit.logic.LogicEntity;
import forgetit.logic.interfaces.ILogicInternalEntity;

/**
 * 
 * @author David Henn
 * @date 2.3.2011
 * implementation of @see ILogicInternalEntity
 * @see ILogicInternalEntity
 */
public class LogicEntityInternal implements ILogicInternalEntity{
	
	private DBEntityHandler dbEntity;
	
	public LogicEntityInternal(){
		try{
			dbEntity = new DBEntityHandler();
		}catch(Exception e){
			System.err.println("Can't initiate DBEntityHandler");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void addEntity(Entity entity) {
		//TODO add check input
		try{
			dbEntity.addEntity(entity);
		}catch(Exception e){
			System.err.println("Can't add Entity");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void deleteEntity(Entity entity) {
		//TODO check input
		try{
			dbEntity.deleteEntity(entity);
		}catch(Exception e){
			System.err.println("Can't delete Entity");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		
	}

	@Override
	public void changeEntity(Entity entity) {
		//TODO check input
		try{
			dbEntity.editEntity(entity);
		}catch(Exception e){
			System.err.println("Can't change Entity");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		
	}

}
