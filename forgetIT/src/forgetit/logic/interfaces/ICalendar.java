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
	 * @return
	 * @throws Exception if the given date isn't valid
	 */
	public Date subtractDays(int days, Date date) throws Exception;

	/**
	 * 
	 * @return the date of today
	 */
	public Date today();
}
