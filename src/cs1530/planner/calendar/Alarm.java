package cs1530.planner.calendar;

import cs1530.planner.calendar.time.Timetable;

import java.util.Date;

public class Alarm implements Comparable<Alarm> {
	private Timetable timetable;
	private int minutesWarning;
	private boolean enabled;
	
	public Alarm(Timetable timetable) {
		this(timetable, 0);
	}
	
	public Alarm(Timetable timetable, int minutesWarning) {
		this.timetable = timetable;
		this.minutesWarning = minutesWarning;
	}
	
	public Timetable getTimetable() {
		return timetable;
	}
	
	public void setTimetable(Timetable timetable) {
		this.timetable = timetable;
	}
	
	public int getMinutesWarning() {
		return minutesWarning;
	}
	
	public void setMinutesWarning(int minutesWarning) {
		this.minutesWarning = minutesWarning;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	@Override
	public int compareTo(Alarm o) {
		Date d1 = timetable.getNextDate();
		Date d2 = o.timetable.getNextDate();
		if(d1 == null || d2 == null)
			return 0;
		return d1.compareTo(d2);
	}
}
