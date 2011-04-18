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

package forgetit.common;

import forgetit.gui.GraphicsController;
import forgetit.logic.Calendar;
import forgetit.logic.ILogicEntity;
import forgetit.logic.ILogicEntityProvider;
import forgetit.logic.ILogicTags;
import forgetit.logic.LogicEntity;
import forgetit.logic.LogicEntityProvider;
import forgetit.logic.LogicTags;
import forgetit.logic.interfaces.ICalendar;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		 * // Uncomment this to test the database DBEntityHandler handler = new DBEntityHandler(); DBEntityProvider
		 * provider = new DBEntityProvider(); List<Entity> entities = provider.getEntities();
		 */

		ICalendar cal = new Calendar();
		ILogicTags lt = new LogicTags();
		ILogicEntity ln = new LogicEntity();
		ILogicEntityProvider lnProvider = new LogicEntityProvider();
		GraphicsController gui = new GraphicsController(lt, ln, lnProvider, cal);
		gui.waitForDispose();
	}
}
