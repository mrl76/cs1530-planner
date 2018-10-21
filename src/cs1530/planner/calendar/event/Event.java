package cs1530.planner.calendar.event;

import cs1530.planner.calendar.time.Timetable;
import cs1530.planner.util.Utils;

public abstract class Event {
	private String name, description;
	private Timetable timetable;
	
	public Event(String name, String description, Timetable timetable) {
		this.name = name;
		this.description = description;
		this.timetable = timetable;
	}
	
	public Event(String name) {
		this(name, "", new Timetable(Utils.now()));
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Timetable getTimetable() {
		return timetable;
	}
	
	public void setTimetable(Timetable timetable) {
		this.timetable = timetable;
	}
}
