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

import forgetit.common.Tag;
import forgetit.logic.interfaces.ILogicInternalTags;
import forgetit.logic.tag.LogicTagsInternal;

/**
 * Implementation of @see ILogicTags
 * @author David Henn (<a href="mailto:[david.henn@gmail.com]">david.henn@gmail.com</a>)
 * @version 0.1
 */
public class LogicTags implements ILogicTags {
	
	private ILogicInternalTags internalTags;
	public LogicTags(){
		internalTags = new LogicTagsInternal();
	}

	@Override
	public List<Tag> getTags() {
		return internalTags.getTags();
	}

}
