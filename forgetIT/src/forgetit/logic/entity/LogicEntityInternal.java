package forgetit.logic.entity;

import forgetit.common.Entity;
import forgetit.db.DBNote;
import forgetit.db.IDBNote;
import forgetit.logic.interfaces.ILogicInternalEntity;

/**
 * 
 * @author David Henn
 * @date 2.3.2011
 * implementation of @see ILogicInternalEntity
 * @see ILogicInternalEntity
 */
public class LogicEntityInternal implements ILogicInternalEntity{
	
	private IDBNote dbNote;
	
	public LogicEntityInternal(){
		dbNote = new DBNote();
	}

	@Override
	public void addEntity(Entity entity) {
		//TODO add check input
		dbNote.addNote(entity);
	}

	@Override
	public void deleteEntity(Entity entity) {
		//TODO check input
		dbNote.deleteNode(entity);
		
	}

	@Override
	public void changeEntity(Entity entity) {
		//TODO check input
		dbNote.changeNote(entity);
		
	}

}
