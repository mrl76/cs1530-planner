package cs1530.planner.calendar.time;

import java.util.Calendar;

public enum Interval {
	DAYS(Calendar.DATE),
	WEEKS(Calendar.DATE),
	MONTHS(Calendar.MONTH),
	YEARS(Calendar.YEAR);
	
	private int calendar;
	
	Interval(int calendar) {
		this.calendar = calendar;
	}
	
	public int getCalendar() {
		return calendar;
	}
}
