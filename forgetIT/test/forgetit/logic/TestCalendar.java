package forgetit.logic;


import org.junit.Assert;
import org.junit.Test;

import forgetit.common.Date;


public class TestCalendar {
	
	@Test public void checkDate(){
		Calendar cal = new Calendar();
		
		boolean isValid1 = cal.checkDate(new Date(2011, 3, 28, 15, 14));
		Assert.assertTrue(isValid1);
		
		boolean isValid2 = cal.checkDate(new Date(2011, 3, 33, 0, 0));
		Assert.assertFalse(isValid2);
	}
	@Test public void addDays(){
		Calendar cal = new Calendar();
		Date shouldDate1 = new Date(2011, 5, 2, 0, 0);
		Date shouldDate2 = new Date(2011,6,1,0,0);
		try {
			Date isDate = cal.addDays(1, new Date(2011, 5, 1, 0, 0));
			Assert.assertEquals(shouldDate1, isDate);			
			
			isDate = cal.addDays(30, new Date(2011, 5, 1, 0, 0));	
			Assert.assertEquals(shouldDate2, isDate);
			
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
		
		
	}
	@Test public void subtractDays(){
		Calendar cal = new Calendar();
		Date shouldDate1 = new Date(2011, 5, 1, 0, 0);
		Date shouldDate2 = new Date(2011,5,1,0,0);
		try {
			Date isDate = cal.subtractDays(1, new Date(2011, 5, 2, 0, 0));
			Assert.assertEquals(shouldDate1, isDate);			
			
			isDate = cal.subtractDays(30, new Date(2011, 6, 1, 0, 0));
			Assert.assertEquals(shouldDate2, isDate);
			
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test public void today(){
		Calendar cal = new Calendar();
		Date today = cal.today();
		System.out.println(today.toString());
	}

}
