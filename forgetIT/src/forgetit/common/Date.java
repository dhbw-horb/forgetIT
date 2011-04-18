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

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * 
 * @author David Henn
 * @date 1.3.2011 Date Object
 * 
 */
@javax.persistence.Entity
public class Date {

	@Id
	@GeneratedValue
	private int id;
	int year;
	int month;
	int day;
	int hour;
	int minute;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false)
	private forgetit.common.Entity entity_id;

	public Date(int year, int month, int day, int hour, int minute) {

		this.year = year;
		this.month = month + 1; // TODO check if this addition is ok
		this.day = day;
		this.hour = hour;
		this.minute = minute;
	}

	public Date() {

	}

	@Override
	public String toString() {

		return year + "-" + month + "-" + day + "-" + hour + ":" + minute;
	}

	@Override
	public boolean equals(Object date) {

		if (date instanceof Date) {
			boolean isEqual = true;
			Date compDate = (Date) date;
			if (this.year != compDate.getYear()) {
				isEqual = false;
			}
			if (this.month != compDate.getMonth()) {
				isEqual = false;
			}
			if (this.day != compDate.getDay()) {
				isEqual = false;
			}
			if (this.hour != compDate.getHour()) {
				isEqual = false;
			}
			if (this.minute != compDate.getMinute()) {
				isEqual = false;
			}

			return isEqual;
		} else {
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

	public void setId(int id) {

		this.id = id;
	}

	public int getId() {

		return id;
	}

}
