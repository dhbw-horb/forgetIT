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

package forgetit.db;

import java.util.List;

import forgetit.common.Date;
import forgetit.common.Entity;
import forgetit.common.Tag;

/**
 * 
 * @author David Henn
 * @date 2.3.2011 This interface provides methods to retrieve notes from the database
 */
public interface IDBEntityProvider {
	/**
	 * 
	 * @return all notes from database
	 */
	public List<Entity> getEntities();

	/**
	 * 
	 * @param startDate
	 *            notes from this date
	 * @param endDate
	 *            to this date
	 * @return all notes between the given start and end date
	 */
	public List<Entity> getEntities(Date startDate, Date endDate);

	/**
	 * 
	 * @param startDate
	 *            notes from this date
	 * @param endDate
	 *            to this date
	 * @param tags
	 *            notes which are tagged with the tags in this list
	 * @return all notes betwenn the given start and end date, which are tagged with the given tags
	 */
	public List<Entity> getEntities(Date startDate, Date endDate, List<Tag> tags);

	/**
	 * 
	 * @param tags
	 *            the tags with which the note should be tagged
	 * @return all notes tagged with the given tags
	 */
	public List<Entity> getEntities(List<Tag> tags);



}
