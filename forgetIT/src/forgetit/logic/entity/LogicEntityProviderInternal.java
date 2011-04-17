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
package forgetit.logic.entity;

import java.util.List;

import forgetit.common.Date;
import forgetit.common.Entity;
import forgetit.common.Tag;
import forgetit.db.DBEntityProvider;
import forgetit.db.IDBEntityProvider;
import forgetit.logic.interfaces.ILogicInternalEntityProvider;

/**
 * 
 * @author David Henn
 * @date 2.3.2011
 * Implementation of @see ILogicInternalEntityProvider
 * @see ILogicInternalEntityProvider
 */
public class LogicEntityProviderInternal implements ILogicInternalEntityProvider {
	
	private IDBEntityProvider dbNoteProvider;
	
	public LogicEntityProviderInternal(){
		try{
			dbNoteProvider = new DBEntityProvider();
		}catch(Exception e){
			System.err.println("Can't instantiate DBEntityProvider");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public List<Entity> getEntities() {
		try{
			return dbNoteProvider.getEntities();
		}catch(Exception e){
			System.err.println("Can't get Entities");
			System.err.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Entity> getEntities(Date startDate, Date endDate) {
		//TODO check input
		try{
			return dbNoteProvider.getEntities(startDate, endDate);
		}catch(Exception e){
			System.err.println("Can't get Entities");
			System.err.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Entity> getEntities(Date startDate, Date endDate, List<Tag> tags) {
		// TODO check input
		try{
		return dbNoteProvider.getEntities(startDate, endDate, tags);
			}catch(Exception e){
			System.err.println("Can't get Entities");
			System.err.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Entity> getEntities(List<Tag> tags) {
		// TODO check input
		try{
			return dbNoteProvider.getEntities(tags);
		}catch(Exception e){
			System.err.println("Can't get Entities");
			System.err.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

}
