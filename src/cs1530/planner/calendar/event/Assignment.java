package cs1530.planner.calendar.event;

import cs1530.planner.calendar.Course;

public class Assignment extends Event {
	private Course course;
	
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
