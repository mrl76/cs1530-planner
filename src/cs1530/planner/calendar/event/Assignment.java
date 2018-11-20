package cs1530.planner.calendar.event;

import cs1530.planner.calendar.Course;
import java.util.Date;

public class Assignment extends Appointment {
	private Course course;
	
	public Assignment(String name, String description, Date date, Course course){
		super(name, description, date);
		this.course = course;
	}
	
	public Assignment(String name, Course course) {
		super(name);
		this.course = course;
	}
	
	public Assignment(String name) {
		super(name);
	}
	
	public Course getCourse() {
		return course;
	}
	
	public void setCourse(Course course) {
		this.course = course;
	}
}
