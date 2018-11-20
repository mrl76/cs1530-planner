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
	
	//new
	public void addAppointment(Appointment a){
		events.add(a);
	}
	
	//new
	public void removeAppointment(Appointment a){
		events.remove(a);
	}
	
	//new
	public SortedSet<Appointment> getAssignments(){
		SortedSet<Appointment> assignments = new TreeSet<>();
		
		for(Appointment appt: events){
			if(appt instanceof Assignment){
				assignments.add(appt);
			}
		}
		
		return assignments;
	}
	
	//new
	public SortedSet<Appointment> getExams(){
		SortedSet<Appointment> exams =  new TreeSet<>();
		
		for(Appointment appt: events){
			if(appt instanceof Exam){
				exams.add(appt);
			}
		}
		
		return exams;
	}
	
	/*new
	*reset date extracts all information into a new appointment then deletes the old appointment  
	*to add the newly created appointment in its place. This is because the date is what the appointments 
	*are comparable on in the set and its ordered so that is not able to be modified because 
	*sets are technically immutable I believe.  It needs to
	*be overloaded to be sure that all the data from the original  appointment is able to  be extracted to 
	*create a new identical event with a new date. Correct me if im wrong here.
	*/
	public void resetDate(Exam e, Date newDate){
		//get exam info
		String name = e.getName();
		String description = e.getDescription();
		Course course = e.getCourse();;

		//remove exam
		this.removeAppointment(e);
			
		//create new Exam and re-add to calendar
		Exam newExam = new Exam(name, description, newDate, course);
		this.addAppointment(newExam);
		
	}
	
	public void resetDate(Assignment a, Date newDate){
		System.out.println("nothing");
	}
	
	
}
