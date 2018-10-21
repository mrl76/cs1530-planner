package cs1530.planner.calendar.time;

import java.util.Date;

public class Timetable {
	private Interval interval;
	private Date startDate, endDate;
	private boolean allDay;
	
	public Timetable(Interval interval, Date startDate, Date endDate, boolean allDay) {
		this.interval = interval;
		this.startDate = startDate;
		this.endDate = endDate;
		this.allDay = allDay;
	}
	
	public Timetable(Date startDate) {
		this(Interval.DAILY, startDate, startDate, false);
	}
	
	public Interval getInterval() {
		return interval;
	}
	
	public void setInterval(Interval interval) {
		this.interval = interval;
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
}
