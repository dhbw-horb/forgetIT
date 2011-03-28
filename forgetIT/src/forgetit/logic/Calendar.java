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

}
