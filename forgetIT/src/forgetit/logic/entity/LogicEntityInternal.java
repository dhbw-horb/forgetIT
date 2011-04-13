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
		dbEntity = new DBEntityHandler();
	}

	@Override
	public void addEntity(Entity entity) {
		//TODO add check input
		dbEntity.addEntity(entity);
	}

	@Override
	public void deleteEntity(Entity entity) {
		//TODO check input
		dbEntity.deleteEntity(entity);
		
	}

	@Override
	public void changeEntity(Entity entity) {
		//TODO check input
		dbEntity.editEntity(entity);
		
	}

}
