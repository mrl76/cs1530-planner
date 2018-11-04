package cs1530.planner.calendar.event;

import cs1530.planner.calendar.Course;

public class Exam extends Appointment {
	private Course course;
	
	public Exam(String name, Course course) {
		super(name);
		this.course = course;
	}
	
	public Exam(String name) {
		super(name);
	}
	
	public Course getCourse() {
		return course;
	}
	
	public void setCourse(Course course) {
		this.course = course;
	}
}
