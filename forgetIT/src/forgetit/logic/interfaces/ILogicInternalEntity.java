/*
 * Copyright 2011 DHBW Stuttgart Campus Horb
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either 
 * express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
