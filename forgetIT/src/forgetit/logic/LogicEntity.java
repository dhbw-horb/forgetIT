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
package forgetit.logic;

import forgetit.common.Entity;
import forgetit.logic.entity.LogicEntityInternal;
import forgetit.logic.interfaces.ILogicInternalEntity;

/**
 * 
 * Implementation of @see ILogicEntity
 * @author David Henn (<a href="mailto:[david.henn@gmail.com]">david.henn@gmail.com</a>)
 * @version 0.1
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
