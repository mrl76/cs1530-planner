package cs1530.planner.calendar;

import cs1530.planner.calendar.event.Appointment;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Calendar {
	private Set<Course> courses;
	private SortedSet<Appointment> events;
	
	public Calendar() {
		this.courses = new HashSet<>();
		this.events = new TreeSet<>();
	}
	
	public Set<Course> getCourses() {
		return courses;
	}
	
	public void addCourse(Course c) {
		courses.add(c);
	}
	
	public void removeCourse(Course c) {
		courses.remove(c);
	}
	
	public SortedSet<Appointment> getEvents() {
		return events;
	}
	
	public SortedSet<Appointment> getAssignments(){
		SortedSet<Appointment> assignments = new TreeSet<>();
		
		for(Appointment appt: events){
			if(appt instanceof Assignment){
				assignments.add(appt);
			}
		}
		
		return assignments;
	}
	
	public SortedSet<Appointment> getExams(){
		SortedSet<Appointment> exams =  new TreeSet<>();
		
		for(Appointment appt: events){
			if(appt instanceof Exam){
				exams.add(appt);
			}
		}
		
		return exams;
	}
}
