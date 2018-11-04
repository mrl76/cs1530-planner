package cs1530.planner.calendar.time;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.Date;

public class Timetable {
	private Interval interval;
	private int intervalSize;
	private Date startDate, endDate;
	private boolean allDay;
	private boolean[] days;
	
	public Timetable(Interval interval, int intervalSize, Date startDate, Date endDate, boolean allDay, boolean[] days) {
		this.interval = interval;
		this.intervalSize = intervalSize;
		this.startDate = startDate;
		this.endDate = endDate;
		this.allDay = allDay;
		this.days = days;
	}
	
	public Timetable(Date startDate) {
		this(Interval.EVERY_N_DAYS, 1, startDate, startDate, false, new boolean[7]);
		Arrays.fill(days, true);
	}
	
	public String toString() {
		//TODO used for file saving
		return null;
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
