package cs1530.planner.calendar.time;

import cs1530.planner.util.Utils;

import java.util.Calendar;
import java.util.Date;

public class Timetable {
	private Date startDate, previousDate, nextDate, endDate;
	private int intervalSize;
	private Interval interval;
	private boolean repeating, allDay;
	
	public Timetable(Date startDate, Date previousDate, Date nextDate, Date endDate, boolean repeating, int intervalSize, Interval interval, boolean allDay) {
		this.startDate = startDate;
		this.previousDate = previousDate;
		this.nextDate = nextDate;
		this.endDate = endDate;
		this.repeating = repeating;
		this.intervalSize = intervalSize;
		this.interval = interval;
		this.allDay = allDay;
	}
	
	public Timetable(Date startDate) {
		this(startDate, startDate, null, startDate, false, 1, Interval.DAYS, false);
	}
	
	public Timetable(String dataString) {
		String[] data = dataString.split(";t;");
		assert(data.length == 8);
		this.startDate = new Date(Long.valueOf(data[0]));
		this.previousDate = new Date(Long.valueOf(data[1]));
		this.nextDate = (data[2].equals("null") ? null : new Date(Long.valueOf(data[2])));
		this.endDate = (data[3].equals("null") ? null : new Date(Long.valueOf(data[3])));
		this.intervalSize = Integer.valueOf(data[4]);
		this.interval = Interval.valueOf(data[5]);
		this.repeating = Boolean.valueOf(data[6]);
		this.allDay = Boolean.valueOf(data[7]);
	}
	
	public String toString() {
		return Utils.toFileString(";t;",
				startDate.getTime(),
				previousDate.getTime(),
				nextDate == null ? null : nextDate.getTime(),
				endDate == null ? null : endDate.getTime(),
				intervalSize,
				interval.toString(),
				repeating,
				allDay
		);
	}
	
	public void ping() {
		this.previousDate = Utils.now();
		
		//find next available event date (within 400 iterations)
		if(!repeating) {
			nextDate = null;
			return;
		}
		Date now = Utils.now();
		Calendar c = Calendar.getInstance();
		c.setTime(previousDate);
		int calInt, fixedSize = intervalSize;
		switch(interval) {
		case MONTHS:
			calInt = Calendar.MONTH;
			break;
		case YEARS:
			calInt = Calendar.YEAR;
			break;
		default:
			if(interval == Interval.WEEKS)
				fixedSize = intervalSize * 7;
			calInt = Calendar.DATE;
			break;
		}
		for(int i = 0; i < 400; i++) {
			if(endDate != null && c.after(endDate)) {
				nextDate = null;
				return;
			}
			if(c.after(now))
				break;
			c.add(calInt, fixedSize);
		}
		nextDate = c.getTime();
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getNextDate() {
		return nextDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public boolean isRepeating() {
		return repeating;
	}
	
	public int getIntervalSize() {
		return intervalSize;
	}
	
	public void setIntervalSize(int intervalSize) {
		this.intervalSize = intervalSize;
	}
	
	public Interval getInterval() {
		return interval;
	}
	
	public void setInterval(Interval interval) {
		this.interval = interval;
	}
	
	public boolean isAllDay() {
		return allDay;
	}
	
	public void setAllDay(boolean allDay) {
		this.allDay = allDay;
	}
}
