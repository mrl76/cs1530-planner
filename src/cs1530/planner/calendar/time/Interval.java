package cs1530.planner.calendar.time;

import java.util.Calendar;

public enum Interval {
	EVERY_N_DAYS(Calendar.DATE),
	EVERY_N_WEEKS(Calendar.DATE),
	EVERY_N_MONTHS(Calendar.MONTH),
	EVERY_N_YEARS(Calendar.YEAR);
	
	private int calendar;
	
	Interval(int calendar) {
		this.calendar = calendar;
	}
	
	public int getCalendar() {
		return calendar;
	}
}
