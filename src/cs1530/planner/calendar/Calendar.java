package cs1530.planner.calendar;

import cs1530.planner.calendar.event.Appointment;
import cs1530.planner.calendar.event.Assignment;
import cs1530.planner.calendar.event.Exam;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Date;

public class Calendar {
	private final UserProfile profile;
	private Set<Course> courses;
	private SortedSet<Appointment> events;
	private SortedSet<Alarm> alarms;
	
	public Calendar(UserProfile profile) {
		this.profile = profile;
		this.courses = new HashSet<>();
		this.events = new TreeSet<>();
		this.alarms = new TreeSet<>();
	}
	
	public Set<Course> getCourses() {
		return courses;
	}
	
	public void addCourse(Course c) {
		courses.add(c);
		profile.saveCourses();
	}
	
	public void removeCourse(Course c) {
		courses.remove(c);
		profile.saveCourses();
	}
	
	public SortedSet<Appointment> getEvents() {
		return events;
	}
    
    public SortedSet<Alarm> getAlarms() {
        return alarms;
    }
	
	public void addAppointment(Appointment a){
		events.add(a);
		if(a instanceof Assignment)
			profile.saveAssignments();
		else if(a instanceof Exam)
			profile.saveExams();
		else
			profile.saveAppointments();
	}
	
	public void removeAppointment(Appointment a){
		events.remove(a);
		if(a instanceof Assignment)
			profile.saveAssignments();
		else if(a instanceof Exam)
			profile.saveExams();
		else
			profile.saveAppointments();
	}
	
	public SortedSet<Appointment> getAppointments() {
		SortedSet<Appointment> appointments = new TreeSet<>();
		for(Appointment a : events) {
			if(!(a instanceof Assignment) && !(a instanceof Exam))
				appointments.add(a);
		}
		return appointments;
	}
	
	public SortedSet<Assignment> getAssignments(){
		SortedSet<Assignment> assignments = new TreeSet<>();
		for(Appointment a : events) {
			if(a instanceof Assignment)
				assignments.add((Assignment) a);
		}
		return assignments;
	}
	
	public SortedSet<Exam> getExams(){
		SortedSet<Exam> exams =  new TreeSet<>();
		for(Appointment e : events) {
			if(e instanceof Exam)
				exams.add((Exam) e);
		}
		return exams;
	}
	
	/*
	*reset date extracts all information into a new appointment then deletes the old appointment  
	*to add the newly created appointment in its place. This is because the date is what the appointments 
	*are comparable on in the set and its ordered so that is not able to be modified because 
	*sets are technically immutable I believe.  It needs to
	*be overloaded to be sure that all the data from the original  appointment is able to  be extracted to 
	*create a new identical event with a new date. Correct me if im wrong here.
	*/
	public void resetDate(Exam e, Date newDate){
		e.setDate(newDate);
	}
	
	public void resetDate(Assignment a, Date newDate){
		a.setDate(newDate);
	}
}
