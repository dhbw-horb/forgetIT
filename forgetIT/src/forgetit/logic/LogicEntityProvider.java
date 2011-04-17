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

import java.util.List;



import forgetit.common.Date;
import forgetit.common.Entity;
import forgetit.common.Tag;
import forgetit.logic.entity.LogicEntityProviderInternal;
import forgetit.logic.interfaces.ILogicInternalEntityProvider;


/**
 * 
 * @author David Henn
 * @date 1.3.2011
 * Implementation of ILogicEntityProvider
 * @see ILogicEntityProvider
 *
 */
public class LogicEntityProvider implements ILogicEntityProvider {
	
	private ILogicInternalEntityProvider internalEntityProvider;
	public LogicEntityProvider(){
		internalEntityProvider = new LogicEntityProviderInternal();
	}

	@Override
	public List<Entity> getEntities() {
		return internalEntityProvider.getEntities();
	}

	@Override
	public List<Entity> getEntities(Date startDate, Date endDate) {
		return internalEntityProvider.getEntities(startDate, endDate);
	}

	@Override
	public List<Entity> getEntities(Date startDate, Date endDate, List<Tag> tags) {
		return internalEntityProvider.getEntities(startDate, endDate, tags);
	}

	@Override
	public List<Entity> getEntities(List<Tag> tags) {
		return internalEntityProvider.getEntities(tags);
	}

}
