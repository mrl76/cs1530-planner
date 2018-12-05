package cs1530.planner.calendar;

import cs1530.planner.calendar.time.Timetable;
import cs1530.planner.database.Database;
import cs1530.planner.util.Utils;

public class Course {
	private String name, description;
	private Timetable timetable;
	
	public Course(String name, String description, Timetable timetable) {
		this.name = name;
		this.description = description;
		this.timetable = timetable;
	}
	
	public Course(String dataString) {
		String[] data = dataString.split(Database.COURSE_DELIM);
		if(data.length >= 1)
			name = data[0];
		if(data.length == 3) {
			description = data[1];
			timetable = new Timetable(data[2]);
		}
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
	
	@Override
	public String toString() {
		return Utils.toFileString(Database.COURSE_DELIM, name, description, timetable);
	}
}
