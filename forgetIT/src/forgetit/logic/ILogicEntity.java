package forgetit.logic;

import forgetit.common.Entity;

/**
 * 
 * @author David Henn
 * @date 1.3.2011
 * This Interface provides methods to manage entities
 *
 */

public interface ILogicEntity {
	
	/**
	 * 
	 * @param entity the entity to be added
	 */
	public void addEntity(Entity entity);
	/**
	 * 
	 * @param entity the entity, which should be deleted
	 */
	public void deleteEntity(Entity note);
	/**
	 * Update an existing note
	 * @param entity the entity you've changed
	 */
	public void changeEntity(Entity entity);

}
