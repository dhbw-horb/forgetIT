package forgetit.common;
/**
 * 
 * @author David Henn
 * @date 1.3.2011
 * Date Object
 *
 */
public class Date {

	int year;
	int month;
	int day;
	int hour;
	int minute;
	
	public Date(int year, int month, int day, int hour, int minute){
		this.year = year; 
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.minute = minute;
	}
	
	public Date(){
		
	}
	
	@Override
	public String toString(){
		return year+"-"+month+"-"+day+"-"+hour+":"+minute;
	}
	@Override
	public boolean equals(Object date){
		if(date instanceof Date){
			boolean isEqual = true;
			Date compDate = (Date)date;
			if(this.year != compDate.getYear()){
				isEqual = false;
			}
			if(this.month != compDate.getMonth()){
				isEqual = false;
			}
			if(this.day != compDate.getDay()){
				isEqual = false;
			}
			if(this.hour != compDate.getHour()){
				isEqual = false;
			}
			if(this.minute != compDate.getMinute()){
				isEqual = false;
			}
			
			return isEqual;
		}else{
			return false;
		}
		
	}
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	
}
