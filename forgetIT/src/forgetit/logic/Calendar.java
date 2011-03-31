package forgetit.logic;

import java.util.GregorianCalendar;
import java.util.TimeZone;

import forgetit.common.Date;
import forgetit.logic.interfaces.ICalendar;

public class Calendar implements ICalendar {

	@Override
	public boolean checkDate(Date date) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTimeZone( TimeZone.getTimeZone("CET") );
		cal.setLenient(false);
		cal.set(java.util.Calendar.YEAR, date.getYear());
		cal.set(java.util.Calendar.MONTH, date.getMonth());
		cal.set(java.util.Calendar.DAY_OF_MONTH, date.getDay());
		cal.set(java.util.Calendar.HOUR_OF_DAY, date.getHour());
		cal.set(java.util.Calendar.MINUTE, date.getMinute());
		
		boolean isValid = true;
		try{
			cal.getTimeInMillis();
		}catch(Exception e){
			isValid = false;
		}
		return isValid;
	}

	@Override
	public Date addDays(int days, Date date) throws Exception {
		
		if(!checkDate(date)){
			throw new Exception("Date isn't valid");
		}
		
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTimeZone( TimeZone.getTimeZone("CET") );
		cal.setLenient(false);
		cal.set(java.util.Calendar.YEAR, date.getYear());
		cal.set(java.util.Calendar.MONTH, date.getMonth());
		cal.set(java.util.Calendar.DAY_OF_MONTH, date.getDay());
		cal.set(java.util.Calendar.HOUR_OF_DAY, date.getHour());
		cal.set(java.util.Calendar.MINUTE, date.getMinute());
		
		cal.add(java.util.Calendar.DAY_OF_MONTH, days);
		
		Date laterDate = new Date(cal.get(java.util.Calendar.YEAR), cal.get(java.util.Calendar.MONTH), 
				cal.get(java.util.Calendar.DAY_OF_MONTH), cal.get(java.util.Calendar.HOUR_OF_DAY), cal.get(java.util.Calendar.MINUTE));
		return laterDate;
	}

	@Override
	public Date subtractDays(int days, Date date) throws Exception {
		if(!checkDate(date)){
			throw new Exception("Date isn't valid");
		}
		
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTimeZone( TimeZone.getTimeZone("CET") );
		cal.setLenient(false);
		cal.set(java.util.Calendar.YEAR, date.getYear());
		cal.set(java.util.Calendar.MONTH, date.getMonth());
		cal.set(java.util.Calendar.DAY_OF_MONTH, date.getDay());
		cal.set(java.util.Calendar.HOUR_OF_DAY, date.getHour());
		cal.set(java.util.Calendar.MINUTE, date.getMinute());
		
		cal.add(java.util.Calendar.DAY_OF_MONTH, -days);
		Date earlierDate = new Date(cal.get(java.util.Calendar.YEAR), cal.get(java.util.Calendar.MONTH), 
				cal.get(java.util.Calendar.DAY_OF_MONTH), cal.get(java.util.Calendar.HOUR_OF_DAY), cal.get(java.util.Calendar.MINUTE));
		return earlierDate;
	}
	
	@Override
	public Date today(){
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTimeZone( TimeZone.getTimeZone("CET") );
		Date date = new Date(cal.get(java.util.Calendar.YEAR), cal.get(java.util.Calendar.MONTH), 
				cal.get(java.util.Calendar.DAY_OF_MONTH),cal.get(java.util.Calendar.HOUR_OF_DAY),cal.get(java.util.Calendar.MINUTE));
		return date;
	}

	@Override
	public Date convertStringToDate(String str) throws IllegalArgumentException, NumberFormatException {
		// split the string at every non-digit (max four times)
		String strParts[] = str.split("\\D",4);
		
		// if there are not 3 parts, it's no date
		if(strParts.length != 3) {
			throw new IllegalArgumentException( "The string has not the right format" ); 
		}
		
		// convert to int
		int first = Integer.parseInt(strParts[0]);
		int month = Integer.parseInt(strParts[1]);
		int third = Integer.parseInt(strParts[2]);
		
		// interpret it
		if(month > 0 && month < 13) {
			if(first > 1969 && first < 2101) {
				// english date style (YYYY.MM.DD)
				if(third > 0 && third < 32) {
					return new Date(first, month, third, 0, 0);
				}
				
			} else if(first > 0 && first < 32) {
				// german date style (DD.MM.YYYY)
				if(third > 1969 && third < 2101) {
					return new Date(third, month, first, 0, 0);
				}
			} 
		} 
		
		// if you are here, an error occured		
		throw new IllegalArgumentException( "There are wrong values in the string" );
	}

	@Override
	public String convertDateToStringInUSStyle(Date date) {
		// year
		String str = "" + date.getYear();
		
		// month
		if(date.getMonth() <= 9) {
			str += ".0" + date.getMonth();
		} else {
			str += "." + date.getMonth();
		}
		
		// day
		if(date.getDay() <= 9) {
			str += ".0" + date.getDay();
		} else {
			str += "." + date.getDay();
		}
		
		return str;
	}

	@Override
	public String convertDateToStringInGermanStyle(Date date) {
		String str = "";
		
		// day
		if(date.getDay() <= 9) {
			str += "0" + date.getDay();
		} else {
			str += date.getDay();
		}
		
		// month
		if(date.getMonth() <= 9) {
			str += ".0" + date.getMonth();
		} else {
			str += "." + date.getMonth();
		}
		
		// year
		str += "." + date.getYear();
		
		return str;
	}
}
