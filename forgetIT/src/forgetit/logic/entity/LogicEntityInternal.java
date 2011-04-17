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

import forgetit.common.Entity;
import forgetit.db.DBEntityHandler;
import forgetit.db.IDBEntity;
import forgetit.logic.LogicEntity;
import forgetit.logic.interfaces.ILogicInternalEntity;

/**
 * 
 * @author David Henn
 * @date 2.3.2011
 * implementation of @see ILogicInternalEntity
 * @see ILogicInternalEntity
 */
public class LogicEntityInternal implements ILogicInternalEntity{
	
	private DBEntityHandler dbEntity;
	
	public LogicEntityInternal(){
		try{
			dbEntity = new DBEntityHandler();
		}catch(Exception e){
			System.err.println("Can't initiate DBEntityHandler");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void addEntity(Entity entity) {
		//TODO add check input
		try{
			dbEntity.addEntity(entity);
		}catch(Exception e){
			System.err.println("Can't add Entity");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void deleteEntity(Entity entity) {
		//TODO check input
		try{
			dbEntity.deleteEntity(entity);
		}catch(Exception e){
			System.err.println("Can't delete Entity");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		
	}

	@Override
	public void changeEntity(Entity entity) {
		//TODO check input
		try{
			dbEntity.editEntity(entity);
		}catch(Exception e){
			System.err.println("Can't change Entity");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		
	}

}
