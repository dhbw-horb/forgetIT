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
package forgetit.logic.tag;

import java.util.List;

import forgetit.common.Tag;
import forgetit.db.DBTags;
import forgetit.db.IDBTags;
import forgetit.logic.interfaces.ILogicInternalTags;
/**
 * 
 * @author David Henn
 * @date 2.3.2011
 * Implementation of ILogicInternalTags
 * @see ILogicInternalTags
 *
 */
public class LogicTagsInternal implements ILogicInternalTags {
	
	private IDBTags dbTags;
	
	public LogicTagsInternal() {
		try{
			dbTags = new DBTags();
		}catch(Exception e){
			System.err.println("Can't instantiate DBTags");
			System.err.println(e.getMessage());
			e.printStackTrace();
			
		}
	}

	@Override
	public List<Tag> getTags() {
		try{
			return dbTags.getTags();
		}catch(Exception e){
			System.err.println("Can't get Tags");
			System.err.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
		
			
	}

}
