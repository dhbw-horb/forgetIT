package forgetit.logic;

import forgetit.common.Entity;
import forgetit.logic.entity.LogicEntityInternal;
import forgetit.logic.interfaces.ILogicInternalEntity;

/**
 * 
 * @author David Henn
 * @date 1.3.2011
 * Implementation of ILogicEntity
 * @see ILogicEntity
 *
 */

public class LogicEntity implements ILogicEntity {
	
	private ILogicInternalEntity internalEntity;
	public LogicEntity(){
		internalEntity = new LogicEntityInternal();
	}

	@Override
	public void addEntity(Entity note) {
		internalEntity.addEntity(note);
		

	}

	@Override
	public void deleteEntity(Entity note) {
		internalEntity.deleteEntity(note);

	}

	@Override
	public void changeEntity(Entity note) {
		internalEntity.changeEntity(note);

	}

}
