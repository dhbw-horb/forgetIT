package forgetit.logic.interfaces;

import forgetit.common.Entity;

/**
 * 
 * @author David Henn
 * @date 1.3.2011
 * internal interface to be free from @see ILogicEntity
 *
 */
public interface ILogicInternalEntity {
	/**
	 * 
	 * @param entity the entity to be added
	 */
	public void addEntity(Entity entity);
	/**
	 * 
	 * @param entity the entity, which should be deleted
	 */
	public void deleteEntity(Entity entity);
	/**
	 * Update an existing entity
	 * @param entity the entity you've changed
	 */
	public void changeEntity(Entity entity);
}
