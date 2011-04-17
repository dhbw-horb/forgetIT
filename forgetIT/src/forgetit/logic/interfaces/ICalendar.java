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

import forgetit.common.Date;

/**
 * 
 * @author David Henn
 * this interface provides access to date calculations
 *
 */
public interface ICalendar {
	
	/**
	 * Checks if a given date is valid
	 * @param date the date to check
	 * @return true if valid
	 */
	public boolean checkDate(Date date);
	
	/**
	 * calculates the new date from a given date and a number of days
	 * @param days the days to add to the date
	 * @param date the date from which to start
	 * @return the new date
	 * @throws Exception if the given date isn't valid
	 */
	public Date addDays(int days, Date date) throws Exception;
	
	/**
	 * calculates the new date from a given date and a number of days
	 * @param days how many days before the given date
	 * @param date the date from which to start
	 * @return the new date
	 * @throws Exception if the given date isn't valid
	 */
	public Date subtractDays(int days, Date date) throws Exception;

	/**
	 * 
	 * @return the date of today
	 */
	public Date today();
	
	/**
	 * converts String in Date 
	 * 
	 * possible strings are YYYY.MM.DD or DD.MM.YYYY
	 * chars between digits don't care
	 * 
	 * @param str the date as a String
	 * @return the date
	 * @throws IllegalArgumentException if the string is no date
	 * @throws NumberFormatException if the parts of the string are not convertable
	 */
	public Date convertStringToDate(String str) throws IllegalArgumentException, NumberFormatException;
	
	/**
	 * converts a Date to a String in US style
	 * @param date the date
	 * @return the date as string
	 */
	public String convertDateToStringInUSStyle(Date date);
	
	/**
	 * converts a Date to a String in german style
	 * @param date the date
	 * @return the date as string
	 */
	public String convertDateToStringInGermanStyle(Date date);
}
