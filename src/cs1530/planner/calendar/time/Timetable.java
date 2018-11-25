package cs1530.planner.calendar.time;

import cs1530.planner.util.Utils;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Timetable {
	private Interval interval;
	private int intervalSize;
	private Date startDate, previousDate, endDate;
	private boolean allDay;
	private boolean[] days;
	
	public Timetable(Interval interval, int intervalSize, Date startDate, Date endDate, boolean allDay, boolean[] days) {
		this.interval = interval;
		this.intervalSize = intervalSize;
		this.startDate = startDate;
		this.previousDate = startDate;
		this.endDate = endDate;
		this.allDay = allDay;
		this.days = days;
	}
	
	public Timetable(Date startDate) {
		this(Interval.EVERY_N_DAYS, 1, startDate, Utils.now(), false, new boolean[7]);
		Arrays.fill(days, true);
	}
	
	public Timetable(String dataString) {
		//TODO construct from valid data file string
		
	}
	
	public Date findNextTime() {
		Date now = Utils.now();
		Calendar c = Calendar.getInstance();
		c.setTime(previousDate);
		int calInt, fixedSize = intervalSize;
		switch(interval) {
		case EVERY_N_MONTHS:
			calInt = Calendar.MONTH;
			break;
		case EVERY_N_YEARS:
			calInt = Calendar.YEAR;
			break;
		default:
			if(interval == Interval.EVERY_N_WEEKS)
				fixedSize = intervalSize * 7;
			calInt = Calendar.DATE;
			break;
		}
		for(int i = 0; i < 400; i++) {
			if(c.after(endDate))
				return null;
			if(c.after(now) && days[c.get(Calendar.DAY_OF_WEEK) - 1])
				break;
			c.add(calInt, fixedSize);
		}
		return c.getTime();
	}
	
	public void ping() {
		this.previousDate = Utils.now();
	}
	
	public String toString() {
		String daysString = Utils.toFileString(",", days[0], days[1], days[2], days[3], days[4], days[5], days[6]);
		return Utils.toFileString(";t;", interval.name(), intervalSize, startDate.getTime(), endDate.getTime(), allDay, daysString);
	}
	
	public Interval getInterval() {
		return interval;
	}
	
	public void setInterval(Interval interval) {
		this.interval = interval;
	}
	
	public int getIntervalSize() {
		return intervalSize;
	}
	
	public void setIntervalSize(int intervalSize) {
		this.intervalSize = intervalSize;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public boolean isAllDay() {
		return allDay;
	}
	
	public void setAllDay(boolean allDay) {
		this.allDay = allDay;
	}
	
	public boolean isDayOpen(DayOfWeek day) {
		return days[day.getValue() % 7];
	}
	
	public void setDay(DayOfWeek day, boolean open) {
		days[day.getValue() % 7] = open;
	}
}
