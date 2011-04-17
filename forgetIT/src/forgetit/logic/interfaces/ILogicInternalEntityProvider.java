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

import java.util.List;

import forgetit.common.Date;
import forgetit.common.Entity;
import forgetit.common.Tag;

/**
 * 
 * @author David Henn
 * @date 1.3.2011
 * internal interface to be free from ILogicEntityProvider
 *
 */

public interface ILogicInternalEntityProvider {

	/**
	 * 
	 * @return all entities from database
	 */
	public List<Entity> getEntities();

	/**
	 * 
	 * @param startDate
	 *            entities from this date
	 * @param endDate
	 *            to this date
	 * @return all entities between the given start and end date
	 */
	public List<Entity> getEntities(Date startDate, Date endDate);

	/**
	 * 
	 * @param startDate
	 *            entities from this date
	 * @param endDate
	 *            to this date
	 * @param tags
	 *            entities which are tagged with the tags in this list
	 * @return all entities between the given start and end date, which are tagged
	 *         with the given tags
	 */
	public List<Entity> getEntities(Date startDate, Date endDate, List<Tag> tags);

	/**
	 * 
	 * @param tags
	 *            the tags with which the entities should be tagged
	 * @return all entities tagged with the given tags
	 */
	public List<Entity> getEntities(List<Tag> tags);

}
