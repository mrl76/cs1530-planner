package cs1530.planner.calendar.event;

import cs1530.planner.database.Database;
import cs1530.planner.util.Utils;

import java.util.Date;

public class Exam extends Appointment {
	private String course;
	
	public Exam(String name, String description, Date date, String course){
		super(name, description, date);
		this.course = course;
	}
	
	public Exam(String dataString) {
		super("", "", null);
		String[] data = dataString.split(Database.EXAM_DELIM);
		if(data.length == 4) {
			name = data[0];
			description = data[1];
			date = new Date(Long.valueOf(data[2]));
			course = data[3];
		}
	}
	
	public String getCourse() {
		return course;
	}
	
	public void setCourse(String course) {
		this.course = course;
	}
	
	@Override
	public String toString() {
		return Utils.toFileString(Database.EXAM_DELIM, name, description, date.getTime(), course);
	}
}
